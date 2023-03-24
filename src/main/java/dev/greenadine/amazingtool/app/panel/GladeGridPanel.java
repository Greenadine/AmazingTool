package dev.greenadine.amazingtool.app.panel;

import dev.greenadine.amazingtool.app.component.TileButton;
import dev.greenadine.amazingtool.gladesolver.TileType;
import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.gladesolver.Glade;
import dev.greenadine.amazingtool.utils.Colors;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class GladeGridPanel extends ApplicationPanel {

    private final TileButton[][] buttons;

    public GladeGridPanel(ApplicationScreen parentScreen) {
        super(parentScreen);

        this.buttons = new TileButton[20][20];

        // Configure panel
        final JPanel wrapperPanel = new JPanel();
        wrapperPanel.setBorder(new MatteBorder(3, 3, 3, 3, Colors.GLADE_BORDER));
        this.add(wrapperPanel);

        // Populate panel
        final JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(20, 20, 2, 2));
        wrapperPanel.add(gridPanel);

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                final TileButton tileButton = new TileButton(this);
                gridPanel.add(tileButton);
                buttons[i][j] = tileButton;
            }
        }
    }

    /**
     * Resets all the {@link TileButton} back to {@link TileType#NORMAL}.
     */
    public void reset() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                buttons[i][j].reset();
            }
        }
    }

    /**
     * Converts the current grid configuration to a {@link Glade}.
     *
     * @return A {@code Glade} configured like the current grid.
     */
    public Glade toGlade() {
        Glade glade = new Glade();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                final TileButton tileButton = buttons[i][j];
                glade.setTile(i, j, tileButton.getType(), tileButton.getValue());
            }
        }

        return glade;
    }

    @Override
    public void onShowImpl() {
        // Do nothing
    }

    @Override
    public void onHideImpl() {
        // Do nothing
    }
}
