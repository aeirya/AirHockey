package gui.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Vector;
import model.airhockey.wall.Wall;

public class WallView implements Drawable {
    
    private final Wall wall;

    public WallView(Wall wall) {
        this.wall = wall;
    }

    @Override
    public void draw(Graphics2D g) {
        Vector start = wall.getStartPoint();
        Vector end = wall.getEndPoint();

        Stroke oldStroker = g.getStroke();
        g.setStroke(new BasicStroke(5f));
        g.setColor(Color.BLACK);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
