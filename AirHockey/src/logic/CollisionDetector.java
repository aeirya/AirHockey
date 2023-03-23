package logic;

import model.GameObject;
import model.airhockey.Puck;
import model.airhockey.wall.Wall;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {
    private Puck puck;
    private List<GameObject> otherObjects;

    public CollisionDetector(Puck puck) {
        this.puck = puck;
        otherObjects = new ArrayList<>();
    }

    public void add(GameObject go) {
        otherObjects.add(go);
    }

    public void checkForBallCollisions() {
        for (GameObject go : otherObjects) {
            if (go instanceof Wall) checkWall((Wall) go);
            else if (go.intersects(puck)) {
                System.out.println("an intersection!");
                go.onColide(puck);
            }
        }
    }

    private void checkWall(Wall wall) {
        if (wall.intersects(puck)) wall.onColide(puck);
    }

}
