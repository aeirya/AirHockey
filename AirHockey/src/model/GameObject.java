package model;

public abstract class GameObject {
    private Coordinates coordinates; //up left
    private Coordinates speed;

    public GameObject(Coordinates coordinates, Coordinates speed) {
        this.coordinates = coordinates;
        this.speed = speed;
    }

    public GameObject(Coordinates coordinates){
        this(coordinates , new Coordinates(0 , 0));
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getSpeed() {
        return speed;
    }

    public void setSpeed(Coordinates speed) {
        this.speed = speed;
    }
}
