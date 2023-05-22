package src;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public static Sites getCommand(Character symbol){
        Sites command = Sites.UNKNOWN;
        for (Sites key : directionsKeys.keySet())
        {
            if (directionsKeys.get(key).equals(symbol) )  {
                command = key;
                break;
            }
        }

        return command;
    }
}
