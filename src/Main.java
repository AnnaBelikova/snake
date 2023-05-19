package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {
    public static void clearConsole() {
        for ( int i = 0; i < 100; ++i) {
            System.out.println();
        }
    }

    static String cell = "X";

    static String[][] field = new String[9][9];
    static int x = 0;
    static int y = 0;
    static Fruit fruit = new Fruit();

    static Snake snake = new Snake();


    public static void updateField() throws IOException{
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = cell;
            }
        }
        String x;

        Scanner scanner = new Scanner(System.in);
        x = scanner.next();


        char c;
        c = x.charAt(0);
        snake.nextStep(c,field[0].length, field.length, new int[] {fruit.x, fruit.y} );

        String snakeHead = snake.getSnakeHead(c);

        int index = 0;
        for( int[] part: snake.body){
            if(index == 0){
                field[part[1]][part[0]] = snakeHead;
                index++;
            }else{
                field[part[1]][part[0]] = snake.getSnakeTail();
            }
        }
        if(snake.ifEatFruit(new int[] {fruit.x, fruit.y} )){
            fruit.generateFruit(8,8);
        }
        field[fruit.y][fruit.x] = fruit.sign;

    }

    public static void printField() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = cell;
            }
        }

        fruit.generateFruit(8,8);

        while (true) {
            updateField();
            printField();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
            //clearConsole();
        }

    }
}
