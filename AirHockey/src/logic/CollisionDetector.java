package logic;

import model.Vector;
import model.gameobject.GameObject;
import model.airhockey.Puck;
import model.gameobject.MovableGameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
            checkIntersections(dynamic);
        }
    }

    public boolean checkIntersections(GameObject dynamic) {
        boolean intersects = false;
        for (GameObject go : staticObjects) {
            intersects = intersects | checkIntersection(go, dynamic);
        }
        for (GameObject go : dynamicObjects) {
            if (go == dynamic) continue;
            intersects = intersects | checkIntersection(go, dynamic);
        }
        return intersects;
    }

    private boolean checkIntersection(GameObject go, GameObject other) {
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
        return intersects;
    }

    public boolean intersectsAny(GameObject go) {
        return allObjects().anyMatch(obj -> obj != go && obj.intersects(go));
    }

    private Stream<GameObject> allObjects() {
        return Stream.concat(staticObjects.stream(), dynamicObjects.stream());
    }
}
