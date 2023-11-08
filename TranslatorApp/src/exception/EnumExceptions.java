package exception;

public enum EnumExceptions {

    ALL_WORDS_IS_WRONG("You're so bad student!!!!!!!!!");

    private String message;

    EnumExceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
