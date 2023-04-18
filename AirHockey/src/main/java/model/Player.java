package model;

import gui.config.GuiConfig;
import model.airhockey.Mallet;
import model.powerup.ActivePowerup;

public class Player {
    int id;
    int score;
    ActivePowerup powerup;
    Mallet mallet;

    public Player(int id) {
        mallet = new Mallet(new Vector(0, 0), this);
        this.id = id;
        score = 0;
        powerup = null;
    }

    public int getID() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public ActivePowerup getPowerup() {
        return powerup;
    }

    public Mallet getMallet() {
        return mallet;
    }

    public void halt() {
        mallet.halt();
    }

    public void increaseScore() {
        score++;
    }
}