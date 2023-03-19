package gui.config;

import java.awt.*;

public class GuiConfig {
    private static final GuiConfig instance = new GuiConfig();

    private final Dimension displaySize;

    private GuiConfig() {
        displaySize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public int getDisplayWidth() {
        return displaySize.width;
    }

    public int getDisplayHeight() {
        return displaySize.height;
    }

    private static GuiConfig getInstance() {
        return instance;
    }

    public static int getWindowWidth() {
        return GuiConstants.WINDOW_WIDTH * getInstance().getDisplayWidth() / 100;
    }

    public static int getWindowHeight() {
        return GuiConstants.WINDOW_HEIGHT * getInstance().getDisplayHeight() / 100;
    }
}
