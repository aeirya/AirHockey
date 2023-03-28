package gui.view;

import logic.GameState;
import model.Goal;

import java.awt.*;

public class GoalView implements Drawable {
    private Goal goal;
    private int id;

    public GoalView(int id) {
        this.id = id;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setStroke(new BasicStroke(10f));
        g.setColor(Color.LIGHT_GRAY);
        int width = goal.getSize().getX();
        int height = goal.getSize().getY();
        g.drawArc(
                goal.getPosition().getX() - width/2, goal.getPosition().getY() - height/2,
                width, height,
                -90, 180
                );
    }

    @Override
    public void update(GameState state) {
        goal = state.getGoals().get(id);
    }
}
