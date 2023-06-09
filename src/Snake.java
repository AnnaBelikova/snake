package src;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class Snake {
    static Map<Commander.Sites, int[]> directions = new HashMap<Commander.Sites, int[]>();

    Commander.Sites curDir = Commander.Sites.RIGHT;
    Deque<int[]> body = new ArrayDeque<>();
    int startLength = 1;



    public Snake( int length, int maxLength) {
        if(length > 0 && length <= maxLength){
            startLength = length;
        }

        for(int i = 0 ; i < startLength; i++){
            body.push(new int[] {i, 0});
        }

        directions.put(Commander.Sites.LEFT,new int[] {-1,0});
        directions.put(Commander.Sites.UP,new int[] {0,-1});
        directions.put(Commander.Sites.RIGHT,new int[] {1, 0});
        directions.put(Commander.Sites.DOWN,new int[] {0, 1});

    }

    public void nextStep(Commander.Sites command, Field field ) {
        if(curDir == Commander.Sites.LEFT && command ==Commander.Sites.RIGHT || curDir == Commander.Sites.RIGHT && command ==Commander.Sites.LEFT || curDir == Commander.Sites.UP && command ==Commander.Sites.DOWN || curDir == Commander.Sites.DOWN && command ==Commander.Sites.UP){
            command = curDir;
        }else{
            curDir = command;
        }
        int[] snakeHead = body.getFirst();
        int[] newHead = new int[2];

        int[] dirCords = directions.get(command);


        newHead[0] = snakeHead[0]+dirCords[0];
        newHead[1] = snakeHead[1]+dirCords[1];

        if(newHead[0] < 0 || newHead[0] > field.rows-1 ){
            newHead[0] = newHead[0] < 0 ? field.rows-1 : 0;
        }else if(newHead[1] < 0 || newHead[1] > field.columns-1 ){
            newHead[1] = newHead[1] < 0 ? field.columns-1 : 0;
        }

        body.addFirst(newHead);
        if(!field.ifEatFruit()){
            body.removeLast();
        }

    }

    public boolean ifTailIsBitten() {

        int[] snakeHead = body.getFirst();
        int index =0;
        for(int[] part : body) {
            if(part[0] == snakeHead[0] && part[1] == snakeHead[1] && index !=0){
                return true;
            }
            index++;
        }
        return false;
    }

}
