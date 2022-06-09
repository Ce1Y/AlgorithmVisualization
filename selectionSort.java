package src.classSrc;

import javax.swing.*;
import java.awt.*;

public class selectionSort extends JFrame{
    
    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;

    public selectionSort() {
        super("Selection Sort");
        setLayout(new BorderLayout());

        // set panel
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);

        animatePanel = new JPanel();
        animatePanel.setBackground(Color.BLUE);

        codePanel = new JPanel();
        codePanel.setBackground(Color.GREEN);

        // add new elements to frame
        add(titlePanel, BorderLayout.NORTH);
        add(animatePanel, BorderLayout.WEST);
        add(codePanel, BorderLayout.EAST);

        // initialize frame
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
}
