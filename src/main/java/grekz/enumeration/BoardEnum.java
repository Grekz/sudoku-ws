package grekz.enumeration;

/**
 * Created by juanmend on 10/16/2016.
 */
public enum BoardEnum {
    // "700040530.005008010.008509040.539060001.000010005.800720900.907400000.000057000.600000050"
    DEFAULT ("BKSAQA.2ZC7E.52DM8.8WXXCX.7PX.D8Q878.F08QBK.17ZC.9X8302");
    private final String state;

    BoardEnum(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
