package model.airhockey;

import game.GameParameters;
import gui.config.GuiConfig;
import gui.event.PlayerMoveAction;
import model.airhockey.wall.HorizontalWall;
import model.airhockey.wall.VerticalWall;
import model.airhockey.wall.Wall;
import model.gameobject.GameObject;
import model.geometric.Circle;
import model.Vector;

import java.util.Timer;
import java.util.TimerTask;

public class Mallet extends Circle {
    private int playerID;

    private Wall currentBarrier;
    private boolean stayOnLeftOrTop;
    private Timer exitTimer;

    public Mallet(Vector position, int radius, int playerID) {
        super(position, radius);
        this.playerID = playerID;
        currentBarrier = null;
        exitTimer = new Timer();
    }

    public Mallet(Vector position, int playerID) {
        this(position, GuiConfig.getMalletRadius(), playerID);
    }

    public void onCollide(Puck puck) {
//        System.out.println("hitting a puck with a mallet");
//        puck.setVelocity(
//                puck.getVelocity().multi(-1).add(this.getVelocity().multi(2))
//        );
    }

    private void onCollide(Wall wall) {
        exitTimer.cancel();
        currentBarrier = wall;
//        if (wall instanceof HorizontalWall) {
//            stayOnLeftOrTop = getY() < wall.getY();
//        }
//        if (wall instanceof VerticalWall) {
//            stayOnLeftOrTop = getX() < wall.getX();
//        }
//        wall.pushAway(this);
    }

    @Override
    public void onExit(GameObject other) {
        exitTimer.cancel();
        if (other instanceof Wall) {
            exitTimer = new Timer();
            exitTimer.schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            currentBarrier = null;
                        }
                    }, 1000
            );
        }
        super.onExit(other);
    }

    @Override
    public void onCollide(GameObject other) {
        if (other instanceof Puck) {
            onCollide((Puck) other);
        }
        if (other instanceof Wall) {
            onCollide((Wall) other);
        }
//        halt();
//        System.out.println("halting mallet");
    }

    @Override
    public void move(int dx, int dy) {
//        if (currentBarrier != null)  {
//            if (stayOnLeftOrTop) {
//                if (
//                        getX() + getRadius() + dx > currentBarrier.getX() ||
//                        getY() + getRadius() + dy > currentBarrier.getY()
//                ) return;
//            } else {
//                if (
//                        getX() - getRadius() + dx < currentBarrier.getX() ||
//                        getY() - getRadius() + dy < currentBarrier.getY()
//                ) return;
//            }
//            if (currentBarrier instanceof VerticalWall) {
//                int distX = getX() - currentBarrier.getX();
//                if (distX * (distX + dx) < 0) return;
//            }
//            if (currentBarrier instanceof HorizontalWall) {
//                int distY = getY() - currentBarrier.getY();
//                if (distY * (distY + dy) < 0) return;
//            }
//        }
//        if (currentBarrier != null && currentBarrier.dist(this) > currentBarrier.dist(this.movedCollider())) return;
        super.move(dx, dy);
    }

    @Override
    public void move(double dt) {
        super.move(dt);
    }

    public static int getMaxSpeed() {
        return (int) (GameParameters.MALLET_MAX_SPEED * GuiConfig.getWindowHeight());
    }

    public void movePlayer(PlayerMoveAction action) {
        setVelocity(actionToVelocity(action));
    }

    private Vector actionToVelocity(PlayerMoveAction action) {
        return action.getVector().multi(getMaxSpeed());
    }

    public GameObject movedCollider(PlayerMoveAction action) {
//        double dt = GameParameters.GAME_REFRESH_INTERVAL;
        double dt = 1000;
        Vector v = actionToVelocity(action);
        return movedCollider(v.multi(2*dt));
    }

    @Override
    public boolean intersects(Wall wall) {
        boolean result = super.intersects(wall);
//        if (result) System.out.println("intersectinnnng");
        return result;
    }
}
