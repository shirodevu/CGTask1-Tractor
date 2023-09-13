package ru.vsu.elements;

import java.awt.*;

public class Tree {
    private static final Color DEFAULT_CROWN_COLOR = new Color(102, 168, 82);
    private static final Color DEFAULT_APPLE_COLOR = new Color(229, 49, 49);
    private static final Color DEFAULT_TRUNK_COLOR = new Color(112, 55, 55);
    private final int x;
    private final int y;
    private final int treeCrownR;
    private int appleR;
    private final int trunkSize; //пеньки квадраты
    private Color treeCrownColor;
    private Color appleColor;
    private Color trunkColor;


    public Tree(int x, int y, int rTreeCrown, int appleR, int trunkSize) {
        this.x = x;
        this.y = y;
        this.treeCrownR = rTreeCrown;
        this.appleR = appleR;
        this.trunkSize = trunkSize;
        this.treeCrownColor = DEFAULT_CROWN_COLOR;
        this.appleColor = DEFAULT_APPLE_COLOR;
        this.trunkColor = DEFAULT_TRUNK_COLOR;
    }

    public void draw(Graphics2D g) {
        g.setColor(trunkColor);
        g.fillRect(x - (treeCrownR / 2) - 10, y + treeCrownR - 10, trunkSize, trunkSize * 3);

        g.setColor(treeCrownColor);
        g.fillOval(x - treeCrownR, y - treeCrownR, treeCrownR,
                treeCrownR + treeCrownR);
    }
}
