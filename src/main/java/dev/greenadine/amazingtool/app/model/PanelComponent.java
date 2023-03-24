package dev.greenadine.amazingtool.app.model;

import javax.swing.*;

/**
 * Super class for specific {@link ApplicationComponent}s.
 *
 * @author Kevin Zuman
 */
public abstract class PanelComponent extends JPanel implements ApplicationComponent {

    protected final ApplicationPanel parentPanel;

    public PanelComponent(final ApplicationPanel parentPanel) {
        this.parentPanel = parentPanel;
        parentPanel.addPanelComponent(this);
    }
}
