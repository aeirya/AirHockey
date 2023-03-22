package model;

public class Vector {
    private int x;
    private int y;

    public Vector(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /** Squared euclidean distance of two vectors */
    public int dist2(Vector other) {
        return (x - other.x)^2 + (y - other.y)^2;
    }
}
