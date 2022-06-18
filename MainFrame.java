package src.classSrc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component.*;

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
        buttonSort.setOpaque(false);
        buttonSort.setContentAreaFilled(false);
        buttonSort.setBorderPainted(true);

        buttonGraph = new JButton(graphImage);
        buttonGraph.setBounds(505, 350, 400, 100);
        buttonGraph.setOpaque(false);
        buttonGraph.setContentAreaFilled(false);
        buttonGraph.setBorderPainted(true);

        add(buttonSort);
        add(buttonGraph);

        // sortButton listener
        ButtonHandler handler = new ButtonHandler();
        MouseListener listener = new MouseListener();

        buttonSort.addMouseMotionListener(listener); // move、drag
        buttonGraph.addMouseMotionListener(listener);
        addMouseMotionListener(listener);

        buttonSort.addActionListener(handler);
        buttonGraph.addActionListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private class MouseListener extends MouseInputAdapter {
        public void mouseMoved(MouseEvent e) {
            if (e.getSource() == buttonSort) {
                buttonSort.setIcon(new ImageIcon("src/imageSrc/Sort.png"));
            } else {
                buttonSort.setIcon(new ImageIcon("src/imageSrc/uncheckedSort.png"));
            }
            if (e.getSource() == buttonGraph) {
                buttonGraph.setIcon(new ImageIcon("src/imageSrc/Graph.png"));
            } else {
                buttonGraph.setIcon(new ImageIcon("src/imageSrc/uncheckedGraph.png"));
            }

            repaint();
        }
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
