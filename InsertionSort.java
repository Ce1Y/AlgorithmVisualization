package src.classSrc;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertionSort extends JFrame {

    SortInfoReader reader = new SortInfoReader("InsertionSort.txt");
    private String str = reader.getContent();
    private int fontSize = 15;

    private ImageIcon backgroundImage;
    private ImageIcon titleImage;
    private ImageIcon menuImage;
    private ImageIcon plusFontSizeImage;
    private ImageIcon minusFontSizeImage;

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

    public InsertionSort() {

        // GUI init
        super("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set background
        backgroundImage = new ImageIcon("src/imageSrc/Background.png");

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

        titleImage = new ImageIcon("src/imageSrc/InsertionSort.png");
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
        plusFontSizeImage = new ImageIcon("src/imageSrc/Plus.png");
        plusFontSizeButton = new JButton(plusFontSizeImage);
        plusFontSizeButton.setBounds(940, 470, 25, 25);
        plusFontSizeButton.addActionListener(listener);

        // set minus fontSize button
        minusFontSizeImage = new ImageIcon("src/imageSrc/Minus.png");
        minusFontSizeButton = new JButton(minusFontSizeImage);
        minusFontSizeButton.setBounds(940, 500, 25, 25);
        minusFontSizeButton.addActionListener(listener);

        // set menu button to return frame1
        menuImage = new ImageIcon("src/imageSrc/Menu.png");
        returnButton = new JButton(menuImage);
        returnButton.setBounds(832, 40, 78, 33);
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
                    JOptionPane.showMessageDialog(InsertionSort.this, "Text cannot be larger!");
                }
            } else if (e.getSource() == minusFontSizeButton) {
                fontSize -= 2;
                if (fontSize >= 6) {
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                } else {
                    fontSize = 6;
                    text.setFont(new Font("Consolas", Font.PLAIN, fontSize));
                    JOptionPane.showMessageDialog(InsertionSort.this, "Text cannot be smaller!");
                }
            }
        }
    }
}
