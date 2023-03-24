package dev.greenadine.amazingtool.app.panel.costs;

import dev.greenadine.amazingtool.app.component.WrappedJLabel;
import dev.greenadine.amazingtool.app.screen.CostsScreen;
import dev.greenadine.amazingtool.app.component.UsageCostField;
import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.gladesolver.Costs;
import dev.greenadine.amazingtool.gladesolver.CostItem;
import dev.greenadine.amazingtool.utils.Fonts;

import javax.swing.*;

public class HardwareCostsPanel extends ApplicationPanel {

    private final Costs costs;

    private final UsageCostField kompasField;
    private final UsageCostField zwOogField;
    private final UsageCostField kleurOogField;
    private final UsageCostField variabeleField;

    public HardwareCostsPanel(CostsScreen parentScreen) {
        super(parentScreen);

        this.costs = parentScreen.getCosts();

        // Configure panel
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Populate panel
        final WrappedJLabel headerLabel = new WrappedJLabel("Hardware");
        headerLabel.getLabel().setFont(Fonts.MAIN_TITLE);
        this.add(headerLabel);

        kompasField = new UsageCostField(this, "kompas", costs.getCost(CostItem.AANSCHAF_KOMPAS));
        this.add(kompasField);

        zwOogField = new UsageCostField(this, "zwOog", costs.getCost(CostItem.AANSCHAF_ZW_OOG));
        this.add(zwOogField);

        kleurOogField = new UsageCostField(this, "kleurOog", costs.getCost(CostItem.AANSCHAF_KLEUR_OOG));
        this.add(kleurOogField);

        variabeleField = new UsageCostField(this, "variabele", costs.getCost(CostItem.AANSCHAF_VARIABELE));
        this.add(variabeleField);
    }

    @Override
    public void onShowImpl() {
        // TODO
    }

    @Override
    public void onHideImpl() {
        // TODO
    }
}
