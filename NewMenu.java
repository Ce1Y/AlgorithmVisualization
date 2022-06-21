package src.classSrc;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewMenu extends JFrame {

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;

    private JPanel backgroundPanel;
    //private JPanel learnPanel;
    //private JPanel testPanel;
    
    private JButton learnButton;
    private JButton testButton;
    private JButton firstPageButton;

    private final JComboBox<String> sortSelectComboBox;

    String[] option = { "SORT", "Insertion", "Merge", "Bubble", "Quick", "Selection" };


    public NewMenu() {

        // GUI init
        super("NewMenu");
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
        // set button panel
       
        // set learn button
        learnButton = new JButton("Learn");
        learnButton.setBounds(210, 100, 440, 100);
        //learnButton.setForeground(Color.white);
        //learnButton.setBackground(Color.red);
        learnButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        learnButton.addActionListener(listener);

        // set test button
        testButton = new JButton("Test");
        testButton.setBounds(210,225, 550,100);
        //testButton.setForeground(Color.white);
        //testButton.setBackground(Color.green);
        testButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        testButton.addActionListener(handler);

        // set NewMenu Button
        firstPageButton = new JButton("Menu");
        firstPageButton.setBounds(210, 350 , 550, 100);
        firstPageButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        firstPageButton.addActionListener(handler);

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
        add(firstPageButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
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
            } else if (e.getSource() == firstPageButton) {
                new MainFrame();
                setVisible(false);
            } 

        }

    }

}