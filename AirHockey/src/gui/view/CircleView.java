package gui.view;

import model.Circle;

import java.awt.*;

public abstract class CircleView extends View {
    private int x;
    private int y;
    private int radius;
    protected Color color;

    protected CircleView(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;

        this.color = Color.BLACK;
    }

    protected CircleView() {
        this(0, 0, 0);
    }

    protected void update(Circle circle) {
        x = circle.getPosition().getX();
        y = circle.getPosition().getY();
        radius = circle.getRadius();
    }

    protected int getRadius() {
        return radius;
    }

    @Override
    public void draw(Graphics2D g) {
        System.out.println("drawing puck");
        g.setStroke(new BasicStroke(10f));
        g.setColor(color);
//        g.drawArc(x - radius, y - radius, 2*radius, 2*radius, 0, 360);
        int r = getRadius();
        g.fillRoundRect(x-r, y-r, 2*r, 2*r, r, r);
    }
}
