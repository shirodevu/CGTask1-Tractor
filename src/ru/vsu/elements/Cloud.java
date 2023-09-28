package ru.vsu.elements;

import ru.vsu.logic.Movable;

import java.awt.*;

public class Cloud implements Movable {
    private static final Color DEFAULT_CLOUD_COLOR = new Color(250, 238, 238);
    private int x;
    private int y;
    private int width;
    private int height;
    private Color cloudColor;

    public Cloud(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cloudColor = DEFAULT_CLOUD_COLOR;
    }

    public void draw(Graphics2D g) {
        g.setColor(cloudColor);
        g.fillOval(x, y - height, width, height);
        g.fillOval(x - 40, y - height / 2, width - 40, height / 2);
        g.fillOval(x + 80, y - height / 2, width - 40, height / 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getCloudColor() {
        return cloudColor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCloudColor(Color cloudColor) {
        this.cloudColor = cloudColor;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
