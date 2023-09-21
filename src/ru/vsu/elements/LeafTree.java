package ru.vsu.elements;

import ru.vsu.LeafUtils;
import ru.vsu.logic.Tree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LeafTree implements Tree {
    private static final Color DEFAULT_CROWN_COLOR = new Color(102, 168, 82);
    private static final Color DEFAULT_LEAF_COLOR = new Color(46, 119, 22);
    private static final Color DEFAULT_TRUNK_COLOR = new Color(112, 55, 55);
    private static final int DEFAULT_APPLES_COUNT = 100;
    private int x;
    private int y;
    private final int treeCrownR;
    private int leafR;
    private final int trunkSize; //пеньки квадраты
    private Color treeCrownColor;
    private Color leafColor;
    private Color trunkColor;
    private final List<Leaf> leaves;


    public LeafTree(int x, int y, int rTreeCrown, int leafR, int trunkSize) {
        this.x = x;
        this.y = y;
        this.treeCrownR = rTreeCrown;
        this.leafR = leafR;
        this.trunkSize = trunkSize;
        this.treeCrownColor = DEFAULT_CROWN_COLOR;
        this.leafColor = DEFAULT_LEAF_COLOR;
        this.trunkColor = DEFAULT_TRUNK_COLOR;
        this.leaves = new ArrayList<>();
        LeafUtils.generateLeafForTree(this, DEFAULT_APPLES_COUNT);
    }

    public void addLeaf(Leaf leaf){
        this.leaves.add(leaf);
    }

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

    public int getTreeCrownR() {
        return treeCrownR;
    }

    public int getLeafR() {
        return leafR;
    }




    @Override
    public void draw(Graphics2D g) {
        Color previousColor = g.getColor();

        g.setColor(trunkColor);
        g.fillRect(x - (treeCrownR / 2) - 10, y + treeCrownR - 10, trunkSize, trunkSize * 3);

        g.setColor(treeCrownColor);
        g.fillOval(x - treeCrownR, y - treeCrownR, treeCrownR, treeCrownR + treeCrownR);

        for (Leaf leaf : leaves) {
            leaf.draw(g);
        }

        g.setColor(previousColor);
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        for (Leaf leaf : leaves) {
            leaf.move(dx, dy);
        }
    }
}
