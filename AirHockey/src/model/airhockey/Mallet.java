package model.airhockey;

import gui.config.GuiConfig;
import model.gameobject.GameObject;
import model.geometric.Circle;
import model.Vector;

public class Mallet extends Circle {
    private int playerID;

    public Mallet(Vector position, int radius, int playerID) {
        super(position, radius);
        this.playerID = playerID;
    }

    public Mallet(Vector position, int playerID) {
        this(position, GuiConfig.getMalletRadius(), playerID);
    }

    public void onCollide(Puck puck) {
        System.out.println("hitting a puck with a mallet");
//        puck.setVelocity(
//                puck.getVelocity().multi(-1).add(this.getVelocity().multi(2))
//        );
    }

    @Override
    public void onCollide(GameObject other) {
        if (other instanceof Puck) {
            onCollide((Puck) other);
        }
        halt();
//        System.out.println("halting mallet");
    }

    @Override
    public void move(double dt) {
        super.move(dt);
    }
}
