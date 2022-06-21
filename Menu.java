package src.classSrc;

import java.util.ArrayList;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component.*;

public class Menu extends JFrame {

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;

    private JPanel backgroundPanel;
    //private JPanel learnPanel;
    //private JPanel testPanel;
    
    private JButton learnButton;
    private JButton testButton;
    private JButton frontButton;

    private final JComboBox<String> sortSelectComboBox;

    String[] option = { "SORT", "Insertion", "Merge", "Bubble", "Quick", "Selection" };


    public Menu() {

        // GUI init
        super("Menu");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set background
        backgroundImg = new ImageIcon("src/imageSrc/Background.png");
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundPanel = (JPanel) this.getContentPane();
        backgroundPanel.setOpaque(false);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set listener
        ActionListener handler = new TestEventListener();
        ActionListener listener = new SortEventListener();

        // set color
        Color myRed = new Color(255, 163, 163);
        Color myBlue = new Color(102, 178, 255);
        Color myGreen = new Color(153, 255, 153);
        Color myPink = new Color(255, 240, 245);

        // set learn button
        learnButton = new JButton(new ImageIcon("src/imageSrc/uncheckedLearn.png"));
        learnButton.setBounds(210, 100, 434, 100);
        learnButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        learnButton.setOpaque(false);
        learnButton.setContentAreaFilled(false);
        learnButton.setFocusPainted(false);
        learnButton.setBorder(BorderFactory.createLineBorder(myRed, 2));
        // learnButton.setBorderPainted(false);
        learnButton.addActionListener(listener);

        // set test button
        testButton = new JButton(new ImageIcon("src/imageSrc/uncheckedTest.png"));
        testButton.setBounds(210,225, 550,100);
        testButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        testButton.setOpaque(false);
        testButton.setContentAreaFilled(false);
        testButton.setFocusPainted(false);
        testButton.setBorder(BorderFactory.createLineBorder(myBlue, 2));
        // testButton.setBorderPainted(false);
        testButton.addActionListener(handler);

        // set Menu Button
        frontButton = new JButton(new ImageIcon("src/imageSrc/uncheckedFront.png"));
        frontButton.setBounds(210, 350 , 550, 100);
        frontButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        frontButton.setOpaque(false);
        frontButton.setContentAreaFilled(false);
        frontButton.setFocusPainted(false);
        frontButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        // frontButton.setBorderPainted(false);
        frontButton.addActionListener(handler);

        // set btn listener
        ButtonListener buttonListener = new ButtonListener();
        learnButton.addMouseMotionListener(buttonListener); // move、drag
        testButton.addMouseMotionListener(buttonListener);
        frontButton.addMouseMotionListener(buttonListener);
        
        addMouseMotionListener(buttonListener);

        // set comboBox
        sortSelectComboBox = new JComboBox<>(option);
        sortSelectComboBox.setFont(new Font("Times New Roman", Font.BOLD, 12));
        sortSelectComboBox.setBounds(660, 100, 100, 20);
        sortSelectComboBox.setRenderer(new DefaultListCellRenderer() {
            {
                setHorizontalAlignment(DefaultListCellRenderer.CENTER);
            }
        });

        // add new elements to frame
        add(sortSelectComboBox);
        add(learnButton);
        add(testButton);
        add(frontButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private class ButtonListener extends MouseInputAdapter {
        public void mouseMoved(MouseEvent e) {
            if (e.getSource() == learnButton) {
                learnButton.setIcon(new ImageIcon("src/imageSrc/Learn.png"));
            } else {
                learnButton.setIcon(new ImageIcon("src/imageSrc/uncheckedLearn.png"));
            }
            if (e.getSource() == testButton) {
                testButton.setIcon(new ImageIcon("src/imageSrc/Test.png"));
            } else {
                testButton.setIcon(new ImageIcon("src/imageSrc/uncheckedTest.png"));
            }
            if (e.getSource() == frontButton) {
                frontButton.setIcon(new ImageIcon("src/imageSrc/Front.png"));
            } else {
                frontButton.setIcon(new ImageIcon("src/imageSrc/uncheckedFront.png"));
            }
        }
    }
    
    private class SortEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sort = sortSelectComboBox.getItemAt(sortSelectComboBox.getSelectedIndex());

            // Go to the tutorial area depending on the selection of dropDownMenu value
            switch (sort) {
                case "Insertion":
                    new InsertSortVisualizationFrame();
                    setVisible(false);
                    break;
                case "Merge":
                    new MergeSortVisualizationFrame();
                    setVisible(false);
                    break;
                case "Bubble":
                    new BubbleSortVisualizationFrame();
                    setVisible(false);
                    break;
                case "Quick":
                    new QuickSortVisualizationFrame();
                    setVisible(false);
                    break;
                case "Selection":
                    new SelectionSortVisualizationFrame();
                    setVisible(false);
                    break;
            }
        }
    }

    private class TestEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Go to test area
            if (e.getSource() == testButton) {
                TestInfoFrame testInfoFrame = new TestInfoFrame();
                setVisible(false);
            } else if (e.getSource() == frontButton) {
                new MainFrame();
                setVisible(false);
            } 

        }

    }

}