import java.util.HashMap;
import java.util.Map;

public class Tetsantlr4 {

    public static void main(String[] args){
        Map<String, String> fieldMap = initMap();
        String expr1 = "inetaction.status!=Close";
        String expr2 = "(inetaction.status!=Close)";
        String expr3 = "interaction.status == Closed || interaction.approvalStatus==pending)&&interaction.status == Closed || interaction.approvalStatus==pending)";
        String expr4="(interaction.status == Closed)||ad.ad===a";
        FilterInterActionInbox filterInterActionInbox = new FilterInterActionInbox();
        String result1 = filterInterActionInbox.mapToSMField(expr1, fieldMap);
        String result2 = filterInterActionInbox.mapToSMField(expr2, fieldMap);
        String result3 = filterInterActionInbox.mapToSMField(expr3, fieldMap);
        String result4 = filterInterActionInbox.mapToSMField(expr4, fieldMap);


    }

    public static Map<String, String> initMap(){
        Map<String, String> fieldMap = new HashMap<String, String>();
        fieldMap.put("status","open");
        fieldMap.put("category","category");
        fieldMap.put("approvalStatus","approval.status");
        /*fieldMap.put("==","=");
        fieldMap.put("!=","~=");
        fieldMap.put("&&"," and ");
        fieldMap.put("||"," or ");*/
        return fieldMap;
    }
}
