package src;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void clearConsole() {
        for ( int i = 0; i < 100; ++i) {
            System.out.println();
        }
    }

    static String cell = "| ";

    static String snake = "->";

    static String[][] field = new String[9][9];
    static int x = 0;
    static int y = 0;

    static int snakeLength = 2;

    public static void updateField() {
        for (int j = 0; j < 9; j++) {
            field[0][j] = cell;
        }
        if( x < field[0].length-2){
            x++;
        }else{
            x=0;
        }

        if(x == field[0].length-2){
            field[y][x] = cell.substring(0, 1) + snake.substring(0,1);
            field[y][0] = cell.substring(0, 1) + snake.substring(1,2);
        }else{
            field[y][x] = cell.substring(0, 1) + snake.substring(0,1);
            field[y][x+snakeLength-1] = cell.substring(0, 1) + snake.substring(1,2);
        }

        if(x==0){
            x++;
        };

    }

    public static void printField() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[i][j] = cell;
            }
        }

        while (true) {
            updateField();
            printField();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            clearConsole();
        }

    }
}
