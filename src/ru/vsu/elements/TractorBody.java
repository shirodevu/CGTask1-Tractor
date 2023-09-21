package ru.vsu.elements;

import ru.vsu.logic.Element;

import java.awt.*;

public class TractorBody implements Element {
    private static final Color DEFAULT_TRACTOR_COLOR = new Color(250, 238, 238);
    private static final Color DEFAULT_WINDOW_COLOR = new Color(250, 238, 238);
    private int x;
    private int y;
    private Color tractorColor;
    private Color windowColor;

    public TractorBody(int x, int y) {
        this.x = x;
        this.y = y;
        this.tractorColor = DEFAULT_TRACTOR_COLOR;
        this.windowColor = DEFAULT_WINDOW_COLOR;
    }

    public void draw(Graphics2D g) {
        int baseLineX = 170;
        // tractor body
        g.setColor(new Color(66, 133, 180));
        g.fillRoundRect(170, 310, 250, 120, 10, 10);
        g.fillRect(410, 410, 70, 20);
        g.fillRoundRect(470, 240, 130, 190,10, 10);
        g.fillRoundRect(590, 320, 110, 110, 10, 10);
        // window
        g.setColor(new Color(154, 206, 235));
        g.fillRoundRect(490, 260, 90, 100, 15, 15);
        // name
        g.setColor(new Color(62, 41, 153));
        g.setFont((new Font("Tahoma", Font.BOLD|Font.ITALIC, 22)));
        g.drawString("EURO-4", 600, 375);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getTractorColor() {
        return tractorColor;
    }

    public Color getWindowColor() {
        return windowColor;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTractorColor(Color tractorColor) {
        this.tractorColor = tractorColor;
    }

    public void setWindowColor(Color windowColor) {
        this.windowColor = windowColor;
    }
}
