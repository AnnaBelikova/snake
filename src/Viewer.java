package src;

import java.util.HashMap;
import java.util.Map;

public class Viewer {

    static String[][] resultField;

    static String fruitSign = "o";

    static String cell = "X";

    static String snakeBody = "-";

    static Map<Commander.Sites, String> snakeHead = new HashMap<Commander.Sites, String>();

    public Viewer(){

        snakeHead.put(Commander.Sites.LEFT, "<");
        snakeHead.put(Commander.Sites.UP, "︿");
        snakeHead.put(Commander.Sites.RIGHT, ">");
        snakeHead.put(Commander.Sites.DOWN, "﹀");

    }


    public static void printField(Field field,  Snake snake, Fruit fruit){
        updateField(field, snake, fruit);
        for (int i = 0; i < field.rows; i++) {
            for (int j = 0; j < field.columns; j++) {
                System.out.print(resultField[i][j]);
            }
            System.out.println();
        }
    }

    public static void updateField( Field field, Snake snake, Fruit fruit){
        createField(field);
        addFruitToField(fruit);
        addSnakeToField(snake);
    }



    public static void createField(Field field){
        resultField = new String[field.rows][field.columns];
        for (int i = 0; i < field.rows; i++) {
            for (int j = 0; j < field.columns; j++) {
                resultField[i][j] = cell;
            }
        }
    }

    public static void clearField(){
        for (int i = 0; i < resultField.length; i++) {
            for (int j = 0; j < resultField[0].length; j++) {
                resultField[i][j] = cell;
            }
        }
    }

    public static void addFruitToField(Fruit fruit){
        resultField[fruit.y][fruit.x] = fruitSign;
    }

    public static void addSnakeToField(Snake snake){
        int index = 0;
        for( int[] part: snake.body){
            if(index == 0){
                resultField[part[1]][part[0]] = snakeHead.get(snake.curDir);
                index++;
            }else{
                resultField[part[1]][part[0]] = snakeBody;
            }
        }
    }


    public static void printLooser(){
        System.out.print("LOOSER");
    }

}
