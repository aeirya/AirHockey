package gui.view;

import model.geometric.Circle;

import java.awt.*;

public class CircleView extends View {
    private int x;
    private int y;
    protected int radius;
    protected Color color;
    private Circle circle;

    protected CircleView(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.color = Color.BLACK;
    }

    protected CircleView() {
        this(0, 0, 0);
    }

    protected CircleView(Color color) {
        this();
        this.color = color;
    }

    public void update(Circle circle) {
        this.circle = circle;
        x = circle.getPosition().getX();
        y = circle.getPosition().getY();
        radius = circle.getRadius();
        if (circle.getColor() != null) {
            color = circle.getColor();
        }
    }

    protected int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics2D g) {
        update(circle);
        g.setStroke(new BasicStroke(10f));
        g.setColor(color);
//        g.drawArc(x - radius, y - radius, 2*radius, 2*radius, 0, 360);
        int r = getRadius();
        g.fillRoundRect(x-r, y-r, 2*r, 2*r, 2*r, 2*r);

        super.draw(g);
    }
}
