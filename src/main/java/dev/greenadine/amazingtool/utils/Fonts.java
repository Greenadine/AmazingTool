package dev.greenadine.amazingtool.utils;

import java.awt.*;

public final class Fonts {

    private static final Font DEFAULT = new Font(Font.DIALOG, Font.PLAIN, 12);

    /* General fonts */
    public static final Font HEADER = DEFAULT.deriveFont(20f);

    /* Main fonts  */
    public static final Font MAIN_TITLE = DEFAULT.deriveFont(20f);
    public static final Font MAIN_BUTTON = DEFAULT.deriveFont(14f);
}