package simplegen;

import java.awt.Color;

public class Shop {
    public static void main(String[] args) {
//        Pair<String> ps = new Pair<>("Hello", "World");
//        
//        String left = ps.getLeft();
        
        Pair<Shoe> pShoe = new Pair<>(new Shoe(10, Color.RED), new Shoe(10, Color.BLACK));
        System.out.println("Pair is matched? " + pShoe.match());
    }
}
