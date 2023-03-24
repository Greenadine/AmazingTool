package dev.greenadine.amazingtool.app.screen;

import dev.greenadine.amazingtool.Main;
import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.app.panel.GladeGridPanel;
import dev.greenadine.amazingtool.app.panel.ScreenHeaderPanel;
import dev.greenadine.amazingtool.utils.Colors;
import dev.greenadine.amazingtool.utils.SwingUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GladeSolverScreen extends ApplicationScreen {

    private final GladeGridPanel gladeGridPanel;

    public GladeSolverScreen(ApplicationWindow window) {
        super(window);

        // Configure screen
        this.setLayout(new BorderLayout());

        // Add header
        this.add(new ScreenHeaderPanel(this, "Glade Solver", 750, 50), BorderLayout.PAGE_START);

        // Populate screen
        gladeGridPanel = new GladeGridPanel(this);
        this.add(gladeGridPanel, BorderLayout.CENTER);

        addSidebar();
    }

    private void addSidebar() {
        final JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(5, 10, 10, 20));
        this.add(sidebar, BorderLayout.LINE_END);

        SwingUtils.addButton(sidebar, "Edit Costs", null, 125, 30, this::onActionEditCosts);

        SwingUtils.addVerticalSpacer(sidebar, 5);

        SwingUtils.addButton(sidebar, "Reset", null, 125, 30, this::onActionReset);

        SwingUtils.addVerticalSpacer(sidebar, 5);
        SwingUtils.addHorizontalSeparator(sidebar);

        final JButton solveButton = SwingUtils.addButton(sidebar, "Solve", null, 125, 30, this::onActionSolve);
        solveButton.setBackground(Colors.GLADE_SIDEBAR_SOLVE_BUTTON_BACKGROUND);
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

    private void onActionEditCosts(final ActionEvent event) {
        Main.COSTS_WINDOW.setVisible(true);
    }

    private void onActionSolve(final ActionEvent event) {
        // TODO
    }

    private void onActionReset(final ActionEvent event) {
        gladeGridPanel.reset();
    }
}