package mapstuff;

import java.util.HashMap;
import java.util.Map;

public class MapMerge {
    
    public static void merge(Map<String, String> src, Map<String, String> dest) {
        src.forEach((k,v) -> {
            dest.merge(k, v, (v1, v2)-> v1 + ", " + v2);
        });
    }

    public static void main(String[] args) {
        Map<String, String> homeCal = new HashMap<>();
        Map<String, String> workCal = new HashMap<>();
        Map<String, String> combinedCal = new HashMap<>();
        
        homeCal.put("Today", "Clean up");
        homeCal.put("Tomorrow", "Party");
        workCal.put("Tomorrow", "Meeting");
        workCal.put("Yesterday", "Deadline");
        
        merge(homeCal, combinedCal);
        merge(workCal, combinedCal);
        
        combinedCal.forEach((k,v)->System.out.println("Todo " + k + ": " + v));
    }
}
