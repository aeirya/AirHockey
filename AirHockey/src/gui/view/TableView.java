package gui.view;

import game.GameParameters;
import logic.GameState;
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

        super.update(state);
    }

    private void updateParams(GameState state) {
        Table table = state.getTable();
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

    @Override
    public void draw(Graphics2D g) {
        g.setColor(backgroundColor);
        g.fillRoundRect(
                position.getX(), position.getY(), width, height, 5, 5
        );
        super.draw(g);
    }
}
