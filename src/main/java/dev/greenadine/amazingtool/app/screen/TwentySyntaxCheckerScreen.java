package dev.greenadine.amazingtool.app.screen;

import dev.greenadine.amazingtool.app.component.WrappedJLabel;
import dev.greenadine.amazingtool.app.model.ApplicationScreen;
import dev.greenadine.amazingtool.app.model.ApplicationWindow;
import dev.greenadine.amazingtool.app.panel.ScreenHeaderPanel;
import dev.greenadine.amazingtool.exception.TwentyInvalidSyntaxException;
import dev.greenadine.amazingtool.utils.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TwentySyntaxCheckerScreen extends ApplicationScreen {

    private JTextPane inputTextPane;
    private WrappedJLabel result;

    public TwentySyntaxCheckerScreen(ApplicationWindow window) {
        super(window);

        // Configure screen
        this.setLayout(new BorderLayout());

        // Add header
        this.add(new ScreenHeaderPanel(this, "Twenty Syntax Checker", 750, 50), BorderLayout.PAGE_START);

        // Populate screen
        addInputArea();
        addSidebar();
    }

    private void addInputArea() {
        final JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        this.add(inputPanel, BorderLayout.CENTER);

        final WrappedJLabel headerLabel = new WrappedJLabel("Code", SwingConstants.LEFT);
        headerLabel.getLabel().setFont(Fonts.MAIN_TITLE);
        inputPanel.add(headerLabel);

        // Create and add text area for code input
        inputTextPane = new JTextPane();
        ((DefaultStyledDocument) inputTextPane.getDocument()).setDocumentFilter(new ChangeTabToSpacesFilter(4));
        final JScrollPane scrollPane = new JScrollPane(inputTextPane);
        scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, Colors.MAIN_INPUT_FIELD_BORDER));
        SwingUtils.setSize(scrollPane, 500, 500);
        TextLineNumber numbering = new TextLineNumber(inputTextPane, 4);
        scrollPane.setRowHeaderView(numbering);
        inputPanel.add(scrollPane);
    }

    private void addSidebar() {
        final JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBorder(new EmptyBorder(25, 0, 0, 30));
        this.add(sidebarPanel, BorderLayout.LINE_END);

        SwingUtils.addVerticalSpacer(sidebarPanel, 10);

        SwingUtils.addButton(sidebarPanel, "Check", null, 150, 30, this::onActionCheck);

        result = new WrappedJLabel("", SwingConstants.CENTER);
        sidebarPanel.add(result);
    }

    @Override
    protected void onOpenImpl() {
        // Do nothing
    }

    @Override
    protected void onCloseImpl() {
        // Reset contents
        inputTextPane.setText("");
        result.getLabel().setText("");
    }

    /* Action listeners */

    /**
     * The {@link java.awt.event.ActionListener} for when the "Check" button is clicked.
     *
     * @param event the {@link ActionEvent}.
     */
    private void onActionCheck(ActionEvent event) {
        try {
            TwentySyntaxChecker.checkSyntax(inputTextPane.getText());
            result.getLabel().setForeground(Color.LIGHT_GRAY);
            result.getLabel().setText("Syntax seems to be correct!");
        } catch (TwentyInvalidSyntaxException ex) {
            String[] messageWords = ex.getMessage().split("\\s+");

            final StringBuilder builder = new StringBuilder();
            StringBuilder lineBuilder = new StringBuilder();

            for (int i = 0; i < messageWords.length; i++) {
                final String word = messageWords[i];

                lineBuilder.append(word).append(" ");

                if (lineBuilder.toString().toCharArray().length >= 25) {
                    builder.append(lineBuilder.toString().trim()).append("<br>");
                    lineBuilder = new StringBuilder();
                }
                else if (i == messageWords.length - 1) {
                    builder.append(lineBuilder);
                }
            }

            result.getLabel().setForeground(Color.RED);
            result.getLabel().setText("<html><body>" + builder + "</body></html>"); // Show syntax error
        }
    }

    private static class ChangeTabToSpacesFilter extends DocumentFilter {
        private int spaceCount;
        private String spaces = "";

        public ChangeTabToSpacesFilter(int spaceCount) {
            this.spaceCount = spaceCount;
            for (int i = 0; i < spaceCount; i++) {
                spaces += " ";
            }
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            string = string.replace("\t", spaces);
            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            text = text.replace("\t", spaces);
            super.replace(fb, offset, length, text, attrs);
        }

    }
}
