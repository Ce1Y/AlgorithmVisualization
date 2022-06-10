package src.classSrc;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSort extends JFrame {

    SortInfoReader reader = new SortInfoReader("D:/Desktop/Java/final/BubbleSort.txt");
    private String str = reader.getContent();
    private int fontSize = 15;

    private ImageIcon backgroundImage;
    private ImageIcon titleImage;
    private ImageIcon menuImage;

    private JLabel backgroundLabel;
    private JLabel titleLabel;

    private JPanel backgroundPanel;
    private JPanel titlePanel;
    private JPanel animatePanel;
    private JPanel codePanel;

    private JTextArea text;

    private JScrollPane textPanelPane;

    private JButton returnButton;
    private JButton plusFontSizeButton;
    private JButton minusFontSizeButton;

    public BubbleSort() {

        // GUI init
        super("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set background
        backgroundImage = new ImageIcon("D:/Desktop/Java/final/src/imageSrc/Background.png");

        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        backgroundPanel = (JPanel) getContentPane();
        backgroundPanel.setOpaque(false);

        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set button listener
        ActionListener listener = new ButtonEventListener();

        // set title panel
        titlePanel = new JPanel();
        titlePanel.setBounds(50, 25, 885, 50);

        titleImage = new ImageIcon("D:/Desktop/Java/final/src/imageSrc/BubbleSort.png");
        titleLabel = new JLabel(titleImage);
        titleLabel.setBounds(0, 0, titlePanel.getWidth(), titlePanel.getHeight());

        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel);

        // set animate panel
        animatePanel = new JPanel();
        animatePanel.setBounds(50, 100, 425, 425);

        animatePanel.setBorder(BorderFactory.createLineBorder(Color.black));

        // set code text area
        text = new JTextArea(str);
        text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
        text.setEditable(false);

        textPanelPane = new JScrollPane(text);
        textPanelPane.setBounds(510, 100, 425, 425);

        // set plus fontSize button
        plusFontSizeButton = new JButton("+");
        plusFontSizeButton.setBounds(830, 525, 50, 30);
        plusFontSizeButton.addActionListener(listener);

        // set plus fontSize button
        minusFontSizeButton = new JButton("-");
        minusFontSizeButton.setBounds(883, 525, 50, 30);
        minusFontSizeButton.addActionListener(listener);

        // set menu button to return frame1
        menuImage = new ImageIcon("D:/Desktop/Java/final/src/imageSrc/Menu.png");
        returnButton = new JButton(menuImage);
        returnButton.setBounds(832, 40, 80, 35);
        returnButton.addActionListener(listener);

        // add panel to frame
        add(titlePanel);
        add(animatePanel);
        add(textPanelPane);
        add(returnButton);
        add(plusFontSizeButton);
        add(minusFontSizeButton);
    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == returnButton) {
                Frame1 frame1 = new Frame1();
                setVisible(false);
            } else if (e.getSource() == plusFontSizeButton) {
                fontSize += 2;
                if (fontSize <= 50) {
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                } else {
                    fontSize = 50;
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                    JOptionPane.showMessageDialog(BubbleSort.this, "Text cannot be larger!");
                }
            } else if (e.getSource() == minusFontSizeButton) {
                fontSize -= 2;
                if (fontSize >= 6) {
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                } else {
                    fontSize = 6;
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                    JOptionPane.showMessageDialog(BubbleSort.this, "Text cannot be smaller!");
                }
            }
        }
    }
}
