package logic;

import model.gameobject.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollisionMap {
//    private int lastIndex;
//    private Map<GameObject, Integer> map;
    private Map<GameObject, List<GameObject>> collisions;

    public CollisionMap() {
//        map = new HashMap<>();
        collisions = new HashMap<>();
//        lastIndex = 0;
    }
//
//    public void add(GameObject go) {
//        map.putIfAbsent(go, lastIndex++);
//    }
//
//    private int getIndex(GameObject go) {
//        return map.get(go);
//    }

    public void collide(GameObject go, GameObject other) {
        add(go, other);
        add(other, go);
    }

    public void exit(GameObject go, GameObject other) {
        remove(go, other);
        remove(other, go);
    }

    private List<GameObject> getList(GameObject go) {
        return collisions.computeIfAbsent(go, key -> new ArrayList<>());
    }


    private void add(GameObject go, GameObject to) {
        List<GameObject> list = getList(to);
        if (!list.contains(go)) {
            list.add(go);
        }
    }

    private void remove(GameObject go, GameObject from) {
        List<GameObject> list = getList(from);
        list.remove(go);
    }

    public boolean isCollided(GameObject go, GameObject other) {
        return getList(go).contains(other);
    }
}
