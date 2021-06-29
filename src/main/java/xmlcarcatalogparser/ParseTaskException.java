package xmlcarcatalogparser;

public class ParseTaskException extends Exception {
    public ParseTaskException(String message) {
        super(message);
    }

    public ParseTaskException() {
        super();
    }

    public ParseTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseTaskException(Throwable cause) {
        super(cause);
    }

    protected ParseTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
