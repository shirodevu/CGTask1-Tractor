package ru.vsu.elements;

import ru.vsu.logic.Element;
import ru.vsu.logic.Movable;

import java.awt.*;
import java.util.Random;


public class Leaf implements Element, Movable {
    static final Random random = new Random();
    private int x;
    private int y;
    private final int leafR;
    private final double rotationDegrees;
    private final Color leafColor;
    private final int treeCrownR;


    public Leaf(int x, int y, int leafR, Color leafColor, double rotationDegrees, int treeCrownR) {
        this.x = x;
        this.y = y;
        this.leafR = leafR;
        this.leafColor = leafColor;
        this.rotationDegrees = rotationDegrees;
        this.treeCrownR = treeCrownR;
    }

    public void draw(Graphics2D g) {
        g.setColor(leafColor);
        g.rotate(Math.toRadians(rotationDegrees), x, y);
        g.fillOval(x - leafR, y + leafR, leafR, leafR * 2);

        //g.fillOval(leafX - leafR, leafY - leafR, leafR, leafR * 2);
        g.rotate(-Math.toRadians(rotationDegrees), x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}