package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private ImageIcon backgroundImage;
    private ImageIcon titleImage;
    private ImageIcon engTitleImage;
    private ImageIcon sortImage;
    private ImageIcon graphImage;

    private JButton buttonSort;
    private JButton buttonGraph;

    private JLabel backgroundLabel;
    private JLabel titleLabel;
    private JLabel engTitleLabel;

    private JPanel backgroundPanel;
    private JPanel titlePanel;
    private JPanel engTitlePanel;
    private JPanel optionPanel;

    public MainFrame() {
        // GUI init
        setTitle("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(new GridLayout(3, 1));

        // set background
        backgroundImage = new ImageIcon("src/imageSrc/Background.png");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundPanel = (JPanel) getContentPane();
        backgroundPanel.setOpaque(false);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // Chinese title image
        titleImage = new ImageIcon("src/imageSrc/Title.png");
        titleLabel = new JLabel(titleImage);
        titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);
        add(titlePanel);

        // English title image
        engTitleImage = new ImageIcon("src/imageSrc/TitleENG.png");
        engTitleLabel = new JLabel(engTitleImage);
        engTitlePanel = new JPanel();
        engTitlePanel.setOpaque(false);
        engTitlePanel.add(engTitleLabel);
        add(engTitlePanel);

        // sort and graph button
        sortImage = new ImageIcon("src/imageSrc/Sort.png");
        graphImage = new ImageIcon("src/imageSrc/Graph.png");

        buttonSort = new JButton(sortImage);
        buttonGraph = new JButton(graphImage);

        optionPanel = new JPanel();
        optionPanel.setOpaque(false);
        optionPanel.add(buttonSort);
        optionPanel.add(buttonGraph);
        add(optionPanel);

        // sortButton listener
        ButtonHandler handler = new ButtonHandler();

        buttonSort.addActionListener(handler);
        buttonGraph.addActionListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == buttonSort) {
                Frame1 frame1 = new Frame1();
                setVisible(false);

            } else if (evt.getSource() == buttonGraph) {
                JOptionPane.showMessageDialog(MainFrame.this, "SORRY, IT'S NOT ROLL OUT YET");
            }
        }
    }

}
