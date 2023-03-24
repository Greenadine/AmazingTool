package dev.greenadine.amazingtool.app.window;

import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.app.screen.CostsScreen;
import dev.greenadine.amazingtool.gladesolver.Costs;

public class CostsWindow extends ApplicationWindow {

    public CostsWindow() {
        super("Action Costs");

        // Configure window
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setResizable(false);

        // Register screens
        registerScreen("costs", new CostsScreen(this, new Costs()));

        // Open landing screen and make window visible
        openScreen("costs");
        this.setVisible(false);
    }
}
