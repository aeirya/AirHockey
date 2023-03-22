package model;

public class GameObject {
    private Vector position; //up left
    private Vector velocity;

    protected GameObject(Vector position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    protected GameObject(Vector position){
        this(position, new Vector(0 , 0));
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
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

}
