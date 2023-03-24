package dev.greenadine.amazingtool.utils;

/**
 * Utility class for logging information to console.
 *
 * @author Kevin Zuman
 */
public final class Logger {

    public static void info(final String message) {
        System.out.println("INFO: " + message);
    }

    public static void info(final String message, final Object... replacements) {
        info(String.format(message, replacements));
    }

    public static void warning(final String message) {
        System.out.println("WARNING: " + message);
    }

    public static void warning(final String message, final Object... replacements) {
        warning(String.format(message, replacements));
    }

    public static void error(final Throwable thrown, final String message) {
        System.out.println("ERROR: " + message);
        thrown.printStackTrace();
    }

    public static void error(final Throwable thrown, final String message, final Object... replacements) {
        error(thrown, String.format(message, replacements));
    }

    public static void debug(final String message) {
        System.out.println("DEBUG :: " + message);
    }
}
