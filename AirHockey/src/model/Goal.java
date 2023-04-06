package model;

import game.IGame;
import model.airhockey.Puck;
import model.gameobject.GameObject;
import model.geometric.Circle;
import model.geometric.Rectangle;

public class Goal extends Rectangle {
    private GoalCollider collider;
    private PlayerID id;
    private IGame game;

    public Goal(Vector position, Vector size, PlayerID id, IGame game) {
        super(position, size);
        collider = new GoalCollider(position, new Dimension(size.getX()/6, size.getY()));
        this.id = id;
        this.game = game;
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
//        System.out.println("Score!");
        game.goal(this.id);
    }

    public Rectangle getInnerCollider() {
        return collider;
    }
}
