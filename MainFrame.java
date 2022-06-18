package src.classSrc;

import javax.swing.*;
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

    public MainFrame() {
        // GUI init
        setTitle("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(null);

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
        titlePanel.setBounds(100, 30, 800, 200);
        add(titlePanel);

        // English title image
        engTitleImage = new ImageIcon("src/imageSrc/TitleENG.png");
        engTitleLabel = new JLabel(engTitleImage);
        engTitlePanel = new JPanel();
        engTitlePanel.setOpaque(false);
        engTitlePanel.add(engTitleLabel);
        engTitlePanel.setBounds(300, 160, 400, 100);
        add(engTitlePanel);

        // sort and graph button
        sortImage = new ImageIcon("src/imageSrc/Sort.png");
        graphImage = new ImageIcon("src/imageSrc/Graph.png");

        buttonSort = new JButton(sortImage);
        buttonSort.setBounds(95, 350, 400, 100);
        buttonGraph = new JButton(graphImage);
        buttonGraph.setBounds(505, 350, 400, 100);

        add(buttonSort);
        add(buttonGraph);

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
                new Menu();
                setVisible(false);

            } else if (evt.getSource() == buttonGraph) {
                new BSTVisualization();
                setVisible(false);
            }
        }
    }

}
