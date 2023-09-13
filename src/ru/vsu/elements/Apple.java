package ru.vsu.elements;

import java.awt.*;

public class Apple {
    private static final Color DEFAULT_APPLE_COLOR = new Color(102, 168, 82);
    private final int x;
    private final int y;
    private final int appleR;
    private final Color appleColor;


    public Apple(int x, int y, int appleR) {
        this.x = x;
        this.y = y;
        this.appleR = appleR;
        this.appleColor = DEFAULT_APPLE_COLOR;
    }

    public void draw(Graphics2D g) {
        g.setColor(appleColor);
        g.fillOval(x - appleR / 2, (int) (y + appleR - 20), appleR, appleR);
    }
}