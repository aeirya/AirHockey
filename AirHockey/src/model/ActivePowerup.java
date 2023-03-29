package model;

import logic.GameState;

public class ActivePowerup {
    private PowerUp powerup;

    public ActivePowerup() {
        powerup = null;
    }

    public ActivePowerup set(PowerUp powerup) {
        this.powerup = powerup;
        return this;
    }

    public void remove() {
        powerup = null;
    }

    public void visit(GameState state) {
        if (powerup != null) {
            powerup.apply(state);
        }
    }
}
