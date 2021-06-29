package xmlcarcatalogparser;

public class UncheckedAccessDeniedException extends RuntimeException {
    public UncheckedAccessDeniedException() {
    }

    public UncheckedAccessDeniedException(String message) {
        super(message);
    }

    public UncheckedAccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedAccessDeniedException(Throwable cause) {
        super(cause);
    }

    public UncheckedAccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
