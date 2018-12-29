
import com.interActionInbox.InterActionListener;
import com.interActionInbox.InterActionParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static com.interActionInbox.InterActionParser.*;

public class InterActionListenerImpl implements InterActionListener {

    private Queue<String> queue = new LinkedList<>();

    private Map<String, String> fieldMap = new HashMap<>();

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    private boolean isSucess = true;

    public Map<String, String> getFieldMap() {
        return this.fieldMap;
    }

    public void clearQueueAndfieldMap() {
        this.queue.clear();
    }

    public void setFieldMap(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public String mapToString() {
        String str="";
        if(isSucess){
            for ( String q : queue){
                str += q;
            }
        }else{
            str = null;
        }
        setSucess(true);
        return str;
    }

    public void enterStr(StrContext ctx) {

    }


    public void exitStr(StrContext ctx) {

    }


    public void enterLogicOperate(LogicOperateContext ctx) {

    }


    public void exitLogicOperate(LogicOperateContext ctx) {
        addOperate(ctx);
    }


    public void enterAssignOperate(AssignOperateContext ctx) {
        String[] firstChildArrByPoint = ctx.getChild(0).getText().trim().split("\\.");
        String[] SecondChildArrByPoint = ctx.getChild(2).getText().trim().split("\\.");
        String keyStr = firstChildArrByPoint[firstChildArrByPoint.length-1].trim();
        if(fieldMap.containsKey(keyStr)){
            queue.offer(fieldMap.get(firstChildArrByPoint[firstChildArrByPoint.length-1].trim()));
        }else {
            setSucess(false);
        }
        queue.offer(fieldMap.getOrDefault(ctx.getChild(1).getText().trim(),ctx.getChild(1).getText().trim()));
        queue.offer("'" + fieldMap.getOrDefault(SecondChildArrByPoint[SecondChildArrByPoint.length-1],SecondChildArrByPoint[SecondChildArrByPoint.length-1].trim()) + "'");
    }


    public void exitAssignOperate(AssignOperateContext ctx) {
        addOperate(ctx);
    }

    private void addOperate(InterActionParser.ExprContext ctx){
        InterActionParser.ExprContext parent = (ExprContext) ctx.getParent();

        if(parent !=null){
            String logicOpreate = parent.getChild(2) != ctx && !parent.getChild(2).getText().trim().equals(")") ?
                    fieldMap.getOrDefault(parent.getChild(1).getText().trim(), parent.getChild(1).getText().trim()) : "";
            queue.offer(logicOpreate);
        }

    }

    /**
     * Enter a parse tree produced by the {@code parents}
     * labeled alternative in {@link InterActionParser#expr}.
     *
     * @param ctx the parse tree
     */
    public void enterParents(ParentsContext ctx) {
        queue.offer(ctx.getChild(0).getText().trim());
    }

    /**
     * Exit a parse tree produced by the {@code parents}
     * labeled alternative in {@link InterActionParser#expr}.
     *
     * @param ctx the parse tree
     */
    public void exitParents(ParentsContext ctx) {
        queue.offer(ctx.getChild(2).getText().trim());
        addOperate(ctx);
    }

    public void visitTerminal(TerminalNode terminalNode) {

    }

    public void visitErrorNode(ErrorNode errorNode) {
            setSucess(false);

    }

    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

}