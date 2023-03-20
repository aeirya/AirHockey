package model;

public abstract class GameObject {
    private Vector position; //up left
    private Vector speed;

    public GameObject(Vector position, Vector speed) {
        this.position = position;
        this.speed = speed;
    }

    public GameObject(Vector position){
        this(position, new Vector(0 , 0));
    }

    public Vector getCoordinates() {
        return position;
    }

    public void setCoordinates(Vector vector) {
        this.position = vector;
    }

    public Vector getSpeed() {
        return speed;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }
}
