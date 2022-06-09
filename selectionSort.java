package src.classSrc;

import javax.swing.*;
import java.awt.*;

public class SelectionSort extends JFrame{
    
    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;

    public SelectionSort() {
        super("Selection Sort");
        setLayout(null);

        // set panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);
        ImageIcon background = new ImageIcon("src/imageSrc/SelectionSort.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, titlePanel.getWidth(), titlePanel.getHeight());
        titlePanel.setOpaque(false);
        titlePanel.add(label);

        animatePanel = new JPanel();
        animatePanel.setBounds(50, 100, 425, 425);
        animatePanel.setBackground(Color.BLUE);

        codePanel = new JPanel();
        codePanel.setBounds(510, 100, 425, 425);
        codePanel.setBackground(Color.GREEN);

        // add new elements to frame
        add(titlePanel);
        add(animatePanel);
        add(codePanel);

        // initialize frame
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
}
