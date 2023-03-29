package logic;

import model.gameobject.GameObject;
import model.airhockey.Puck;
import model.gameobject.MovableGameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollisionDetector {
    private List<GameObject> dynamicObjects;
    private List<GameObject> staticObjects;
    private CollisionMap collisionMap;

    public CollisionDetector(Puck puck) {
        collisionMap = new CollisionMap();
        staticObjects = new ArrayList<>();
        dynamicObjects = new ArrayList<>();
        add(puck);
    }

    public void add(GameObject go) {
        if (go.isMobile()) {
            dynamicObjects.add(go);
        } else {
            staticObjects.add(go);
        }
    }

    public void checkForBallCollisions() {
        for (GameObject dynamic : dynamicObjects) {
            for (GameObject go : staticObjects) {
                checkIntersection(go, dynamic);
            }
            for (GameObject go : dynamicObjects) {
                if (go == dynamic) continue;
                checkIntersection(go, dynamic);
            }
        }
    }

    private void checkIntersection(GameObject go, GameObject other) {
        boolean intersects = go.intersects(other);
        if (!collisionMap.isCollided(go, other) && intersects) {
            go.onCollide(other);
            other.onCollide(go);
            collisionMap.collide(go, other);
        }
        if (collisionMap.isCollided(go, other) && !intersects) {
            go.onExit(other);
            other.onExit(go);
            collisionMap.exit(go, other);
        }
    }
}
