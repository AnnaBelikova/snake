package src;

import java.util.HashMap;
import java.util.Map;

public class Viewer {

    String[][] resultField;

    String fruitSign = "o";

    String cell = "X";

    String snakeBody = "-";

    Map<Commander.Sites, String> snakeHead = new HashMap<Commander.Sites, String>();

    public Viewer(){

        snakeHead.put(Commander.Sites.LEFT, "<");
        snakeHead.put(Commander.Sites.UP, "︿");
        snakeHead.put(Commander.Sites.RIGHT, ">");
        snakeHead.put(Commander.Sites.DOWN, "﹀");

    }


    public void printField(Field field){
        updateField(field);
        for (int i = 0; i < field.rows; i++) {
            for (int j = 0; j < field.columns; j++) {
                System.out.print(resultField[i][j]);
            }
            System.out.println();
        }
    }

    public void updateField( Field field){
        createField(field);
        addFruitToField(field.fruit);
        addSnakeToField(field.snake);
    }



    public void createField(Field field){
        resultField = new String[field.rows][field.columns];
        for (int i = 0; i < field.rows; i++) {
            for (int j = 0; j < field.columns; j++) {
                resultField[i][j] = cell;
            }
        }
    }

    public void clearField(){
        for (int i = 0; i < resultField.length; i++) {
            for (int j = 0; j < resultField[0].length; j++) {
                resultField[i][j] = cell;
            }
        }
    }

    public void addFruitToField(Fruit fruit){
        resultField[fruit.y][fruit.x] = fruitSign;
    }

    public void addSnakeToField(Snake snake){
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


    public void printLooser(){
        System.out.print("LOOSER");
    }

}
