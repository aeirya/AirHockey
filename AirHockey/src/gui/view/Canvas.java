package gui.view;

import logic.GameState;
import model.Vector;
import model.geometric.Circle;
import model.geometric.TwoCircleView;

import java.awt.*;

public class Canvas extends View {
    private final TableView table;

    public Canvas() {
        table = new TableView();

        add(table);
    }
}
