package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Main Menu
 */
public class StartPanel extends JPanel {
    public StartPanel() {
        add(new CenterPanel());
    }

    class CenterPanel extends JPanel {
        CenterPanel() {
            setSize(
                    StartPanel.this.getWidth() * 7 / 10,
                    StartPanel.this.getHeight() * 7 / 10
            );
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JButton("Start Game"));
            add(new JButton("Quit Game"));
        }
    }
}
