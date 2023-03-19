package gui.panels;

import javax.swing.*;
import java.awt.*;

public class NewGamePanel extends JPanel {
    public NewGamePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JCheckBox("Time Limited"));
        add(new JCheckBox("Goal Limited"));
        add(new Button("Start Game"));
    }
}
