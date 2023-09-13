package ru.vsu.elements;


import java.awt.*;

public class Leaf {
    private static final Color DEFAULT_LEAF_COLOR = new Color(32, 84, 18);
    private final int x;
    private final int y;
    private final int leafR;
    private final Color leafColor;


    public Leaf(int x, int y, int leafR) {
        this.x = x;
        this.y = y;
        this.leafR = leafR;
        this.leafColor = DEFAULT_LEAF_COLOR;
    }

    public void draw(Graphics2D g) {
        g.setColor(leafColor);
        g.fillOval(x - leafR / 2, (int) (y + leafR - 20), leafR, leafR * 2);
    }
}