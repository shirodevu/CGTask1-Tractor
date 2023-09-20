package ru.vsu.elements;

import ru.vsu.LeafUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static ru.vsu.elements.Leaf.random;

public class LeafTree implements SomeTree {
    private static final Color DEFAULT_CROWN_COLOR = new Color(102, 168, 82);
    private static final Color DEFAULT_LEAF_COLOR = new Color(46, 119, 22);
    private static final Color DEFAULT_TRUNK_COLOR = new Color(112, 55, 55);
    private static final int DEFAULT_APPLES_COUNT = 100;
    private final int x;
    private final int y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTreeCrownR() {
        return treeCrownR;
    }

    public int getLeafR() {
        return leafR;
    }


    public Color getLeafColor() {
        return leafColor;
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(trunkColor);
        g.fillRect(x - (treeCrownR / 2) - 10, y + treeCrownR - 10, trunkSize, trunkSize * 3);

        g.setColor(treeCrownColor);
        g.fillOval(x - treeCrownR, y - treeCrownR, treeCrownR, treeCrownR + treeCrownR);

        for (Leaf leaf : leaves) {
            double someNum = random.nextInt(50);
            g.rotate(Math.toRadians(someNum), leaf.getX(), leaf.getY());
            leaf.draw(g);
            g.rotate(-Math.toRadians(someNum), leaf.getX(), leaf.getY());

            // g.rotate(Math.toRadians(100));

        }
    }

    @Override
    public void move(double dx) {

    }
}
