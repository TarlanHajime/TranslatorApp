package enums;

public enum Option {

    EXIT("[0] : ---- Exit \n"),
    START("[1] : ---- Start \n"),
    ADD_WORD("[2] : ---- Add word \n"),
    SEE_HISTORY("[3] : ---- See history \n");

    private final String val;
    Option(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }
}
