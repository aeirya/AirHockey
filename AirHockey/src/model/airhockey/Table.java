package model.airhockey;

import logic.CollisionDetector;
import logic.GameState;
import model.GameObject;
import model.Vector;
import model.airhockey.wall.HorizontalWall;
import model.airhockey.wall.VerticalWall;
import model.airhockey.wall.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private Dimension dimension;
    private Vector center;

    private List<Wall> walls;
    private Puck puck;
    private List<GameObject> objects;
    private CollisionDetector collisionDetector;

    public Table(Dimension dimension, Vector center) {
        objects = new ArrayList<>();
        walls = new ArrayList<>();

        puck = new Puck(center, new Vector(-300, -300), 25);
        collisionDetector = new CollisionDetector(puck);

        this.dimension = dimension;
        this.center = center;

        add(new HorizontalWall(center.add(0, -dimension.height/2), dimension.width));
        add(new HorizontalWall(center.add(0, +dimension.height/2), dimension.width));
        add(new VerticalWall(center.add(-dimension.width/2, 0), dimension.height));
        add(new VerticalWall(center.add(+dimension.width/2, 0), dimension.height));
    }

    private void add(Wall go) {
        collisionDetector.add(go);
        walls.add(go);
    }

    /**
     *
     * @param dt passed time in ms
     */
    public void passTime(double dt) {
        puck.move(dt);
    }

    public void checkCollisions() {
        collisionDetector.checkForBallCollisions();
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Vector getCenter() {
        return center;
    }

    public GameState exportState(GameState state) {
        state.setTable(this);
        state.setPuck(puck);
        state.setWalls(walls);
        return state;
    }
}
