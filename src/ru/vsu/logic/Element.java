package ru.vsu.logic;

import java.awt.*;

public interface Element {
    void draw(Graphics2D g);

    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
}
