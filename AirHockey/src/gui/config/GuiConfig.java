package gui.config;

import game.GameParameters;
import model.Vector;

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
        return GuiConstants.WINDOW_SCALE_WIDTH * getInstance().getDisplayWidth() / 100;
    }

    public static int getWindowHeight() {
        return GuiConstants.WINDOW_SCALE_HEIGHT * getInstance().getDisplayHeight() / 100;
    }

    public static Dimension getTableDimension() {
        return new Dimension(getWindowWidth()*99/100, getWindowHeight()*92/100);
    }

//    public static Dimension getWindowDimension() {
//        // todo: handle this in window initialization
//        return new Dimension(getWindowWidth()*96/100, getWindowHeight()*9/10);
//    }

    public static Vector getWindowCenter() {
        return new Vector(getWindowWidth()/2, getWindowHeight()/2);
    }

    public static int getMalletRadius() {
        return (int) (GameParameters.MALET_SIZE * getTableDimension().getHeight());
    }

    public static int getPuckRadius() {
        return (int) (GameParameters.PUCK_SIZE * getTableDimension().getHeight());
    }

    public static int getZoneWidth() {
        return getTableDimension().width * GuiConstants.ZONE_WIDTH/100;
    }
}
