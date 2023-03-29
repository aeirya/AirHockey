package model.gameobject;

import model.Dimension;
import model.Vector;

import java.awt.*;

// TODO: use vector values between zero and one and scale them to screen size
public class GameObject {
    private Vector position; //up left
    private Vector size;
    private Color color;

    protected GameObject(Vector position) {
        this.position = position;
    }

    protected GameObject(Vector position, Vector size) {
        this.position = position;
        this.size = size;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void onCollide(GameObject other) {}

    public void onExit(GameObject other) {}

    public boolean intersects(GameObject other) {
        return false;
    }

    public Dimension getSize() {
        return new Dimension(size);
    }

    public Vector getTopLeft() {
        return getPosition().add(-getSize().getX()/2, -getSize().getY()/2);
    }

    public Vector getBottomRight() {
        return getPosition().add(+getSize().getX()/2, +getSize().getY()/2);
    }

    public int getWidth() {
        return getSize().getWidth();
    }

    public int getHeight() {
        return getSize().getHeight();
    }

    public int getX() {
        return getPosition().getX();
    }

    public int getY() {
        return getPosition().getY();
    }

    public Color getColor() {
        return color;
    }

    public GameObject setColor(Color color) {
        this.color = color;
        return this;
    }

    public boolean isMobile() {
        return false;
    }
}
