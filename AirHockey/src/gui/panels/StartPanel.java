package gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * Main Menu
 */
public class StartPanel extends JPanel {
    public StartPanel() {
        setLayout(new GridBagLayout());
        add(new CenterPanel(), new GridBagConstraints());
    }

    class CenterPanel extends JPanel {
        CenterPanel() {
            setSize(
                    new Dimension(
                    StartPanel.this.getWidth() * 7 / 10,
                    StartPanel.this.getHeight() * 7 / 10
                    ));
            setBackground(Color.LIGHT_GRAY);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(new JButton("New Game"));
            add(new JButton("Show Previous Games"));
            add(new JButton("Quit Game"));
        }
    }
}
