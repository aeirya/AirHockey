package gui.panels;

import event.IEventHandler;

import javax.swing.*;
import java.awt.*;

public class NewGamePanel extends Panel {
    public NewGamePanel(IEventHandler eventHandler) {
        super(eventHandler);
        add(new CenterPanel());
    }

    class CenterPanel extends JPanel{
        TimePanel timePanel = new TimePanel();
        GoalPanel goalPanel = new GoalPanel();
        JButton startButton = new JButton("Start Game");
        public CenterPanel(){
            setLayout(new GridBagLayout());
            addComponents();
            goalPanel.goalCheckBox.setSelected(true);
        }

        private void addComponents(){
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.ipadx = 50;
            gbc.ipady = 50;

            gbc.gridx = 0;
            gbc.gridy = 0;
            add(timePanel , gbc);

            gbc.gridx = 1;
            add(goalPanel , gbc);

            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(startButton, gbc);
        }

        private void addListener(){
            startButton.addActionListener( e-> {
                if (timePanel.timeCheckBox.isSelected() == goalPanel.goalCheckBox.isSelected()){
                    JOptionPane.showMessageDialog(null , "Select one mode!");
                    return;
                }
                if (timePanel.timeCheckBox.isSelected()){
                    int timeLimit = (int) timePanel.timeCount.getValue();
                    //TODO
                }
                else{
                    int goalLimit = (int) goalPanel.goalCount.getValue();
                    boolean isMargin = goalPanel.goalCheckBox.isSelected();
                    //TODO
                }
            });
        }
    }

    class TimePanel extends JPanel{
        JCheckBox timeCheckBox = new JCheckBox("Time Limited");
        JSpinner timeCount = new JSpinner(new SpinnerNumberModel(60 , 10 , 600 , 10));

        public TimePanel(){
            setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

            add(timeCheckBox);
            add(timeCount);
        }
    }

    class GoalPanel extends JPanel{
        JCheckBox goalCheckBox = new JCheckBox("Goal Limited");
        JSpinner goalCount = new JSpinner(new SpinnerNumberModel(1 , 1 , 20 , 1));
        JCheckBox margin = new JCheckBox("2Margin");

        public GoalPanel(){
            setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

            add(goalCheckBox);
            add(margin);
            add(goalCount);
        }
    }
}
