package ru.vsu.elements;

import java.awt.*;

public class TractorBody {
    private static final Color DEFAULT_TRACTOR_COLOR = new Color(250, 238, 238);
    private static final Color DEFAULT_WINDOW_COLOR = new Color(250, 238, 238);
    private int x;
    private int y;
    private int width;
    private int height;
    private Color tractorColor;
    private Color windowColor;

    public TractorBody(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tractorColor = DEFAULT_TRACTOR_COLOR;
        this.windowColor = DEFAULT_WINDOW_COLOR;
    }

    public void draw(Graphics2D g) {
        // tractor body
        g.setColor(new Color(66, 133, 180));
        g.fillRect(170, 310, 250, 120);
        g.fillRect(420, 410, 50, 20);
        g.fillRect(470, 240, 130, 190);
        g.fillRect(600, 320, 100, 110);
        // window
        g.setColor(new Color(154, 206, 235));
        g.fillRect(490, 260, 90, 100);
        // name
        g.setColor(new Color(62, 41, 153));
        g.setFont((new Font("Times", Font.PLAIN, 22)));
        g.drawString("EURO-4", 610, 375);
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setTractorColor(Color tractorColor) {
        this.tractorColor = tractorColor;
    }

    public void setWindowColor(Color windowColor) {
        this.windowColor = windowColor;
    }
}
