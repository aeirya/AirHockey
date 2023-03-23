package gui.view;

import logic.GameState;

import java.awt.*;

public class Canvas extends View {
    private final TableView table;

    public Canvas() {
        table = new TableView();
        add(table);
    }
}
