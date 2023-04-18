package gui.view;

import game.GameParameters;
import gui.config.GuiConfig;
import logic.GameState;
import model.Goal;
import model.Vector;
import model.airhockey.Table;
import model.airhockey.wall.MidtableLine;
import model.airhockey.wall.Wall;

import java.awt.*;
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


        add(new CircleView() {
            @Override
            public void update(GameState state) {
                if (state.getPowerup() != null) {
                   this.update(state.getPowerup());
                }
            }

            @Override
            public void draw(Graphics2D g) {
                if (state.getPowerup().isVisible()) {
                    super.draw(g);
                }
            }
        });
        add(new ScoreView(state.getPlayer1()));
        add(new ScoreView(state.getPlayer2()));

        add(new MalletView(state.getPlayer1()));
        add(new MalletView(state.getPlayer2()));

        addGoals(state.getGoals());
        addWalls(state.getWalls());
        add(new PuckView());
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
            if (wall instanceof MidtableLine) {
                add(new WallView(wall));
            } else {
                add(new WallView(wall));
            }
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

        // zone box
        drawZones(g);

        // center circle
        int r = width / 9;
        g.setStroke(new BasicStroke(10f));
        g.setColor(Color.LIGHT_GRAY);
//        g.drawArc(position.getX() - r, position.getY() - r, r, r, 0, 360);
        int cX = table.getCenter().getX() - r;
        int cY = table.getCenter().getY() - r;
        g.drawRoundRect(cX, cY, 2*r, 2*r, 2*r, 2*r);

        drawInnerDot(g);
        super.draw(g);
    }

    private void drawZones(Graphics2D g) {
        int width = GuiConfig.getZoneWidth();
        int height = table.getDimension().getHeight();
        int y = table.getTopWallCenter().getY();
        int x1 = table.getLeftWallCenter().getX();
        int x2 = table.getRightWallCenter().getX() - width;

        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x1, y, width, height);
        g.drawRect(x2, y, width, height);
    }

    private void drawInnerDot(Graphics2D g) {
        int r = width/48;
        var c = table.getCenter();
        g.fillRoundRect(c.getX()-r, c.getY()-r, r*2, r*2, r*3/2, r*3/2);
    }
}
