package model;

public class Controller extends GameObject{
    private int radius;
    public Controller(Coordinates coordinates, Coordinates speed) {
        super(coordinates, speed);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
