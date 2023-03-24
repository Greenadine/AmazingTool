package dev.greenadine.amazingtool.exception;

import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.app.model.ApplicationWindow;

/**
 * An {@code Exception} thrown when attempting to open an unknown {@link ApplicationScreen} for an {@link ApplicationWindow}.
 *
 * @author Kevin Zuman
 */
public class InvalidWindowScreenException extends RuntimeException {

    public InvalidWindowScreenException(final ApplicationWindow window, final String screenName) {
        super(String.format("Invalid screen '%s' for window '%s'.", screenName, window.getTitle()));
    }
}
