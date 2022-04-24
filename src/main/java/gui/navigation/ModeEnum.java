package gui.navigation;

import java.util.HashMap;
import java.util.Map;

/**
 * Calculator modes enumeration
 */
public enum ModeEnum {

    BASIC_MODE(0, "Basic mode"),
    CONVERTER_MODE(1, "Converter mode"),
    SCIENTIFIC_MODE(2, "Scientific mode"),
    FUNCTION_MODE(3, "Functions mode"),
    LOGICAL_MODE(4, "Logical mode");

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

