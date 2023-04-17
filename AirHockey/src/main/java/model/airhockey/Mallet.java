package model.airhockey;

import game.GameParameters;
import gui.config.GuiConfig;
import gui.event.PlayerMoveAction;
import model.Player;
import model.geometric.Circle;
import model.Vector;

public class Mallet extends Circle {
    private final Player player;

    public Mallet(Vector position, int radius, Player player) {
        super(position, radius);
        this.player = player;
    }

    public Mallet(Vector position, Player player) {
        this(position, GuiConfig.getMalletRadius(), player);
    }

    public Mallet(Player player) {
        this(Vector.ZERO, GuiConfig.getMalletRadius(), player);
    }

    public static int getMaxSpeed() {
        return (int) (GameParameters.MALLET_MAX_SPEED * GuiConfig.getWindowHeight());
    }

    public void movePlayer(PlayerMoveAction action) {
        setVelocity(actionToVelocity(action));
    }

    private Vector actionToVelocity(PlayerMoveAction action) {
        return action.getVector().multi(getMaxSpeed());
    }
}
