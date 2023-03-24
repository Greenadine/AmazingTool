package dev.greenadine.amazingtool.exception;

public class TwentyInvalidSyntaxException extends RuntimeException {

    public TwentyInvalidSyntaxException(final String message) {
        super(message);
    }

    public TwentyInvalidSyntaxException(final int line, final String message) {
        super(String.format("Error at line #%d: %s", line, message));
    }

    public TwentyInvalidSyntaxException(final int line, final String message, final Object... replacements) {
        super(String.format(String.format("Error at line #%d: %s", line, message), replacements));
    }
}
