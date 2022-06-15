package src.classSrc;

import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame {

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;

    private JPanel backgroundPanel;
    private JPanel sortSelectPanel;
    private JPanel learnPanel;
    private JPanel testPanel;

    private JButton learnButton;
    private JButton testButton;

    private final JComboBox<String> sortSelectComboBox;

    String[] option = { "SORT", "Insert", "Merge", "Bubble", "Quick", "Selection" };
    ArrayList<String> imgSrc = new ArrayList<>();

    public Frame1() {

        // GUI init
        super("Frame 1");
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
        ActionListener listener = new MyEventListener();

        // set button panel
        sortSelectPanel = new JPanel();
        sortSelectPanel.setBackground(Color.black);

        learnPanel = new JPanel();
        learnPanel.setBackground(Color.yellow);

        testPanel = new JPanel();
        testPanel.setBackground(Color.green);

        // set learn button
        learnButton = new JButton("Learn");
        learnButton.setBounds(100, 175, 250, 250);
        learnButton.setForeground(Color.white);
        learnButton.setBackground(Color.red);
        learnButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        learnButton.addActionListener(listener);

        // set test button
        testButton = new JButton("Test");
        testButton.setBounds(640, 175, 250, 250);
        testButton.setForeground(Color.white);
        testButton.setBackground(Color.green);
        testButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        testButton.addActionListener(listener);

        // set comboBox
        sortSelectComboBox = new JComboBox<>(option);
        sortSelectComboBox.setBounds(400, 40, 200, 50);
        sortSelectComboBox.setRenderer(new DefaultListCellRenderer() {
            {
                setHorizontalAlignment(DefaultListCellRenderer.CENTER);
            }
        });

        // add new elements to frame
        add(sortSelectComboBox);
        add(learnButton);
        add(testButton);

    }

    private class MyEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sort = sortSelectComboBox.getItemAt(sortSelectComboBox.getSelectedIndex());

            // Go to the tutorial area depending on the selection of dropDownMenu value
            switch (sort) {
                case "Insert":
                    new InsertSortVisualizationFrame();
                    setVisible(false);
                    break;
                case "Merge":
                    new MergeSort();
                    setVisible(false);
                    break;
                case "Bubble":
                    new BubbleSort();
                    setVisible(false);
                    break;
                case "Quick":
                    new QuickSort();
                    setVisible(false);
                    break;
                case "Selection":
                    new SelectionSortVisualizationFrame();
                    setVisible(false);
                    break;
            }
        }

    }

}