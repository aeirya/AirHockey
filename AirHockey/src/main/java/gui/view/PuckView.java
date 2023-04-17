package gui.view;

import logic.GameState;

import java.awt.*;

public class PuckView extends CircleView {

    private final CircleView innerCircle;

    public PuckView() {
        this.color = new Color(100, 100, 30);
        innerCircle = new CircleView() {
            @Override
            protected int getRadius() {
                return super.getRadius()/2;
            }
        };
        innerCircle.color = new Color(150, 150, 50);
    }

    @Override
    public void update(GameState state) {
        super.update(state);
        update(state.getPuck());
        innerCircle.update(state.getPuck());
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        innerCircle.draw(g);
    }
}
