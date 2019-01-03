import java.util.HashMap;
import java.util.Map;

public class Tetsantlr4 {

    public static void main(String[] args){
        Map<String, String> fieldMap = initMap();
        String expr1="d.status ?> KL";
        String expr2 = "interaction.status == Closed || interaction.approvalStatus = = pending";
        String expr3 = " ( interaction.status == Closed || interaction.approvalStatus==pending)";
        String expr4 = "(interaction.status == Closed || interaction.approvalStatus==pending) && category!==service catalog";
        String expr5 = "(interaction.status == Closed || interaction.approvalStatus===pending) && (category!=service catalog)";
        String expr6 = "(interaction.status == Closed) && (category!=service catalog)";
        String expr7 = "(interaction.status == Closed || interaction.approvalStatus==pending)&&(interaction.status == Closed || interaction.approvalStatus==pending";
        FilterInterActionInbox filterInterActionInbox = new FilterInterActionInbox();
        String result1 = filterInterActionInbox.mapToSMField(expr1, fieldMap);
        String result2 = filterInterActionInbox.mapToSMField(expr2, fieldMap);
        String result3 = filterInterActionInbox.mapToSMField(expr3, fieldMap);
        String result4 = filterInterActionInbox.mapToSMField(expr4, fieldMap);
        String result5 = filterInterActionInbox.mapToSMField(expr5, fieldMap);
        String result6 = filterInterActionInbox.mapToSMField(expr6, fieldMap);
        String result7 = filterInterActionInbox.mapToSMField(expr7, fieldMap);

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
