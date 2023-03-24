package dev.greenadine.amazingtool.app.panel.costs;

import dev.greenadine.amazingtool.app.component.WrappedJLabel;
import dev.greenadine.amazingtool.app.screen.CostsScreen;
import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.gladesolver.Costs;
import dev.greenadine.amazingtool.utils.Fonts;

import javax.swing.*;

public class UsageCostsPanel extends ApplicationPanel {

    private final Costs costs;

    public UsageCostsPanel(CostsScreen parentScreen) {
        super(parentScreen);

        this.costs = parentScreen.getCosts();

        // Configure panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Populate panel
        final WrappedJLabel headerLabel = new WrappedJLabel("Hardware");
        headerLabel.getLabel().setFont(Fonts.MAIN_TITLE);
        this.add(headerLabel);
    }

    @Override
    public void onShowImpl() {

    }

    @Override
    public void onHideImpl() {

    }
}
