package gui.view;

import gui.config.GuiConfig;
import logic.GameState;
import model.Dimension;
import model.Goal;
import model.Vector;
import model.geometric.Rectangle;

import java.awt.*;

public class GoalView implements Drawable {
    private Goal goal;
    private int id;
    private int width;
    private int height;

    public GoalView(int id) {
        this.id = id;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setStroke(new BasicStroke(10f));
        g.setColor(Color.LIGHT_GRAY);
        drawBox(g);
        drawInnerCollider(g);
    }

    private void drawArc(Graphics2D g) {
        int arcWidth = width;
        int arcHeight = height;
        g.drawArc(
                goal.getPosition().getX() - arcWidth/2, goal.getPosition().getY() - arcHeight/2,
                arcWidth, arcHeight,
                -90, 180
        );
    }

    private void drawInnerCollider(Graphics2D g) {
        drawRect(g, goal.getInnerCollider());
    }

    private void drawBox(Graphics2D g) {
        g.drawRoundRect(
                goal.getTopLeft().getX(), goal.getTopLeft().getY(),
                goal.getSize().getWidth(), goal.getSize().getHeight(),
                goal.getSize().getWidth()*2/3,
                goal.getSize().getHeight()*2/3
                );
    }

    private void drawRect(Graphics2D g, Rectangle rect) {
        g.drawRoundRect(
                rect.getTopLeft().getX(),
                rect.getTopLeft().getY(),
                rect.getWidth(),
                rect.getHeight(),
                rect.getWidth()/2,
                rect.getHeight()/2);
    }

    private void drawInnerBox(Graphics2D g) {
        Dimension size = getInnerGoalSize();

        g.drawRoundRect(
                goal.getPosition().getX() - size.getWidth()/2, goal.getPosition().getY() - size.getHeight()/2,
                size.getWidth(), size.getHeight(),
                size.getWidth()/2,
                size.getHeight()/2
                );
    }

    private Dimension getInnerGoalSize() {
        return new Dimension(goal.getSize().div(3));
    }

    @Override
    public void update(GameState state) {
        goal = state.getGoals().get(id);
        width = goal.getSize().getX();
        height = goal.getSize().getY();
    }
}
