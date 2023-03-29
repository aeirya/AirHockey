package model.airhockey;

import game.GameParameters;
import gui.config.GuiConfig;
import model.gameobject.GameObject;
import model.geometric.Circle;
import model.Vector;

import java.util.Timer;
import java.util.TimerTask;

public class Puck extends Circle {
    private boolean exitMode;
    private Timer exitModeTimer;

    public Puck(Vector vector, Vector velocity, int radius) {
        super(vector, velocity, radius);
        exitMode = false;
        exitModeTimer = new Timer();

        setVelocity(velocity.direction((getMaxSpeed() + getMinSpeed())*0.5));
    }

    public Puck(Vector position, Vector velocity) {
        this(position, velocity, GuiConfig.getPuckRadius());
    }

    public Puck(Vector position, int radius, boolean exitMode) {
        super(position, radius);
        this.exitMode = exitMode;
    }

    @Override
    public void onCollide(GameObject other) {
        if (other instanceof Mallet) {
            onCollide((Mallet) other);
        }
        super.onCollide(other);
    }

    private void onCollide(Mallet mallet) {
//        setVelocity(getVelocity().multi(-1));
        bounce(mallet);
        exitModeTimer.cancel();
        exitMode = true;
    }

    @Override
    public void onExit(GameObject other) {
        if (other instanceof Mallet) onExit((Mallet) other);
        super.onExit(other);
    }

    private void onExit(Mallet mallet) {
        exitModeTimer = new Timer();
        exitModeTimer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        exitMode = false;
                    }
                },
                2*GameParameters.GAME_REFRESH_INTERVAL
        );
    }

    @Override
    public void move(double dt) {
        if (exitMode) {
            super.move(dt * 3);
        } else {
            super.move(dt);
            decelerate(dt);
        }
    }

    private void decelerate(double dt) {
        double dv = dt * getDeceleration();
        System.out.println("DV: " + dv);
        if (dv + getMinSpeed() > getVelocity().getSize()) {
            setVelocity(getVelocity().direction(getMinSpeed()));
        } else {
            setVelocity(getVelocity().direction(getVelocity().getSize() - dv));
        }
        System.out.println("V: " + getVelocity());
    }

    private int getDeceleration() {
        return (getMaxSpeed() - getMinSpeed()) / 10;
    }

    private int getMaxSpeed() {
        return Mallet.getMaxSpeed() * 3/2;
    }

    private int getMinSpeed() {
        return getMaxSpeed()/5*3;
    }

    private void bounce(Mallet mallet) {
        Vector malletToPuck = getPosition().sub(mallet.getPosition());
        Vector malletProject = mallet.getVelocity().project(malletToPuck).multi(0.9);
        // only push
        if (malletToPuck.dot(getVelocity()) > 0) {
            System.out.println("dir: " + malletToPuck.toString());
            System.out.println("mallet speed: " + mallet.getVelocity().toString());
            System.out.println("proj" + malletProject.toString());
            System.out.println("v: " + getVelocity().toString());
            setVelocity(getVelocity().add(malletProject));
//            setVelocity(getVelocity().add(mallet.getVelocity()));
        } else {
            Vector projection = getVelocity().project(malletToPuck);
            Vector normal = getVelocity().sub(projection);
            setVelocity(projection.negate().add(normal).add(malletProject));
        }
    }


}
