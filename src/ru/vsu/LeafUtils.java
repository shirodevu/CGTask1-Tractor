package ru.vsu;

import ru.vsu.elements.Leaf;

import java.util.ArrayList;
import java.util.List;

public class LeafUtils {
    private static List<Leaf> leaves;

    public LeafUtils(){
        leaves = new ArrayList<>();
        generateLeafTree(5);
    }

    private static void generateLeafTree(int leafNumber) {
        for (int i = 0; i < leafNumber; i++){
            leaves.add(new Leaf(0, 0, 10));
        }
    }
}
