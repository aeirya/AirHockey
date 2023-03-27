package model.airhockey;

import gui.config.GuiConfig;
import logic.CollisionDetector;
import logic.GameState;
import model.gameobject.GameObject;
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
    private List<Mallet> mallets;
    private CollisionDetector collisionDetector;

    public Table(Dimension dimension, Vector center, Mallet p1, Mallet p2) {
        objects = new ArrayList<>();
        walls = new ArrayList<>();
        mallets = new ArrayList<>();

        puck = new Puck(center, new Vector(-300, -300), 25);
        collisionDetector = new CollisionDetector(puck);

        this.dimension = dimension;
        this.center = center;

        add(new HorizontalWall(center.add(0, -dimension.height/2), dimension.width));
        add(new HorizontalWall(center.add(0, +dimension.height/2), dimension.width));
        add(new VerticalWall(center.add(-dimension.width/2, 0), dimension.height));
        add(new VerticalWall(center.add(+dimension.width/2, 0), dimension.height));

        add(p1);
        add(p2);
//        add(new Mallet(center.add(-dimension.width/3, 0), GuiConfig.getMalletRadius(), 0));
//        add(new Mallet(center.add(+dimension.width/3, 0), GuiConfig.getMalletRadius(), 1));
    }

    private void add(GameObject go) {
        collisionDetector.add(go);
        if (go instanceof Wall) {
            walls.add((Wall) go);
        }
        if (go instanceof Mallet) {
            mallets.add((Mallet) go);
        }
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
        state.setMallets(mallets);
        return state;
    }
}
