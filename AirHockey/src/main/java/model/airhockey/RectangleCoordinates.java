package model.airhockey;

import model.Dimension;
import model.Vector;

public class RectangleCoordinates {

    private final Vector leftCenter;
    private final Vector rightCenter;
    private final Vector topCenter;
    private final Vector bottomCenter;

    public RectangleCoordinates(Vector center, Dimension dimension) {
        int w = dimension.getWidth()/2;
        int h = dimension.getHeight()/2;

        leftCenter = center.add(-w, 0);
        rightCenter = center.add(+w, 0);
        topCenter = center.add(0, -h);
        bottomCenter = center.add(0, +h);
    }

    public Vector getLeftCenter() {
        return leftCenter;
    }

    public Vector getRightCenter() {
        return rightCenter;
    }

    public Vector getTopCenter() {
        return topCenter;
    }

    public Vector getBottomCenter() {
        return bottomCenter;
    }
}
