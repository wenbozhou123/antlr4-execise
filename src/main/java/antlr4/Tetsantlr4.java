package antlr4;

import java.util.HashMap;
import java.util.Map;

public class Tetsantlr4 {

    public static void main(String[] args){
        Map<String, String> fieldMap = initMap();
        //String expr1="((interaction.approvalStatus == pending || interaction.approvalStatus == denied) && interaction.type == Service)||(interaction.status == Resolved && interaction.type == Service)||(interaction.status == Resolved && (interaction.type == Support || interaction.type == Self-service))||(interaction.status == Resolved && (interaction.type == Support || interaction.type == Self-service))||(interaction.status != Closed && (interaction.type == Support || interaction.type == Self-service))||(interaction.status == Resolved && interaction.type == Service)";
        String expr1= "((interaction.approvalStatus == pending || interaction.approvalStatus == denied) && interaction.type == Service)||(interaction.status == Resolved && interaction.type == Service)";
        String expr2= "(interaction.status==wzd)";
        FilterInterActionInbox filterInterActionInbox = new FilterInterActionInbox();
        String result2 = filterInterActionInbox.mapToSMField(expr2, fieldMap);

    }

    public static Map<String, String> initMap(){
        Map<String, String> fieldMap = new HashMap<String, String>();
        fieldMap.put("status","open");
        fieldMap.put("type","category");
        fieldMap.put("approvalStatus","approval.status");
        /*fieldMap.put("==","=");
        fieldMap.put("!=","~=");
        fieldMap.put("&&"," and ");
        fieldMap.put("||"," or ");*/
        return fieldMap;
    }
}
