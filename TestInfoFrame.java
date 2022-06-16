package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestInfoFrame extends JFrame{
    
    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;

    private JPanel backgroundPanel;

    private JButton infoButton;
    private JButton startButton;
    private JButton menuButton;
    
    private SortInfoReader reader;
    private ArrayList<String> quizAnswer = new ArrayList<String>();
    
    private String info = 
            "Here's the rules:" + "\n" +
            "1. There are 10 question in this section" + "\n" +
            "2. Each question has 10 points" + "\n" +
            "3. There are 3 type of question in this section: Multiple Choice, Mutiple Choice with multiple answers" + "\n" +
            "   and combination" + "\n" +
            "4. There's no time limit. Focus on your question and try your best!";
            
    public TestInfoFrame() {
        // GUI init
        setTitle("ALGORITHM VISUALIZATION");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // set background
        backgroundImg = new ImageIcon("src/imageSrc/Background.png");
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundPanel = (JPanel) this.getContentPane();
        backgroundPanel.setOpaque(false);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set listener
        ActionListener listener = new ButtonEventListener();

        // set button
        infoButton = new JButton();
        infoButton.setBounds(190, 50, 600, 300);
        infoButton.addActionListener(listener);

        startButton = new JButton();
        startButton.setBounds(337, 400, 300, 125);
        startButton.addActionListener(listener);

        menuButton = new JButton();
        menuButton.setBounds(901, 0, 85, 50);
        menuButton.addActionListener(listener);

        // add new elements to frame
        add(infoButton);
        add(startButton);
        add(menuButton);

    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == infoButton) {              // info
                JOptionPane.showMessageDialog(null, info, "Announcement!", JOptionPane.DEFAULT_OPTION);
            } else if (e.getSource() == startButton) {      // start testing
                TestFrame testFrame = new TestFrame();
                setVisible(false);
            } else {                                        // back to menu
                Frame1 frame1 = new Frame1();
                setVisible(false);
            }
        }
    }

}
