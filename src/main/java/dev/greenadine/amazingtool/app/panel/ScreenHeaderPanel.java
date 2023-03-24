package dev.greenadine.amazingtool.app.panel;

import dev.greenadine.amazingtool.app.model.ApplicationPanel;
import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.utils.ApplicationActions;
import dev.greenadine.amazingtool.utils.Colors;
import dev.greenadine.amazingtool.utils.Fonts;
import dev.greenadine.amazingtool.utils.SwingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A {@link JPanel} that is commonly used in screens throughout the application as a header, with a {@link JButton} for returning to the home screen.
 *
 * @author Kevin Zuman
 */
public class ScreenHeaderPanel extends ApplicationPanel {

    private final int width;

    public ScreenHeaderPanel(ApplicationScreen screen, final String title, final int width, final int height) {
        super(screen);
        this.width = width;

        // Configure panel
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Colors.HEADER_BACKGROUND);
        this.setBorder(new MatteBorder(0, 0, 3, 0, Colors.HEADER_ACCENT));
        this.setPreferredSize(new Dimension(width, height));

        createReturnButton(ApplicationActions::openHome); // Create and add return button
        SwingUtils.addVerticalSeparator(this); // Add separator
        createTitle(title);
    }

    private void createReturnButton(ActionListener returnAction) {
        JButton returnButton = new JButton("Return", SwingUtils.getIconFromResource("return.png"));
        returnButton.addActionListener(returnAction);
        returnButton.setBackground(Colors.HEADER_RETURN_BUTTON_BACKGROUND);
        returnButton.setForeground(Colors.HEADER_RETURN_BUTTON_FOREGROUND);
        returnButton.setFont(Fonts.MAIN_BUTTON);
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.setIconTextGap(10);
        returnButton.setBorder(new EmptyBorder(15, 10, 15, 15));
        this.add(returnButton);
    }

    private void createTitle(final String screenName) {
        JLabel titleLabel = new JLabel(screenName);
        titleLabel.setFont(Fonts.HEADER);
        titleLabel.setAlignmentX(LEFT_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(5,5, 5, width / 2 - 6 * screenName.length()));
        this.add(titleLabel);
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
