package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSort extends JFrame {

    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;
    private JButton returnButton;
    private JTextArea codeText = new JTextArea();

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
        ImageIcon panelBackground = new ImageIcon("src/imageSrc/SelectionSort.png");
        JLabel panelLabel = new JLabel(panelBackground);
        panelLabel.setBounds(0, 0, titlePanel.getWidth(), titlePanel.getHeight());
        titlePanel.setOpaque(false);
        titlePanel.add(panelLabel);

        animatePanel = new JPanel();
        animatePanel.setBounds(50, 100, 425, 425);
        // animatePanel.setBackground(Color.BLUE);
        animatePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        codePanel = new JPanel();
        codePanel.setBounds(510, 100, 425, 425);
        // codePanel.setBackground(Color.GREEN);
        codePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        codeText.append(
                "#include<bits/stdc++.h>                                            \nusing namespace std\nint main(){\n\n add new elements to panel\n         int A[] = {-3, 6, 5, -1, 0, 9, 3};\n int i, j, tmp;\n int n = sizeof(A)\sizeof(int);\n for(i = n-1; i > 0; i--)\n {\n     for(j = 0; j <= i-1; j++)\n     {\n         if( A[j] > A[j+1])\n         {\n             tmp = A [j];\n             A[j] = A[j+1];\n             A[j+1] = tmp;\n         }\n     }\n }");
        JScrollPane panelPane = new JScrollPane(codeText);
        panelPane.setBounds(510, 100, 425, 375);
        // codePanel.add(panelPane);
        // add new elements to frame
        add(returnButton);
        add(titlePanel);
        add(animatePanel);
        add(panelPane);
        // add(codePanel);

        // initialize frame
        setSize(1000, 600);
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
            Frame1 frame1 = new Frame1();
            setVisible(false);

        }

    }
}
