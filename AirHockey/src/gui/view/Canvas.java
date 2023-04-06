package gui.view;

import gui.config.GuiConfig;
import gui.config.GuiConstants;
import logic.GameState;
import model.Vector;
import model.geometric.Circle;
import model.geometric.TwoCircleView;

import java.awt.*;

public class Canvas extends View {
    private final TableView table;
    private final TimerView timer;

    public Canvas() {
        table = new TableView();

        //todo config
        int width = 100;
        int height = 50;
        int x = GuiConfig.getWindowCenter().getX() - width/2;
        int y = 0;
        timer = new TimerView(x , y , width , height , Color.BLACK , Color.WHITE , 20);

        add(table);
        add(timer);
    }
}
