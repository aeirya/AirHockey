package gui.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Vector;
import model.airhockey.wall.Wall;

public class WallView extends View {
    
    private final Wall wall;

    public WallView(Wall wall) {
        this.wall = wall;
        System.out.println("Initiated wall view");
    }

    @Override
    public void draw(Graphics2D g) {
        Vector start = wall.getStartPoint();
        Vector end = wall.getEndPoint();

        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(wall.getWidth()));
        g.setColor(Color.RED);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
        g.setColor(Color.GREEN);
        drawBullet(g, start);
        drawBullet(g, end);
        g.setStroke(oldStroke);
    }

    private void drawBullet(Graphics2D g, Vector center) {
        int w = wall.getWidth()/2;
        int r = 6*w/5 * 3;

        g.drawArc(center.getX()-r/2, center.getY()-r/2, r, r, 0, 360);
    }
}
