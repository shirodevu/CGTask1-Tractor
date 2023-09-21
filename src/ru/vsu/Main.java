package ru.vsu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
        mw.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mw.setSize(900, 600);
        mw.setVisible(true);
        mw.setResizable(false);
    }
}
