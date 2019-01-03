import com.antlr4.interAction.InterActionListener;
import com.antlr4.interAction.InterActionParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InterActionListenerImpl implements InterActionListener {

    private Queue<String> queue = new LinkedList<>();

    private Map<String, String> fieldMap = new HashMap<>();

    private boolean isSucess = true;

    public boolean isSucess() {
        return isSucess;
    }

    public void setSucess(boolean sucess) {
        isSucess = sucess;
    }

    public Map<String, String> getFieldMap(){
        return this.fieldMap;
    }

    public void clearQueueAndfieldMap(){
        this.queue.clear();
    }

    public void setFieldMap(Map<String,String> fieldMap){
        this.fieldMap = fieldMap;
    }

    public String mapToString(){
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

    private void addOperate(InterActionParser.ExprContext ctx){
        InterActionParser.ExprContext parent = (InterActionParser.ExprContext) ctx.getParent();
        if(parent != null && parent.getChild(2) != ctx && !parent.getChild(2).getText().trim().equals(")")){
            containsKeyAndAdd(parent.getChild(1).getText().trim());
        }
    }

    private void containsKeyAndAdd(String str){
        if(fieldMap.containsKey(str)){
            queue.offer(fieldMap.get(str));
        }else{
            setSucess(false);
        }
    }

    @Override
    public void enterLogicOperate(InterActionParser.LogicOperateContext ctx) {

    }

    @Override
    public void exitLogicOperate(InterActionParser.LogicOperateContext ctx) {

    }

    @Override
    public void enterAssignOperate(InterActionParser.AssignOperateContext ctx) {
        String[] firstChildArrByPoint = ctx.getChild(0).getText().trim().split("\\.");
        String[] SecondChildArrByPoint = ctx.getChild(2).getText().trim().split("\\.");
        containsKeyAndAdd(firstChildArrByPoint[firstChildArrByPoint.length-1].trim());
        containsKeyAndAdd(ctx.getChild(1).getText().trim());
        queue.offer("'" + SecondChildArrByPoint[SecondChildArrByPoint.length-1].trim() + "'");
    }

    @Override
    public void exitAssignOperate(InterActionParser.AssignOperateContext ctx) {
        addOperate(ctx);
    }

    @Override
    public void enterParents(InterActionParser.ParentsContext ctx) {
        queue.offer(ctx.getChild(0).getText().trim());
    }

    @Override
    public void exitParents(InterActionParser.ParentsContext ctx) {
        queue.offer(ctx.getChild(2).getText().trim());
        addOperate(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {
        setSucess(false);
    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
