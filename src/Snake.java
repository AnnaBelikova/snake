package src;
import java.util.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class Snake {
    static Map<String, String> symbols = new HashMap<String, String>();
    static Map<Character, int[]> directions = new HashMap<Character, int[]>();
    static char curDir = 'a';
    static Deque<int[]> body = new ArrayDeque<>();

    public Snake() {
        symbols.put("tail", "-");
        symbols.put("a", "<");
        symbols.put("w", "︿");
        symbols.put("d", ">");
        symbols.put("s", "﹀");

        directions.put('a',new int[] {-1,0});
        directions.put('w',new int[] {0,-1});
        directions.put('d',new int[] {1, 0});
        directions.put('s',new int[] {0, 1});

        body.push(new int[]{0, 0});
    }

    public static void nextStep(char symbol, int fieldLineLength, int fieldColumnLength, int[] friutCords ) {
        curDir = symbol;
        int[] snakeHead = body.getFirst();
        int[] newHead = new int[2];

        int[] dirCords = directions.get(symbol);


        newHead[0] = snakeHead[0]+dirCords[0];
        newHead[1] = snakeHead[1]+dirCords[1];

        if(newHead[0] < 0 || newHead[0] > fieldLineLength-1 ){
            newHead[0] = newHead[0] < 0 ? fieldLineLength-1 : 0;
        }else if(newHead[1] < 0 || newHead[1] > fieldColumnLength-1 ){
            newHead[1] = newHead[1] < 0 ? fieldColumnLength-1 : 0;
        }

        body.addFirst(newHead);
        if(!ifEatFruit(friutCords)){
            body.removeLast();
        }

    }

    public static String getSnakeHead(char symbol) {
        return symbols.get(Character.toString(symbol));
    }
    public static String getSnakeTail() {
        return symbols.get("tail");
    }



    public static boolean ifEatFruit(int[] fruitCords) {
        int[] snakeHead = body.getFirst();
        if(snakeHead[0] == fruitCords[0] && snakeHead[1] == fruitCords[1]){
            return true;
        }else{
            return false;
        }
    }

    public static boolean ifTailIsBitten() {
        return true;
    }

}
