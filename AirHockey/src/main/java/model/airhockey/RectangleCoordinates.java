package model.airhockey;

import model.Dimension;
import model.Vector;

public class RectangleCoordinates {

    private final Vector leftCenter;
    private final Vector rightCenter;
    private final Vector topCenter;
    private final Vector bottomCenter;

    private final Vector center;

    /* half of width and height */
    private final int hw;
    private final int hh;

    public RectangleCoordinates(Vector center, Dimension dimension) {
        hw = dimension.getWidth()/2;
        hh = dimension.getHeight()/2;

        leftCenter = center.add(-hw, 0);
        rightCenter = center.add(+hw, 0);
        topCenter = center.add(0, -hh);
        bottomCenter = center.add(0, +hh);

        this.center = center;
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

    public Vector getCenter() {
        return center;
    }
}
