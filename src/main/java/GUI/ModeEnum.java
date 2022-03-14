package GUI;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculator modes enumeration
 */
public enum ModeEnum {

    M1 (0, "Mode basic"),
    M2 (1, "Mode 2"),
    M3 (2, "Mode 3"),
    M4 (3, "Mode 4"),
    M5 (4, "Mode 5"),
    M6 (5, "Mode 6");

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

