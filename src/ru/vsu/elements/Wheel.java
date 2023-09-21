package ru.vsu.elements;

import ru.vsu.logic.Element;

import java.awt.*;

public class Wheel implements Element {
    private static final Color DEFAULT_TIRE_COLOR = new Color(0,0,0);
    private static final Color DEFAULT_DISK_COLOR = new Color(66,66,66);
    private static final Color DEFAULT_RING_COLOR = new Color(158,158,158);
    private static final int DEFAULT_RING_THICKNESS = 10;
    private int x;
    private int y;
    private int tireR;
    private int diskR;
    private int ringThickness;
    private Color tireColor;
    private Color ringColor;
    private Color diskColor;

    public Wheel(int x, int y, int tireR, int diskR, int ringThickness) {
        this.x = x;
        this.y = y;
        this.tireR = tireR;
        this.diskR = diskR;
        this.ringThickness = ringThickness;
        this.tireColor = DEFAULT_TIRE_COLOR;
        this.ringColor = DEFAULT_RING_COLOR;
        this.diskColor = DEFAULT_DISK_COLOR;
    }

    public Wheel(int x, int y, int tireR, int diskR) {
        this.x = x;
        this.y = y;
        this.tireR = tireR;
        this.diskR = diskR;
        this.ringThickness = DEFAULT_RING_THICKNESS;
        this.tireColor = DEFAULT_TIRE_COLOR;
        this.ringColor = DEFAULT_RING_COLOR;
        this.diskColor = DEFAULT_DISK_COLOR;
    }

    private int getRingOvalRadius(){
        return diskR + ringThickness;
    }

    public void draw(Graphics2D g){
        /// Шина
        g.setColor(tireColor);
        g.fillOval(x - tireR, y - tireR, tireR + tireR, tireR + tireR);
        /// Кольцо
        int ringOvalR = getRingOvalRadius();
        g.setColor(ringColor);
        g.fillOval(x - ringOvalR, y - ringOvalR, 2*ringOvalR, 2*ringOvalR);
        /// Диск
        g.setColor(diskColor);
        g.fillOval(x - diskR, y - diskR, diskR + diskR, diskR + diskR);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTireR() {
        return tireR;
    }

    public void setTireR(int tireR) {
        this.tireR = tireR;
    }

    public int getDiskR() {
        return diskR;
    }

    public void setDiskR(int diskR) {
        this.diskR = diskR;
    }

    public int getRingThickness() {
        return ringThickness;
    }

    public void setRingThickness(int ringThickness) {
        this.ringThickness = ringThickness;
    }

    public Color getTireColor() {
        return tireColor;
    }

    public void setTireColor(Color tireColor) {
        this.tireColor = tireColor;
    }

    public Color getRingColor() {
        return ringColor;
    }

    public void setRingColor(Color ringColor) {
        this.ringColor = ringColor;
    }

    public Color getDiskColor() {
        return diskColor;
    }

    public void setDiskColor(Color diskColor) {
        this.diskColor = diskColor;
    }
}
