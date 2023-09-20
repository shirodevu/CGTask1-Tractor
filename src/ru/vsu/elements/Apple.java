package ru.vsu.elements;

import java.awt.*;

public class Apple {
    //private static final Color DEFAULT_APPLE_COLOR = new Color(102, 168, 82);
    private static final Color DEFAULT_TREE_COLOR = new Color(51, 70, 38);
    private final int x;
    private final int y;
    private final int appleR;
    private final Color appleColor;


    public Apple(int x, int y, int appleR, Color appleColor) {
        this.x = x;
        this.y = y;
        this.appleR = appleR;
        this.appleColor = appleColor;
    }

    public void draw(Graphics2D g) {
        g.setColor(DEFAULT_TREE_COLOR);
        g.fillRect(x - (appleR / 2), y + appleR - 3, 2, 3);
        g.setColor(appleColor);
        g.fillOval(x - appleR, y + appleR, appleR, appleR);

    }
}