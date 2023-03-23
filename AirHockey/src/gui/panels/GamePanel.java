package gui.panels;

import event.IEventHandler;
import gui.view.Canvas;
import gui.view.Updatable;
import logic.GameState;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Updatable {
    private final Canvas canvas;

    public GamePanel(IEventHandler eventHandler) {
        canvas = new Canvas();
    }

    @Override
    protected void paintComponent(Graphics g) {
        canvas.draw((Graphics2D) g);
    }

    @Override
    public void update(GameState state) {
        canvas.update(state);
    }
}
