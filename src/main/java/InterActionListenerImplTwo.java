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

public class InterActionListenerImplTwo implements InterActionListener {

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
        //queue.offer();

    }


    public void exitLogicOperate(LogicOperateContext ctx) {

    }


    public void enterAssignOperate(AssignOperateContext ctx) {

    }


    public void exitAssignOperate(AssignOperateContext ctx) {

    }

    /**
     * Enter a parse tree produced by the {@code parents}
     * labeled alternative in {@link InterActionParser#expr}.
     *
     * @param ctx the parse tree
     */
    public void enterParents(ParentsContext ctx) {

    }

    /**
     * Exit a parse tree produced by the {@code parents}
     * labeled alternative in {@link InterActionParser#expr}.
     *
     * @param ctx the parse tree
     */
    public void exitParents(ParentsContext ctx) {

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