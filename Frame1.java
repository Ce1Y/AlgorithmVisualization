package src.classSrc;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
        super("Frame 1");
        setSize(1000, 600);
        setLayout(null);

        // set background
        backgroundImg = new ImageIcon("src/imageSrc/background.png");
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        backgroundPanel = (JPanel) this.getContentPane();
        backgroundPanel.setOpaque(false);
        this.getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set listener
        ActionListener listener = new MyEventListener();
        // ItemListener itemListener = new ItemListener();

        // set panel
        sortSelectPanel = new JPanel();
        sortSelectPanel.setBackground(Color.black);

        learnPanel = new JPanel();
        learnPanel.setBackground(Color.yellow);

        testPanel = new JPanel();
        testPanel.setBackground(Color.green);

        // set button
        learnButton = new JButton("Learn");
        learnButton.setBounds(100, 175, 250, 250);
        learnButton.setForeground(Color.white);
        learnButton.setBackground(Color.red);
        learnButton.setFont(new Font("Helvetica", Font.PLAIN, 24));
        learnButton.addActionListener(listener);

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

        // add new elements to panel

        // add new elements to frame
        add(sortSelectComboBox);
        add(learnButton);
        add(testButton);

        // initialize frame
        setSize(1000, 600);
        // set frame1 background
        ImageIcon background = new ImageIcon("src/imageSrc/background.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, getWidth(), getHeight());
        JPanel imagePanel = (JPanel) getContentPane();
        imagePanel.setOpaque(false);
        getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private class MyEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sort = sortSelectComboBox.getItemAt(sortSelectComboBox.getSelectedIndex());

            // Go to the tutorial area depending on the selection of dropDownMenu value
            switch (sort) {
                case "Insert":
                    // TODO
                    break;
                case "Merge":
                    MergeSort q = new MergeSort();
                    setVisible(false);
                    break;
                case "Bubble":
                    // TODO
                    break;
                case "Quick":
                    QuickSort q = new QuickSort();
                    setVisible(false);
                    break;
                case "Selection":
                    break;
            }
        }

    }

}