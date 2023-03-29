package model.powerup.impl;

import event.IGameEventHandler;
import logic.GameState;
import model.Vector;
import model.powerup.PowerUp;

import java.awt.*;

public class FastBallPowerUp extends PowerUp {
    private final double multiplier;

    public FastBallPowerUp(Vector position, double multiplier, IGameEventHandler handler) {
        super(position, Color.PINK, handler);
        this.multiplier = multiplier;
    }

    public FastBallPowerUp(Vector position, IGameEventHandler handler) {
        this(position, 2, handler);
    }

    // TODO: eather use gamestate in logic or change this
    public void apply(GameState state) {
        state.getPuck().setVelocity(
                state.getPuck().getVelocity().multi(multiplier)
        );
    }
}
