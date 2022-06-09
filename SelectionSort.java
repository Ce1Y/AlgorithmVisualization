package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectionSort extends JFrame{
    
    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;
    private JTextArea text;
    private JScrollPane panelPane;
    private JButton returnButton;
    private JButton plusFontSizeButton;
    private JButton minusFontSizeButton;
    private int fontSize = 15;

    private String str = 
        "public class SelectionSortExample {" + "\n" +
        "   public static void selectionSort(int[] arr) {" + "\n" +
        "       for (int i = 0; i < arr.length - 1; i++) {" + "\n" +
        "           int index = i;" + "\n" +
        "           for (int j = i + 1; j < arr.length; j++) {" + "\n" +
        "               if (arr[j] < arr[index]) {" + "\n" +
        "                   index = j;//searching for lowest index" + "\n" +
        "               }" + "\n" +
        "           }" + "\n" +
        "       int smallerNumber = arr[index];" + "\n" +
        "       arr[index] = arr[i];" + "\n" + 
        "       arr[i] = smallerNumber;" + "\n" +
        "   }" + "\n" +
        "}";

        public SelectionSort() {
            super("Selection Sort");
            setLayout(null);
            text = new JTextArea(str);
    
            text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
            text.setEditable(false);
    
            // set listener
            ActionListener listener = new MyEventListener();
    
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
            
            JScrollPane panelPane = new JScrollPane(text);
            panelPane.setBounds(510, 100, 425, 425);
    
            // add new elements to panel
    
    
            // set button
            plusFontSizeButton = new JButton("+");
            plusFontSizeButton.setBounds(830, 525, 50, 30);
            plusFontSizeButton.addActionListener(listener);
            
            minusFontSizeButton = new JButton("-");
            minusFontSizeButton.setBounds(883, 525, 50, 30);
            minusFontSizeButton.addActionListener(listener);
            
            ImageIcon returnImg = new ImageIcon("src/imageSrc/Menu.png");
            returnButton = new JButton(returnImg);
            returnButton.setBounds(832, 40, 80, 35);
            returnButton.addActionListener(listener);
    
            // add new elements to frame
            add(returnButton);
            add(plusFontSizeButton);
            add(minusFontSizeButton);
            add(titlePanel);
            add(animatePanel);
            add(panelPane);
    
            // initialize frame
            setSize(1000, 600);
            ImageIcon background = new ImageIcon("src/imageSrc/Background.png");
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
            if (e.getSource() == returnButton) {
                Frame1 frame1 = new Frame1();
                setVisible(false);
            } else if (e.getSource() == plusFontSizeButton) {
                fontSize += 2;
                if (fontSize <= 60) {
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                } else {
                    fontSize = 60;
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                    JOptionPane.showMessageDialog(null, "No, it cannot be larger!");
                }
            } else if (e.getSource() == minusFontSizeButton) {
                fontSize -= 2;
                if (fontSize >= 6) {
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                } else {
                    fontSize = 6;
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                    JOptionPane.showMessageDialog(null, "No, it cannot be smaller!");
                }
            }
        }

    }
}
