package dev.greenadine.amazingtool.app.screen;

import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.app.panel.costs.HardwareCostsPanel;
import dev.greenadine.amazingtool.gladesolver.Costs;

import javax.swing.border.EmptyBorder;

public class CostsScreen extends ApplicationScreen {

    private final Costs costs;

    public CostsScreen(ApplicationWindow window, final Costs costs) {
        super(window);

        this.costs = costs;

        // Configure screen
        this.setBorder(new EmptyBorder(0, 20, 10, 20));

        // Populate screen
        this.add(new HardwareCostsPanel(this));
    }

    public Costs getCosts() {
        return costs;
    }

    @Override
    protected void onOpenImpl() {
        // TODO
    }

    @Override
    protected void onCloseImpl() {
        // TODO
    }
}
