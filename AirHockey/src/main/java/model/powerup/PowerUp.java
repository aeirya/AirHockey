package model.powerup;

import event.IGameEventHandler;
import gui.config.GuiConfig;
import logic.GameState;
import model.Vector;
import model.gameobject.GameObject;
import model.geometric.Circle;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class PowerUp extends Circle {
    private boolean isHidden = false;
    private IGameEventHandler handler;

    private PowerUp(Vector position, int radius, Color color, IGameEventHandler handler) {
        super(position, radius, color);
        this.handler = handler;
    }

    public PowerUp(Vector position, Color color, IGameEventHandler handler) {
        this(position, GuiConfig.getPuckRadius()*3, color, handler);
    }

    @Override
    public boolean isMobile() {
        return false;
    }

    public void hide() {
        isHidden = true;
    }

    public void show() {
        isHidden = false;
    }

    public boolean isVisible() {
        return !isHidden;
    }

    @Override
    public void onCollide(GameObject other) {
        hide();
        handler.activatePowerup();
    }

    @Override
    public void onExit(GameObject other) {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        show();
                    }
                }, 2000);
    }

    public abstract void apply(GameState state);
}
