package dev.greenadine.amazingtool.app.component;

import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.app.model.PanelComponent;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class UsageCostField extends PanelComponent {

    public UsageCostField(ApplicationPanel parentPanel, final String fieldName, final int defaultValue) {
        super(parentPanel);

        // Configure component
        this.setLayout(new GridLayout(1, 2, 5, 0));

        // Populate component
        final JLabel fieldNameLabel = new JLabel(fieldName);
        this.add(fieldNameLabel);

        final NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        numberFormat.setGroupingUsed(false);
        final JFormattedTextField valueField = new JFormattedTextField(numberFormat);
        valueField.setValue(defaultValue);
        this.add(valueField);
    }

    @Override
    public void onShow() {
        // Do nothing
    }

    @Override
    public void onHide() {
        // Do nothing
    }
}
