package ru.vsu.elements;

import ru.vsu.AppleUtils;
import ru.vsu.logic.Tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AppleTree implements Tree {
    private static final Color DEFAULT_CROWN_COLOR = new Color(102, 168, 82);
    private static final Color DEFAULT_APPLE_COLOR = new Color(229, 49, 49);
    private static final Color DEFAULT_TRUNK_COLOR = new Color(112, 55, 55);
    private static final int DEFAULT_APPLES_COUNT = 4;
    private int x;
    private int y;
    private final int treeCrownR;
    private int appleR;
    private final int trunkSize; //пеньки квадраты
    private Color treeCrownColor;
    private Color appleColor;
    private Color trunkColor;
    private final List<Apple> apples;


    public AppleTree(int x, int y, int rTreeCrown, int appleR, int trunkSize) {
        this.x = x;
        this.y = y;
        this.treeCrownR = rTreeCrown;
        this.appleR = appleR;
        this.trunkSize = trunkSize;
        this.treeCrownColor = DEFAULT_CROWN_COLOR;
        this.appleColor = DEFAULT_APPLE_COLOR;
        this.trunkColor = DEFAULT_TRUNK_COLOR;
        this.apples = new ArrayList<>();
        AppleUtils.generateApplesForTree(this, DEFAULT_APPLES_COUNT);
    }

    public void addApple(Apple apple){
        this.apples.add(apple);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
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

    public int getTreeCrownR() {
        return treeCrownR;
    }

    public int getAppleR() {
        return appleR;
    }

    public Color getAppleColor() {
        return appleColor;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(trunkColor);
        g.fillRect(x - (treeCrownR / 2) - 10, y + treeCrownR - 10, trunkSize, trunkSize * 3);

        g.setColor(treeCrownColor);
        g.fillOval(x - treeCrownR, y - treeCrownR, treeCrownR, treeCrownR + treeCrownR);

        for (Apple apple : apples) {
            apple.draw(g);
        }
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        for (Apple apple : apples) {
            apple.move(dx, dy);
        }
    }
}
