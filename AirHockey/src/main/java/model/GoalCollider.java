package model;

import model.geometric.Circle;
import model.geometric.Rectangle;

public class GoalCollider extends Rectangle {
    public GoalCollider(Vector position, Dimension size) {
        super(position, size);
    }

    @Override
    public boolean intersects(Circle circle) {
        int centerDistance = Math.abs(circle.getPosition().getX() - getPosition().getX());
        return centerDistance < circle.getRadius() + getSize().getWidth()/2 &&
                circle.getPosition().getY() + circle.getRadius() < getPosition().getY() + getSize().getHeight() &&
                circle.getPosition().getY() - circle.getRadius() > getPosition().getY() - getSize().getHeight();
    }
}
