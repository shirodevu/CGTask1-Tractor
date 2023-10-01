package ru.vsu;

import ru.vsu.elements.Apple;
import ru.vsu.elements.AppleTree;
import ru.vsu.elements.Leaf;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AppleUtils {
    private static final Random random = new Random();

    public static void generateApplesForTree(AppleTree tree, int appleCount) {
        int treeX = tree.getX();
        int treeY = tree.getY();
        int crownR = tree.getTreeCrownR();
        int appleR = tree.getAppleR();
        Color appleColor = tree.getAppleColor();

        // Вычисляем угол сектора
        double sectorAngle = 2 * Math.PI / appleCount;

        // Вычисляем радиус сектора
        double sectorRadius = random.nextInt(crownR / 2, crownR);

        for (int i = 0; i < appleCount; i++) {
            double appleAngle = sectorAngle * i + random.nextInt(5, 20) * sectorAngle;
            int appleX = (int) (treeX + sectorRadius * Math.cos(appleAngle));
            int appleY = (int) (treeY + sectorRadius * Math.sin(appleAngle));
            tree.addApple(new Apple(appleX, appleY, appleR, appleColor));
        }
    }
}
