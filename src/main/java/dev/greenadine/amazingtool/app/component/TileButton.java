package dev.greenadine.amazingtool.app.component;

import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.app.model.PanelComponent;
import dev.greenadine.amazingtool.gladesolver.TileType;
import dev.greenadine.amazingtool.utils.SwingUtils;
import dev.greenadine.amazingtool.utils.TileButtonMouseListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TileButton extends PanelComponent {

    private TileType type;
    private int value;

    private final JButton button;

    public TileButton(ApplicationPanel parentPanel) {
        super(parentPanel);

        this.type = TileType.NORMAL;
        this.value = type.getDefaultValue();

        // Configure component
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Populate component
        button = new JButton(String.format("%c%d", type.getCharacter(), value));
        SwingUtils.setSize(button, 30, 30);
        button.addMouseListener(new TileButtonMouseListener(this));
        button.setBackground(Color.WHITE);
        button.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.add(button);
    }

    public void cycleType() {
        setType(TileType.getNext(type));
    }

    public void cycleValue() {
        setValue(type.getNextValue(value));
    }

    public void reset() {
        setType(TileType.NORMAL);
    }

    public TileType getType() {
        return type;
    }

    private void setType(final TileType type) {
        this.type = type;
        this.value = type.getDefaultValue();
        button.setBackground(type.getColor());
        button.setText(String.format("%c%d", type.getCharacter(), value));
    }

    public int getValue() {
        return value;
    }

    private void setValue(final int value) {
        this.value = value;
        button.setText(String.format("%c%d", type.getCharacter(), value));
    }

    @Override
    public void onShow() {
        // TODO
    }

    @Override
    public void onHide() {
        // TODO
    }
}
