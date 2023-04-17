package model.geometric;

import gui.view.CircleView;

import java.awt.*;

public class TwoCircleView extends CircleView {
    private final CircleView innerCircle;
    private final float innerCircleRatio;

    public TwoCircleView(Color outColor, Color inColor, float innerCircleRatio) {
        super(outColor);
        this.innerCircleRatio = innerCircleRatio;

        innerCircle = new CircleView(inColor) {
            @Override
            protected int getRadius() {
                return (int) (super.getRadius() * innerCircleRatio);
            }
        };
        add(innerCircle);
    }

    @Override
    public void update(Circle circle) {
        super.update(circle);
        innerCircle.update(circle);
    }

    public void setOutColor(Color color) {
        this.color = color;
    }
}
