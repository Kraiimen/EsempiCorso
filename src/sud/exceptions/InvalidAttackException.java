package sud.exceptions;

public class InvalidAttackException extends RuntimeException {
    public InvalidAttackException() {
        super("This target is already dead!");
    }
}
