package ntou.cs.java2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    // private ImageIcon backgroundImage;
    private ImageIcon titleImage;
    private ImageIcon engTitleImage;
    private ImageIcon sortImage;
    private ImageIcon graphImage;

    private JButton buttonSort;
    private JButton buttonGraph;

    // private JLabel backgroundLabel;
    private JLabel titleLabel;
    private JLabel engTitleLabel;

    // private JPanel backgroundPanel;
    private JPanel titlePanel;
    private JPanel engTitlePanel;
    private JPanel optionPanel;

    public MainFrame() {
        // GUI init
        setTitle("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(new GridLayout(3, 1));

        // Chinese title image
        titleImage = new ImageIcon("src/ImageSrc/Title.png");
        titleLabel = new JLabel(titleImage);
        titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        add(titlePanel);

        // English title image
        engTitleImage = new ImageIcon("src/ImageSrc/TitleENG.png");
        engTitleLabel = new JLabel(engTitleImage);
        engTitlePanel = new JPanel();
        engTitlePanel.add(engTitleLabel);
        add(engTitlePanel);

        // sort and graph button
        sortImage = new ImageIcon("src/ImageSrc/Sort.png");
        graphImage = new ImageIcon("src/ImageSrc/Graph.png");

        buttonSort = new JButton(sortImage);
        buttonGraph = new JButton(graphImage);

        optionPanel = new JPanel();
        optionPanel.add(buttonSort);
        optionPanel.add(buttonGraph);
        add(optionPanel);

        // sortButton listener
        ButtonHandler handler = new ButtonHandler();

        buttonSort.addActionListener(handler);
        buttonGraph.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == buttonSort) {
                JOptionPane.showMessageDialog(MainFrame.this, "JUMP TO FRAME1");
            } else if (evt.getSource() == buttonGraph) {
                JOptionPane.showMessageDialog(MainFrame.this, "SORRY, IT'S NOT ROLL OUT YET");
            }
        }
    }

}
