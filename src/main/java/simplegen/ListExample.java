package simplegen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void messWithMyList(List l) {
        l.add(0, LocalDate.now());
    }
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l = Collections.checkedList(l, String.class);
        l.add("Hello");
        l.add("World");
//        l.add(LocalDateTime.now());
        messWithMyList(l);
//        String s = (String)l.get(0);
        String s = l.get(0);
//        List l = new ArrayList();
//        l.add("Hello");
//        l.add("World");
//        l.add(LocalDateTime.now());
//        
//        String s = (String)l.get(0);
    }
}
