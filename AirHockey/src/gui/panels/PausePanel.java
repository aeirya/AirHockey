package gui.panels;

import event.IEventHandler;

import javax.swing.*;
import java.awt.*;

public class PausePanel extends Panel{
    public PausePanel(IEventHandler eventHandler) {
        super(eventHandler);
        CenterPanel centerPanel = new CenterPanel(500 , 500);
        add(centerPanel);
    }

    class CenterPanel extends JPanel{
        CenterPanel(int width , int height){
            setSize( width , height);
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton mainMenu = new JButton("Main Menu");
            JButton resume = new JButton("Resume"); //TODO add icon

            add(mainMenu);
            add(resume);
        }
    }
}

