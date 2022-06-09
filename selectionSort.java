package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSort extends JFrame{
    
    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;
    private JButton returnButton;

    public SelectionSort() {
        super("Selection Sort");
        setLayout(null);

        // set listener
        ActionListener listener = new MyEventListener();

        // set button
        returnButton = new JButton("return");
        returnButton.setBounds(832, 472, 100, 50);
        returnButton.addActionListener(listener);

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
        // animatePanel.setBackground(Color.BLUE);
        animatePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        codePanel = new JPanel();
        codePanel.setBounds(510, 100, 425, 425);
        // codePanel.setBackground(Color.GREEN);
        codePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // add new elements to frame
        add(returnButton);
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

    private class MyEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Frame1 frame1 = new Frame1();
            setVisible(false);
        
        }

    }
}
