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

    private String str = "public class MergeSortExample {" + "\n" +
            "public static void mergeSort(int[] a, int n) {" + "\n" +
            "   if (n < 2) {" + "\n" +
            "       return;" + "\n" +
            "   }" + "\n" +
            "   int mid = n / 2;" + "\n" +
            "   int[] l = new int[mid];" + "\n" +
            "   int[] r = new int[n - mid];" + "\n" +
            "   for (int i = 0; i < mid; i++) " + "\n" +
            "       l[i] = a[i];" + "\n" +
            "   for (int i = mid; i < n; i++)" + "\n" +
            "       r[i - mid] = a[i];" + "\n" +
            "   mergeSort(l, mid);" + "\n" +
            "   mergeSort(r, n - mid);" + "\n" +
            "   merge(a, l, r, mid, n - mid);" + "\n" +
            "}" + "\n" +
            "public static void merge(int[] a, int[] l, int[] r, int left, int right){" + "\n" +
            "   int i = 0, j = 0, k = 0;" + "\n" +
            "   while (i < left && j < right) {" + "\n" +
            "       if (l[i] <= r[j])" + "\n" +
            "           a[k++] = l[i++];" + "\n" +
            "       else" + "\n" +
            "           a[k++] = r[j++];" + "\n" +
            "   }" + "\n" +
            "   while (i < left)" + "\n" +
            "       a[k++] = l[i++];" + "\n" +
            "   while (j < right)" + "\n" +
            "       a[k++] = l[i++];" + "\n" +
            "   }" + "\n" +
            "}" + "\n";

    public MergeSort() {
        super("Merge Sort");
        setLayout(null);
        JTextArea text = new JTextArea(str);
        text.setFont(new Font("Consolas", Font.PLAIN, 50));
        // text.setSize(100, 100);

        // set listener
        ActionListener listener = new MyEventListener();

        // set panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);
        ImageIcon panelBackground = new ImageIcon("src/imageSrc/wayne/MergeSort.png");
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
        // JLabel returnLabel = new JLabel(returnImg);
        returnButton = new JButton(returnImg);
        returnButton.setBounds(832, 40, 80, 35);
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
