package GUI.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculator modes enumeration.
 * Provide the name and the index for each calculator modes.
 */
public enum ModeEnum {

    BASIC(0, "Mode basic"),
    M1(1, "Mode 1"),
    M2(2, "Mode 2"),
    M3(3, "Mode 3"),
    M4(4, "Mode 4"),
    M5(5, "Mode 5");

    private final int index;
    private final String title;

    private static final Map<String, ModeEnum> lookup = new HashMap();

    static {
        for(ModeEnum h : ModeEnum.values())
            lookup.put(h.title(), h);
    }

    ModeEnum(int index, String title){
        this.index = index;
        this.title = title;
    }

    public int index() { return index; }

    public String title(){
        return title;
    }

    public static ModeEnum mode(String title) {
        return lookup.get(title);
    }
}

