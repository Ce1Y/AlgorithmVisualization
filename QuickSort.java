package src.classSrc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuickSort extends JFrame {

    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;
    private JButton returnButton;

    private String str = "public class SelectionSortExample {" + "\n" +
            "public static void selectionSort(int[] arr){" + "\n" +
            "for (int i = 0; i < arr.length - 1; i++)" + "\n" +
            "{" + "\n" +
            "int index = i;" + "\n" +
            "for (int j = i + 1; j < arr.length; j++){" + "\n" +
            "if (arr[j] < arr[index]){" + "\n" +
            "index = j; " + "\n" +
            "}" + "\n" +
            "}" + "\n" +
            "int smallerNumber = arr[index]; " + "\n" +
            "arr[index] = arr[i]; " + "\n" +
            "arr[i] = smallerNumber; " + "\n" +
            "}" + "\n" +
            "}";

    public QuickSort() {
        super("Quick Sort");
        setLayout(null);
        JTextArea text = new JTextArea(str);
        text.setFont(new Font("Consolas", Font.PLAIN, 50));
        // text.setSize(100, 100);

        // set listener
        ActionListener listener = new MyEventListener();

        // set panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);
        ImageIcon panelBackground = new ImageIcon("src/imageSrc/leo4545525/QuickSort.png");
        JLabel panelLabel = new JLabel(panelBackground);
        panelLabel.setBounds(0, 0, titlePanel.getWidth(), titlePanel.getHeight());
        titlePanel.setOpaque(false);
        titlePanel.add(panelLabel);

        animatePanel = new JPanel();
        animatePanel.setBounds(50, 100, 425, 425);
        // animatePanel.setBackground(Color.BLUE);
        animatePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        /*
         * codePanel = new JPanel();
         * codePanel.setBounds(510, 100, 425, 425);
         * // codePanel.setBackground(Color.GREEN);
         * codePanel.setBorder(BorderFactory.createLineBorder(Color.black));
         */

        // add new elements to panel

        JScrollPane panelPane = new JScrollPane(text);
        panelPane.setBounds(510, 100, 425, 425);

        // set button
        ImageIcon returnImg = new ImageIcon("src/imageSrc/leo4545525/Menu.png");
        //JLabel returnLabel = new JLabel(returnImg);
        returnButton = new JButton(returnImg);
        returnButton.setBounds(832, 40, 100, 50);
        returnButton.addActionListener(listener);

        // add new elements to frame
        add(returnButton);
        add(titlePanel);
        add(animatePanel);
        // add(codePanel);
        add(panelPane);

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
