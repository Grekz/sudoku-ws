package grekz.enumeration;

/**
 * Created by juanmend on 10/16/2016-
 */
public enum BoardEnum {
    // "700040530-005008010-008509040-539060001-000010005-800720900-907400000-000057000-600000050"
    DEFAULT ("BKSAQA-2ZC7E-52DM8-8WXXCX-7PX-D8Q878-F08QBK-17ZC-9X8302"),
    VALID_FIRST_ROW  ("8UC0W0--------"),
    INVALID_FIRST_ROW("5J9BWG--------"),
    // needs move = 005
    ONE_TO_SOLVE("KNAF4-B47H90-3A363R-E7VO5R-724YHR-BT1VY0-FWH2X0-4R4EER-5PKOIR"),
    SOLVED("8UC0W0-B47H90-3A363R-E7VO5R-724YHR-BT1VY0-FWH2X0-4R4EER-5PKOIR");
    private final String state;

    BoardEnum(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
