package dev.greenadine.amazingtool.utils;

import dev.greenadine.amazingtool.Main;
import dev.greenadine.amazingtool.app.screen.HomeScreen;

import java.awt.event.ActionEvent;

/**
 * Contains common {@link java.awt.event.ActionListener}s used throughout the application.
 *
 * @author Kevin Zuman
 */
@SuppressWarnings("unused")
public final class ApplicationActions {

    /**
     * Opens the application's {@link HomeScreen}.
     *
     * @param event The {@link ActionEvent}.
     */
    public static void openHome(ActionEvent event) {
        Main.MAIN_WINDOW.openScreen("home");
    }
}
