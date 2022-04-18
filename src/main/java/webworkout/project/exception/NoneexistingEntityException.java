package webworkout.project.exception;

public class NoneexistingEntityException extends Throwable {

    public NoneexistingEntityException() {
    }

    public NoneexistingEntityException(String message) {
        super(message);
    }

    public NoneexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoneexistingEntityException(Throwable cause) {
        super(cause);
    }
}
