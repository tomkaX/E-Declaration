package logic.controller.exceptions;

/**
 * Created by Spayker on 2/24/2016.
 */
public class EDeclarationException extends Exception{

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("UnusedDeclaration")
    EDeclarationException() {
        super();
    }

    @SuppressWarnings("UnusedDeclaration")
    EDeclarationException(String message, Throwable cause) {
        super(message, cause);
    }

    @SuppressWarnings("UnusedDeclaration")
    EDeclarationException(String message) {
        super(message);
    }

    @SuppressWarnings("UnusedDeclaration")
    EDeclarationException(Throwable cause) {
        super(cause);
    }
}
