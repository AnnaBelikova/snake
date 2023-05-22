package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

        Field field = new Field(9,9);

        Snake snake = new Snake(7, field.columns);

        Fruit fruit = new Fruit();

        fruit.generateFruit(field.rows,field.columns);

        Viewer viewer = new Viewer();

        Commander commander = new Commander();

        viewer.createField(field);

        while (true) {
            String x;
            Scanner scanner = new Scanner(System.in);
            x = scanner.next();
            char c;
            c = x.charAt(0);

            Commander.Sites command = commander.getCommand(c);

            snake.nextStep(command, field.rows, field.columns, new int[] {fruit.x, fruit.y} );
            if(snake.ifEatFruit(new int[] {fruit.x, fruit.y} )){
                fruit.generateFruit(field.rows,field.columns);
            }

            if(snake.ifTailIsBitten()){
                viewer.printLooser();
            }else{
                viewer.printField(snake, fruit);
            }

        }

    }
}
