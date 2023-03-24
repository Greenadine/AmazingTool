package dev.greenadine.amazingtool.app.component;

import javax.swing.*;
import java.awt.*;

/**
 * A {@link JLabel} wrapped within a {@link JPanel}.
 *
 * @author Kevin Zuman
 */
public class WrappedJLabel extends JPanel {

    private final JLabel label;

    public WrappedJLabel(final String text) {
        this(text, SwingConstants.LEADING);
    }

    public WrappedJLabel(final String text, final int horizontalAlignment) {
        this(text, null, horizontalAlignment);
    }

    public WrappedJLabel(final String text, final ImageIcon imageIcon) {
        this(text, imageIcon, SwingConstants.LEADING);
    }

    public WrappedJLabel(final String text, final ImageIcon imageIcon, final int horizontalAlignment) {
        super();

        // Configure panel
//        this.setLayout(new BorderLayout());

        // Create label
        label = new JLabel(text, imageIcon, horizontalAlignment);
        this.add(label);
//        this.add(label, BorderLayout.CENTER);
    }

    public void alignCenter() {
        this.setLayout(new BorderLayout());
        this.remove(label);
        this.add(label, BorderLayout.CENTER);
    }

    /**
     * Gets the wrapped {@link JLabel}.
     *
     * @return The wrapped {@code JLabel}.
     */
    public JLabel getLabel() {
        return label;
    }
}
