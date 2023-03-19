package gui;

import gui.config.GuiConfig;
import gui.panels.StartPanel;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Air Hockey");
        setResizable(false);
        setSize(GuiConfig.getWindowWidth(), GuiConfig.getWindowHeight());

        setContentPane(new StartPanel());

        setVisible(true);
        setLocationRelativeTo(null);
    }
}
