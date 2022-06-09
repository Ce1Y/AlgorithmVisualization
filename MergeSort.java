package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeSort extends JFrame {

    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;
    private JButton returnButton;
    private JTextArea textArea;
    private JScrollPane panelPane;

    public MergeSort() {
        super("Merge Sort");
        setLayout(null);

        // set listener
        ActionListener listener = new MyEventListener();

        // set button
        returnButton = new JButton("return");
        returnButton.setBounds(832, 472, 100, 50);
        returnButton.addActionListener(listener);

        // set textArea
        textArea = new JTextArea("sdf");
        textArea.setSize(425, 425);

        // set panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);
        ImageIcon panelBackground = new ImageIcon("src/imageSrc/ce1y/SelectionSort.png");
        JLabel panelLabel = new JLabel(panelBackground);
        panelLabel.setBounds(0, 0, titlePanel.getWidth(), titlePanel.getHeight());
        titlePanel.setOpaque(false);
        titlePanel.add(panelLabel);

        animatePanel = new JPanel();
        animatePanel.setBounds(50, 100, 425, 425);
        animatePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        codePanel = new JPanel();
        codePanel.setBounds(510, 100, 425, 425);
        codePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        panelPane = new JScrollPane(textArea);

        // add new elements to panel
        codePanel.add(panelPane);

        // add new elements to frame
        add(returnButton);
        add(titlePanel);
        add(animatePanel);
        add(codePanel);

        // initialize frame
        setSize(1000, 600);
        ImageIcon background = new ImageIcon("src/imageSrc/ce1y/background.png");
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
            Frame1 frame1 = new Frame1();
            setVisible(false);

        }

    }
}
