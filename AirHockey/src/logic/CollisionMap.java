package logic;

import model.gameobject.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionMap {
    private final Map<GameObject, List<GameObject>> collisions;

    public CollisionMap() {
        collisions = new HashMap<>();
    }

    public void collide(GameObject go, GameObject other) {
        add(go, other);
        add(other, go);
    }

    public void exit(GameObject go, GameObject other) {
        remove(go, other);
        remove(other, go);
    }

    private List<GameObject> getCollisionList(GameObject go) {
        return collisions.computeIfAbsent(go, key -> new ArrayList<>());
    }

    private void add(GameObject go, GameObject to) {
        List<GameObject> list = getCollisionList(to);
        if (!list.contains(go)) {
            list.add(go);
        }
    }

    private void remove(GameObject go, GameObject from) {
        getCollisionList(from).remove(go);
    }

    public boolean isCollided(GameObject go, GameObject other) {
        return getCollisionList(go).contains(other);
    }
}
