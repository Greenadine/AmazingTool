package dev.greenadine.amazingtool;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import dev.greenadine.amazingtool.app.window.CostsWindow;
import dev.greenadine.amazingtool.app.window.MainWindow;

import javax.swing.*;

public class Main {

    public static MainWindow MAIN_WINDOW;
    public static CostsWindow COSTS_WINDOW;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            MAIN_WINDOW = new MainWindow();
            COSTS_WINDOW = new CostsWindow();
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
}
