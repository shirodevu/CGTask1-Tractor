package ru.vsu;

import ru.vsu.elements.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleUtils {

    private static List<Apple> apples;

    public AppleUtils(){
        apples = new ArrayList<>();
        generateAppleTree(5);
    }

    private static void generateAppleTree(int appleNumber) {
        for (int i = 0; i < appleNumber; i++){
            apples.add(new Apple(0, 0, 10));
        }
    }
}
