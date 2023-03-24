package dev.greenadine.amazingtool.utils;

import dev.greenadine.amazingtool.app.component.TileButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TileButtonMouseListener implements MouseListener {

    private final TileButton button;

    public TileButtonMouseListener(final TileButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        // If the button is left-clicked
        if (event.getButton() == 1) {
            button.cycleType();
        }
        // If the button is right-clicked
        else if (event.getButton() == 3) {
            button.cycleValue();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Do nothing
    }
}
