package ru.vsu.elements;

import ru.vsu.logic.Element;

import java.awt.*;

public class Sun implements Element {
    private static final Color DEFAULT_SUN_COLOR = new Color(241, 162, 47);
    private int x;
    private int y;
    private final int r;
    private final int R;
    private final int count;
    private final Color sunColor;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public Sun(int x, int y, int r, int R, int count) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.R = R;
        this.count = count;
        this.sunColor = DEFAULT_SUN_COLOR;
    }

    public void draw(Graphics2D g) {
        g.setColor(sunColor);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        double da = 2 * Math.PI / count;
        for (int i = 0; i < count; i++) {
            double a = da * i;
            double x1 = x + r * Math.cos(a);
            double y1 = y + r * Math.sin(a);
            double x2 = x + R * Math.cos(a);
            double y2 = y + R * Math.sin(a);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
    }

}

