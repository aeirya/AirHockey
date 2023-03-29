package model.gameobject;

import model.Vector;

/** Mobile objects */
public class MovableGameObject extends GameObject {
    private Vector velocity;

    protected MovableGameObject(Vector position, Vector velocity) {
        super(position);
        this.velocity = velocity;
    }

    public MovableGameObject(Vector position) {
        this(position, Vector.getZero());
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(int x, int y) {
        setVelocity(new Vector(x, y));
    }

    public void move(int dx, int dy) {
        setPosition(getPosition().add(dx, dy));
    }

    /** updates the location of ball to after moving dt seconds with constant velocity */
    public void move(double dt) {
        move((int)(getVelocity().getX()*dt), (int)(getVelocity().getY()*dt));
    }

    public void halt() {
        setVelocity(0, 0);
    }

    @Override
    public boolean isMobile() {
        return true;
    }
}
