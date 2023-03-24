package dev.greenadine.amazingtool.app.window;

import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.app.screen.GladeSolverScreen;
import dev.greenadine.amazingtool.app.screen.HomeScreen;
import dev.greenadine.amazingtool.app.screen.TwentySyntaxCheckerScreen;

public class MainWindow extends ApplicationWindow {

    public MainWindow() {
        super("Amazing Project Helper Tool");

        // Configure window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        // Register screens
        registerScreen("home", new HomeScreen(this));
        registerScreen("twentychecker", new TwentySyntaxCheckerScreen(this));
        registerScreen("gladesolver", new GladeSolverScreen(this));

        // Open landing screen and make window visible
        openScreen("home");
        this.setVisible(true);
    }
}
