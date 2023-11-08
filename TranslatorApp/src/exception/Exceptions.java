package exception;

public class Exceptions extends RuntimeException {

    public Exceptions (EnumExceptions enumExceptions) {
        super(enumExceptions.getMessage());
    }
}
