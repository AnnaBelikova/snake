package src;

import java.util.Random;

public class Fruit {
    static String sign = "o";
    static String cell = "X";

    static int x = 0;
    static int y = 0;

    public static void generateFruit(int maxX, int maxY) {
        x = getRandomNumberUsingNextInt(0, maxX);
        y = getRandomNumberUsingNextInt(0, maxY);
    }

    protected static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }



}
