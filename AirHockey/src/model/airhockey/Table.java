package model.airhockey;

import game.IGame;
import logic.CollisionDetector;
import logic.GameState;
import model.Goal;
import model.PlayerID;
import model.geometric.Rectangle;
import model.powerup.PowerUp;
import model.airhockey.wall.MidtableLine;
import model.gameobject.GameObject;
import model.Vector;
import model.airhockey.wall.HorizontalWall;
import model.airhockey.wall.VerticalWall;
import model.airhockey.wall.Wall;
import model.geometric.Circle;

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
    private List<Goal> goals;

    private Rectangle rect;
    private Vector leftWallCenter;
    private Vector rightWallCenter;
    private final Vector topWallCenter;
    private final Vector bottomWallCenter;


    public Table(Dimension dimension, Vector center, Mallet p1, Mallet p2, PowerUp power, IGame game) {
        objects = new ArrayList<>();
        walls = new ArrayList<>();
        mallets = new ArrayList<>();
        goals = new ArrayList<>();

        puck = new Puck(center, new Vector(-1, -1));
        collisionDetector = new CollisionDetector(puck);

        rect = new Rectangle(center, new Vector(dimension.width, dimension.height));
        this.dimension = dimension;
        this.center = center;

        leftWallCenter = center.add(-dimension.width/2, 0);
        rightWallCenter = center.add(+dimension.width/2, 0);
        topWallCenter = center.add(0, -dimension.height/2);
        bottomWallCenter = center.add(0, +dimension.height/2);

        Vector goalSize = new Vector(dimension.height*2/5, dimension.height*2/5);

        add(new HorizontalWall(topWallCenter, dimension.width));
        add(new HorizontalWall(bottomWallCenter, dimension.width));
        add(new VerticalWall(leftWallCenter, dimension.height));
        add(new VerticalWall(rightWallCenter, dimension.height));

        add(new MidtableLine(center, dimension.height));
//        add(new Goal(leftWallCenter.add(goalSize.getX()/2, 0), goalSize));
//        add(new Goal(rightWallCenter.add(-goalSize.getX()/2, 0), goalSize));
        add(new Goal(leftWallCenter, goalSize, PlayerID.ONE, game));
        add(new Goal(rightWallCenter, goalSize, PlayerID.TWO, game));
        add(p1);
        add(p2);
        add(power);
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
        if (go instanceof Goal) {
            goals.add((Goal) go);
        }
    }

    /**
     *
     * @param dt passed time in ms
     */
    public void passTime(double dt) {
        puck.move(dt);
        for (Mallet mallet : mallets) {
            mallet.move(dt);
            if (collisionDetector.checkIntersections(mallet)) {
                mallet.move(-dt);
//                if (collisionDetector.checkIntersections(mallet)) {
//                    mallet.move(2*dt);
//                }
            }
        }
    }

    public void checkOutsideBounds() {
        // check outside bounds
        for (var go : collisionDetector.getDynamicObjects()) {
            if (!isInsideTable(go)) {
                int x = go.getX();
                int y = go.getY();
                if (go.getX() < rect.getLeftX()) {
                    x = rect.getLeftX() + dimension.width/2;
                }
                if (go.getX() > rect.getRightX()) {
                    x = rect.getRightX() - dimension.width/2;
                }
                if (go.getY() < rect.getTopY()) {
                    y = rect.getTopY() + dimension.height/2;
                }
                if (go.getY() > rect.getTopY()) {
                    y = rect.getBottomY() - dimension.height/2;
                }
                go.setPosition(x, y);
            }
        }
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
        state.setGoals(goals);
        return state;
    }

    public boolean intersectsCenterLine(Circle circle) {
        return Math.abs(circle.getX() - center.getX()) < circle.getRadius();
    }

    public boolean intersectsAfterMove(GameObject go, Vector dx) {
        return collisionDetector.intersectsAny(go.movedCollider(dx), List.of(go));
    }

    public boolean intersectsAny(GameObject go) {
        return collisionDetector.intersectsAny(go);
    }

    public boolean isInsideTable(GameObject go) {
        return rect.isInside(go.getPosition());
    }

    public Vector getLeftWallCenter() {
        return leftWallCenter;
    }

    public Vector getRightWallCenter() {
        return rightWallCenter;
    }

    public Vector getTopWallCenter() {
        return topWallCenter;
    }

    public Vector getBottomWallCenter() {
        return bottomWallCenter;
    }
}
