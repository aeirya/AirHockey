package gui.view;

import logic.GameState;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View implements Drawable {
    protected List<Drawable> elements;
    private GameState state;

    public View() {
        this.elements = new ArrayList<>();
        state = null;
    }

    @Override
    public void draw(Graphics2D g) {
        for (Drawable e : elements) {
            e.draw(g);
        }
    }

    @Override
    public void update(GameState state) {
        this.state = state;
        for (Drawable e : elements) {
            e.update(state);
        }
    }

    protected void add(Drawable e) {
        elements.add(e);
    }
}
