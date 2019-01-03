
import com.interActionInbox.InterActionLexer;
import com.interActionInbox.InterActionParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.HashMap;
import java.util.Map;

public class FilterInterActionInbox {
    private InterActionListenerImpl interActionListenerImpl = new InterActionListenerImpl();

    private Map<String, String> initMap(Map<String, String> fieldMap){
        if(fieldMap == null) {
            fieldMap = new HashMap<>();
        }
        fieldMap.put("==","=");
        fieldMap.put("!=","~=");
        fieldMap.put("&&"," and ");
        fieldMap.put("||"," or ");
        return fieldMap;
    }

    public String mapToSMField(String exprssion, Map<String, String> fieldMap){
        ParseTreeWalker walker = new ParseTreeWalker();
        InterActionParser parser = exprParser(exprssion);
        interActionListenerImpl.clearQueueAndfieldMap();
        interActionListenerImpl.setFieldMap(initMap(fieldMap));
        ParseTree tree = parser.expr();
        walker.walk(interActionListenerImpl, tree);
        return interActionListenerImpl.mapToString();
    }

    private InterActionParser exprParser(String expr){
        CharStream input = new ANTLRInputStream(expr);
        InterActionLexer lexer = new InterActionLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InterActionParser parser = new InterActionParser(tokens);
        /*parser.removeErrorListeners();
        parser.addErrorListener(new VerboseListener());*/
        return parser;
    }
}
