package ru.vsu;

import ru.vsu.elements.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private static Cloud c1, c2;
    private static Wheel w1, w2, w3, w4;
    private static Tree t1, t2;

    private static Sun s;

    // private Apple a2;
    // private Leaf l2;



    public DrawPanel() {
        c1 = new Cloud(200, 200, 160, 100);
        c2 = new Cloud(800, 190, 200, 140);

        w1 = new Wheel(230, 430, 40, 10);
        w2 = new Wheel(360, 430, 40, 10);
        w3 = new Wheel(495, 420, 50, 15);
        w4 = new Wheel(680, 430, 40, 10);

        t1 = new Tree(800, 190, 60, 10, 20);
        t2 = new Tree(120, 220, 60, 10, 20);

        s = new Sun(250, 100, 40, 70, 40);

        // coordinate sun 800, 190, 130, 140
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawBackground(g);
        s.draw(g);
        drawCloud(g);
        drawTractor(g);
        //   drawAppleTree(g);
        drawLeafTree(g);


    }

    private static void drawBackground(Graphics2D g) {
        // sky
        g.setColor(new Color(165, 221, 238));
        g.fillRect(0, 0, 900, 300);
        // grass
        g.setColor(new Color(118, 200, 91));
        g.fillRect(0, 300, 900, 300);
        // road
        g.setColor(new Color(209, 190, 128));
        g.fillRect(0, 400, 900, 130);
        // hay
        g.setColor(new Color(222, 191, 53));
        g.fillOval(170, 180, 250, 250);
        g.setColor(new Color(91, 61, 42));
        g.fillRect(280, 180, 5, 200);
        g.fillRect(300, 180, 5, 200);
    }

    private static void drawTractor(Graphics2D g) {
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
        // wheels
        w1.draw(g);
        w2.draw(g);
        w3.draw(g);
        w4.draw(g);
    }

    private static void drawCloud(Graphics2D g) {
        c1.draw(g);
        c2.draw(g);
    }


    private static void drawLeafTree(Graphics2D g) {
        t1.draw(g);
        t2.draw(g);
    }




}
