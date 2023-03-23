package logic;

import model.GameObject;
import model.airhockey.Puck;

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
            if (puck.intersects(go)) {
                go.onColide(puck);
            }
        }
    }
}
