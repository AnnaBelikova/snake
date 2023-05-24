package src;

import java.util.ArrayList;
import java.util.Random;

public class Field {
    int columns;
    int rows;

    Snake snake;

    Fruit fruit;

    ArrayList<int[]> fieldCoords;

    static Random random = new Random();

    public Field(int col, int row, int snakeLength){
        columns = col;
        rows = row;

        fieldCoords = new ArrayList<int[]>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fieldCoords.add(new int[]{i, j});
            }
        }

        snake = new Snake(snakeLength, columns);

        generateFruit();

    }

    public void updateField(Commander.Sites command){
        snake.nextStep(command, this);
        if(ifEatFruit()){
            generateFruit();
        }
    }

    public void generateFruit(){
        ArrayList<int[]> allowedCords = new ArrayList<int[]>();
        for( int[] cords: fieldCoords){
            boolean isSnake = false;
            for( int[] part: snake.body){
                if(part[0] == cords[0] && part[1] == cords[1]){
                    isSnake = true;
                    break;
                }
            }
            if(!isSnake){
                allowedCords.add(cords);
            }
        }
        int index = getRandomNumberUsingNextInt(0, allowedCords.size());
        int[] cellForFruit = allowedCords.get(index);
        fruit = new Fruit(cellForFruit[0], cellForFruit[1]);
    }

    private static int getRandomNumberUsingNextInt(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public boolean ifEatFruit() {
        int[] snakeHead = snake.body.getFirst();
        if(snakeHead[0] == fruit.x && snakeHead[1] == fruit.y){
            return true;
        }else{
            return false;
        }
    }

    public boolean ifIsLooser(){
        return snake.ifTailIsBitten();
    }


}
