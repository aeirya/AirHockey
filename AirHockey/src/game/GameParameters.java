package game;

import java.awt.*;

public class GameParameters {
    private GameParameters() {}

    public static final int SCREEN_WIDTH = 440;
    public static final int SCREEN_HEIGHT = 440;
    public static final int FPS = 60;
    public static final int GAME_REFRESH_INTERVAL = 1000/FPS/2;
    public static final double gameSpeed = 0.75;

    public static final Color CANVAS_COLOR = new Color(20, 50, 100);
    public static final Color TABLE_COLOR = new Color(20, 50, 100);

    /** mallet size with respect to table vertical */
    public static final float MALET_SIZE = 0.06f;
    public static final float MALLET_MAX_SPEED = 0.7f;

    public static final float PUCK_SIZE = 0.04f;

}
