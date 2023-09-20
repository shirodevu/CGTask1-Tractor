package ru.vsu.elements;

import java.awt.*;
import java.util.Random;


public class Leaf {
    static final Random random = new Random();
    private static final Color DEFAULT_TREE_COLOR = new Color(78, 128 + random.nextInt(50), 48 + random.nextInt(50));
    private final int x;
    private final int y;
    private final int leafR;

    private Color leafColor;


    public Leaf(int x, int y, int leafR, Color leafColor) {
        this.x = x;
        this.y = y;
        this.leafR = leafR;
        this.leafColor = leafColor;
    }

    public void draw(Graphics2D g) {
        g.setColor(leafColor);
        g.fillOval(x - leafR, y +leafR, leafR,leafR * 2);
    }
}