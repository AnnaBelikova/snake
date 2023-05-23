package src;

import java.util.*;

public class Commander {
    public enum Sites{
        RIGHT,
        LEFT,
        UP,
        DOWN,
        UNKNOWN
    };

    static EnumMap<Sites, Character> directionsKeys = new EnumMap<>(Sites.class);

    public Commander() {
        directionsKeys.put(Sites.LEFT,'a');
        directionsKeys.put(Sites.UP,'w');
        directionsKeys.put(Sites.RIGHT,'d');
        directionsKeys.put(Sites.DOWN,'s');
    }

    public static Sites getCommand(){
        String x;
        Scanner scanner = new Scanner(System.in);
        x = scanner.next();
        char c;
        c = x.charAt(0);
        Sites command = Sites.UNKNOWN;
        for (Sites key : directionsKeys.keySet())
        {
            if (directionsKeys.get(key).equals(c) )  {
                command = key;
                break;
            }
        }

        return command;
    }
}
