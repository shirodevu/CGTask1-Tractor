package ru.vsu;

import ru.vsu.elements.Leaf;
import ru.vsu.elements.LeafTree;

import java.awt.*;
import java.util.Random;

public class LeafUtils {
    private static final Random random = new Random();

    public static void generateLeafForTree(LeafTree tree, int leafCount) {
        int treeX = tree.getX();
        int treeY = tree.getY();
        int crownR = tree.getTreeCrownR();
        int leafR = tree.getLeafR();

        int crownStartX = treeX - crownR + 5;
        int crownStartY = treeY - crownR + 5;
        int crownDiameter = crownR * 2;

        for (int i = 0; i < leafCount; i++) {
            int leafX = crownStartX + random.nextInt(crownDiameter);
            int leafY = crownStartY + random.nextInt(crownDiameter);
            double rotation = random.nextInt(50);
            Color leafColor = new Color(78, 128 + random.nextInt(50), 48 + random.nextInt(50));

            double distanceFromCenter = Math.sqrt(Math.pow(leafX - treeX, 2) + Math.pow(leafY - treeY, 2));
            if (distanceFromCenter <= crownR) {
                tree.addLeaf(new Leaf(leafX, leafY, leafR, leafColor, rotation, crownR));
            }
        }
    }
    }

