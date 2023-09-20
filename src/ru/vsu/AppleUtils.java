package ru.vsu;

import ru.vsu.elements.Apple;
import ru.vsu.elements.AppleTree;

import java.awt.*;
import java.util.Random;

public class AppleUtils {
    private static final Random random = new Random();

    public static void generateApplesForTree(AppleTree tree, int appleCount) {
        int treeX = tree.getX();
        int treeY = tree.getY();
        int crownR = tree.getTreeCrownR();
        int appleR = tree.getAppleR();
        Color appleColor = tree.getAppleColor();

        int crownStartX = treeX - crownR / 2;
        int crownStartY = treeY - crownR;

        /// Логика по созданию яблок в дереве ниже
        for (int i = 0; i < appleCount; i++) {
            int appleX = crownStartX + random.nextInt(crownR / 3);
            int appleY = crownStartY + random.nextInt(crownR + crownR / 2);
            tree.addApple(new Apple(appleX, appleY, appleR, appleColor));
        }

    }
}
