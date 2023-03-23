package gui.panels;

import event.IEventHandler;
import event.MenuEvent;
import event.MenuEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Menu
 */
public class StartPanel extends Panel {
    public StartPanel(IEventHandler handler) {
        super(handler);
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
            
            add(newButton("New Game", e->{
                dispatchGameEvent(meh -> ((MenuEventHandler) meh).startNewGame());
            }));
            add(new JButton("Show Previous Games"));
            add(new JButton("Quit Game"));
        }

        private JButton newButton(String text, ActionListener listener) {
            JButton button = new JButton(text);
            button.addActionListener(listener);
            return button;
        }     
    }
}
