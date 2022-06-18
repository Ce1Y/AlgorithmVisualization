package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component.*;

public class TestInfoFrame extends JFrame{
    
    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;

    private JPanel backgroundPanel;

    private JButton infoButton;
    private JButton startButton;
    private JButton menuButton;
    
    private SortInfoReader reader;
    private ArrayList<String> quizAnswer = new ArrayList<String>();
    private int[][] visit = new int[3][30];

    private String info = 
            "Here's the rules:" + "\n" +
            "1. There are 5 question in this section" + "\n" +
            "2. Each question has 20 points" + "\n" +
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
        infoButton = new JButton(new ImageIcon("src/imageSrc/Precautions.png"));
        infoButton.setBounds(190, 50, 600, 300);
        infoButton.setOpaque(false);
        infoButton.setContentAreaFilled(false);
        infoButton.setBorderPainted(false);
        infoButton.addActionListener(listener);

        startButton = new JButton(new ImageIcon("src/imageSrc/Start.png"));
        startButton.setBounds(337, 400, 300, 125);
        startButton.setBackground(Color.WHITE);
        startButton.addActionListener(listener);

        menuButton = new JButton(new ImageIcon("src/imageSrc/Menu.png"));
        menuButton.setBounds(885, 1, 100, 50);
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setFocusPainted(false);
        menuButton.setBorderPainted(false);
        menuButton.addActionListener(listener);

        // add new elements to frame
        add(infoButton);
        add(startButton);
        add(menuButton);

        MyListener myListener = new MyListener();
        // addMouseListener(myListener);           // press、release、click、enter、exit
        infoButton.addMouseMotionListener(myListener);     // move、drag
        addMouseMotionListener(myListener);
    }   

    private class MyListener extends MouseInputAdapter {
        public void mouseMoved(MouseEvent e) {
            System.out.println(e.getX());
            System.out.println(e.getY());
            if (e.getSource() == infoButton) {
                infoButton.setIcon(new ImageIcon("src/imageSrc/Precautions.png"));
            } else {
                infoButton.setIcon(new ImageIcon("src/imageSrc/Precautions_3.png"));
            }
            repaint();
        }
    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == infoButton) {              // info
                JOptionPane.showMessageDialog(null, info, "Announcement!", JOptionPane.DEFAULT_OPTION);
            } else if (e.getSource() == startButton) {      // start testing
                Random random = new Random();
                int start = random.nextInt(2) + 1;
                //start = 2;                                  // start
                switch(start) {
                    case 1:             // single
                        MultipleChoice typeSingle = new MultipleChoice(visit, 1, 0);
                        setVisible(false);
                        break;
                    case 2:             // yes/no
                        TrueAndFalse trueAndFalse = new TrueAndFalse(visit,1,0);
                        setVisible(false);
                        break;  
                    case 3:             // insert
                        // TODO
                        setVisible(false);
                        break;
                }
                setVisible(false);
            } else {                                        // back to menu
                new Menu();
                setVisible(false);
            }
        }
    }

}
