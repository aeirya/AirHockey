package model;

import model.airhockey.Puck;
import model.gameobject.GameObject;
import model.geometric.Circle;
import model.geometric.Rectangle;

public class Goal extends Rectangle {
    private GoalCollider collider;

    public Goal(Vector position, Vector size) {
        super(position, size);
        collider = new GoalCollider(position, new Dimension(size.getX()/6, size.getY()));
    }

    @Override
    public boolean intersects(Circle circle) {
        return collider.intersects(circle);
    }

    @Override
    public boolean intersects(GameObject other) {
        if (other instanceof Puck) {
            return intersects((Puck) other);
        }
        return super.intersects(other);
    }

    @Override
    public void onCollide(GameObject other) {
        if (other instanceof Puck) {
            onCollide((Puck) other);
        }
        super.onCollide(other);
    }

    private void onCollide(Puck puck) {
        System.out.println("Score!");
    }

    public Rectangle getInnerCollider() {
        return collider;
    }
}
