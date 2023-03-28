package gui.view;

import game.GameParameters;
import logic.GameState;
import model.Goal;
import model.Vector;
import model.airhockey.Table;
import model.airhockey.wall.Wall;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableView extends View {
//    private final PuckView puck;
//    private final List<WallView> walls;

    private Color backgroundColor;
    private int width;
    private int height;
    private Vector position;
    private Table table;

    public TableView() {
//        walls = new ArrayList<>();
//        puck = new PuckView();
//        add(puck);
    }

    @Override
    public void update(GameState state) {
        elements.clear();

        backgroundColor = GameParameters.TABLE_COLOR;
        updateParams(state);

        add(new PuckView());
        addWalls(state.getWalls());
        add(new MalletView(state.getPlayer1()));
        add(new MalletView(state.getPlayer2()));
        addGoals(state.getGoals());
        super.update(state);
    }

    private void updateParams(GameState state) {
        table = state.getTable();
        width = (int) table.getDimension().getWidth();
        height = (int) table.getDimension().getHeight();
        position = table.getCenter().add(-width/2, -height/2);
    }

    private void addWalls(List<Wall> wallModels) {
//        walls.clear();
        for (Wall wall : wallModels) {
            add(new WallView(wall));
        }
    }

    private void addGoals(List<Goal> goals) {
        int i = 0;
        for (Goal goal : goals) {
            add(new GoalView(i++));
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRoundRect(
                position.getX(), position.getY(), width, height, 5, 5
        );

        // center circle
        int r = width / 9;
        g.setStroke(new BasicStroke(10f));
        g.setColor(Color.LIGHT_GRAY);
//        g.drawArc(position.getX() - r, position.getY() - r, r, r, 0, 360);
        int cX = table.getCenter().getX() - r;
        int cY = table.getCenter().getY() - r;
        g.drawRoundRect(cX, cY, 2*r, 2*r, 2*r, 2*r);
        super.draw(g);
    }
}
