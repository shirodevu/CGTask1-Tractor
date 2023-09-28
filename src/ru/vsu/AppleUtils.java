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
        double sectorRadius = crownR / 2.0;

        // Логика по созданию яблок в дереве ниже
        for (int i = 0; i < appleCount; i++) {
            // Вычисляем координаты яблока внутри овала
            double appleAngle = sectorAngle * i;
            int appleX = (int) (treeX + sectorRadius * Math.cos(appleAngle) + random.nextInt(15));
            int appleY = (int) (treeY + sectorRadius * Math.sin(appleAngle) + random.nextInt(15));
            tree.addApple(new Apple(appleX, appleY, appleR, appleColor));
        }
    }
    // метод для проверки, находится ли точка внутри овала
    private static boolean isPointInsideOval(int pointX, int pointY, int ovalX, int ovalY, int ovalR) {
        double dx = Math.pow(pointX - ovalX, 2);
        double dy = Math.pow(pointY - ovalY, 2);
        double d1 = dx / Math.pow(ovalR / 2, 2);
        double d2 = dy / Math.pow(ovalR, 2);
        return d1 + d2 <= 1;
    }
}
