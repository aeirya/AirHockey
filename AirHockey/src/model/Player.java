package model;

import game.GameParameters;
import gui.config.GuiConfig;
import model.geometric.Circle;

public class Player extends Circle {
    int id;
    int score;
    ActivePowerup powerup;

    public Player(int id) {
        super(new Vector(0, 0), GuiConfig.getMalletRadius());
        this.id = id;
        score = 0;
        powerup = null;
    }

    public int getID() {
        return id;
    }
}
