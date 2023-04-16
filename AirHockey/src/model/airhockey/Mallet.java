package model.airhockey;

import game.GameParameters;
import gui.config.GuiConfig;
import gui.event.PlayerMoveAction;
import model.geometric.Circle;
import model.Vector;

public class Mallet extends Circle {
    public Mallet(Vector position, int radius) {
        super(position, radius);
    }

    public Mallet(Vector position) {
        this(position, GuiConfig.getMalletRadius());
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
