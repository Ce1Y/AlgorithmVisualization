package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame{

    private JPanel sortSelectPanel;
    private JPanel learnPanel;
    private JPanel testPanel;
    private JButton learnButton;
    private JButton testButton;
    private final JComboBox<String> sortSelectComboBox;
    
    String[] option = {"SORT", "Insert", "Merge", "Bubble", "Quick", "Select"};

    public Frame1() {
        super("Frame 1");
        // setLayout(null);

        ActionListener listener = new MyEventListener();

        // set panel
        sortSelectPanel = new JPanel();
        sortSelectPanel.setBackground(Color.black);
        // sortSelectComboBox.setPreferredSize(preferredSize);

        learnPanel = new JPanel();
        learnPanel.setBackground(Color.yellow);
        learnPanel.setPreferredSize(new Dimension(200, 0));
        
        testPanel = new JPanel();
        testPanel.setBackground(Color.green);
        testPanel.setPreferredSize(new Dimension(200, 0));

        // set button
        learnButton = new JButton("Learn");
        learnButton.addActionListener(listener);

        testButton = new JButton("Test");
        testButton.addActionListener(listener);

        // set comboBox
        sortSelectComboBox = new JComboBox<>(option);   

        // add new element to panel
        sortSelectPanel.add(sortSelectComboBox);

        learnPanel.add(learnButton);

        testPanel.add(testButton);

        // add new element to frame
        add(sortSelectPanel, BorderLayout.NORTH);
        add(learnPanel, BorderLayout.WEST);
        add(testPanel, BorderLayout.EAST);

    }

    private class MyEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sort = sortSelectComboBox.getItemAt(sortSelectComboBox.getSelectedIndex());

            // go to the tutorial area depending on the selection of dropDownMenu value
            switch(sort) {
                case "Insert":
                    //TODO
                    break;
                case "Merge":
                    //TODO
                    break;
                case "Bubble":
                    //TODO
                    break;
                case "Quick":
                    //TODO
                    break;
                case "Select":
                    //TODO
                    break;
            }
        }

    }

}