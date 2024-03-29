package gui.config;

/**
 * This class includes the constants used by the gui package
 */
public class GuiConstants {
    private GuiConstants() {}
    
    // 0-100, 100 is equal to fullscreen
    public static final int WINDOW_WIDTH = 75;
    public static final int WINDOW_HEIGHT = 75;

    // 0-100, 100 covers the whole table
    public static final int PUCK_SIZE = 7;
    public static final int GOAL_SIZE = 20;
    public static final int MALLET_SIZE = 8;

    // 100 passes the height of table in a second
    public static final int PUCK_VELOCITY = 100;
    // 100 passes the width of table in a second
    public static final int MALLET_VELOCITY = 100;
}
