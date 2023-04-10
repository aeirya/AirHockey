package model.airhockey.wall;

import model.Dimension;
import model.Vector;
import model.airhockey.Mallet;
import model.airhockey.Puck;
import model.gameobject.GameObject;

import java.awt.*;

public class MidtableLine extends VerticalWall {
    public MidtableLine(Vector position, int length) {
        super(position, length);
        setWidth(5);
        setColor(Color.GRAY);
    }

    @Override
    public void onCollide(GameObject go) {
        if (go instanceof Mallet mal) {
            mal.halt();
            System.out.println("midtable on!");
            if (mal.getX() < getX()) {
                mal.setPosition(new Vector(getX() - mal.getRadius(), mal.getY()));
            } else {
                mal.setPosition(new Vector(getX() + mal.getRadius(), mal.getY()));
            }
        }
    }
}
