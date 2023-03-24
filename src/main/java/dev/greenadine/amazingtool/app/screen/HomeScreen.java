package dev.greenadine.amazingtool.app.screen;

import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.utils.Fonts;
import dev.greenadine.amazingtool.utils.SwingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

public class HomeScreen extends ApplicationScreen {

    public HomeScreen(ApplicationWindow window) {
        super(window);

        // Configure screen
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(10, 25, 25, 25));

        // Populate screen
        final JLabel titleLabel = new JLabel("Home");
        titleLabel.setFont(Fonts.MAIN_TITLE);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.add(titleLabel);
        SwingUtils.addVerticalSpacer(this, 15);

        SwingUtils.addButton(this, "Twenty Syntax Checker", null, 225, 50, this::onActionTwentySyntaxChecker);
        SwingUtils.addVerticalSpacer(this, 10);

        SwingUtils.addButton(this, "Glade Solver", null, 225, 50, this::onActionGladeSolver);
    }

    @Override
    protected void onOpenImpl() {
        // Do nothing
    }

    @Override
    protected void onCloseImpl() {
        // Do nothing
    }

    /* Action listeners */

    /**
     * The {@link java.awt.event.ActionListener} for when the "Twenty Syntax Checker" button is clicked.
     *
     * @param event the {@link ActionEvent}.
     */
    private void onActionTwentySyntaxChecker(final ActionEvent event) {
        window.openScreen("twentychecker");
    }

    /**
     * The {@link java.awt.event.ActionListener} for when the "Glade Solver" button is clicked.
     *
     * @param event the {@link ActionEvent}.
     */
    private void onActionGladeSolver(final ActionEvent event) {
        window.openScreen("gladesolver");
    }
}
