package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TypeSingle extends JFrame implements TestFrameImplement{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    
    private JPanel backgroundPanel;

    private JTextArea quizArea;
    
    private JButton menuButton;
    private JButton submitButton;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;

    private ButtonGroup answerGroup;

    private ActionListener ansListener = new AnswerEventListener();
    private ActionListener cmdHandler = new ButtonEventListener();

    private SortInfoReader reader;
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score;
    private int click = 0;
    private String answer;

    
    public TypeSingle() {
        // init GUI
        super("Quiz");
        setSize(1000, 600);
        setLayout(null);

        // set background
        backgroundImg = new ImageIcon("src/imageSrc/Background.png");
        backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundPanel = (JPanel) this.getContentPane();
        backgroundPanel.setOpaque(false);
        getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));

        // set textArea
        quizArea = new JTextArea("src/textSrc/InsertionSort.txt");
        quizArea.setBackground(Color.BLACK);
        quizArea.setForeground(Color.WHITE);
        quizArea.setEditable(false);
        quizArea.setBounds(90, 50, 800, 300);

        // set button
        menuButton = new JButton("Menu");
        menuButton.setBounds(780, 510, 100, 50);
        menuButton.setActionCommand("menu");
        menuButton.addActionListener(cmdHandler);

        submitButton = new JButton("Submit");
        submitButton.setBounds(880, 510, 100, 50);
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(cmdHandler);
        submitButton.setVisible(false);

        buttonA = new JButton("A");
        buttonA.setBounds(90, 400, 100, 50);
        buttonA.setActionCommand("A");
        buttonA.addActionListener(ansListener);

        buttonB = new JButton("B");
        buttonB.setBounds(323, 400, 100, 50);
        buttonB.setActionCommand("B");
        buttonB.addActionListener(ansListener);
        
        buttonC = new JButton("C");
        buttonC.setBounds(556, 400, 100, 50);
        buttonC.setActionCommand("C");
        buttonC.addActionListener(ansListener);
        
        buttonD = new JButton("D");
        buttonD.setBounds(790, 400, 100, 50);
        buttonD.setActionCommand("D");
        buttonD.addActionListener(ansListener);

        // set buttonGroup
        answerGroup = new ButtonGroup();
        answerGroup.add(buttonA);
        answerGroup.add(buttonB);
        answerGroup.add(buttonC);
        answerGroup.add(buttonD);
        
        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(buttonA);
        add(buttonB);
        add(buttonC);
        add(buttonD);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


    }
    // set question & answer
    public void setTest() {

        // set question

        // read answer
        
    }

    private void setVisit(int[][] newVisit) {
        visit = newVisit;
    }

    public void setQuizNumber(int newNumber) {
        this.quizNumber = newNumber;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }

    public int getScore() {
        return score;
    }

    private class AnswerEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String ans = event.getActionCommand();
            click = click + 1;

            if (ans == "A") {
                answer = "A";
            } else if (ans == "B") {
                answer = "B";
            } else if (ans == "C") {
                answer = "C";
            } else if (ans == "D") {
                answer = "D";
            }

            if (click % 2 == 1) {
                submitButton.setVisible(true);
            } else {
                submitButton.setVisible(false);
                ans = "";
            }
        }
    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd == "menu") {
                int result = JOptionPane.showConfirmDialog(null,"You want to back to Menu?", "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imageSrc/Thinking4.png"));
                
                if (result == JOptionPane.YES_OPTION) {     // yes
                    new Frame1();
                    setVisible(false);
                } 
            } else if (cmd == "submit") {
                if (answer != "123") {      // wrong 

                } else {                    // correct
                    Random random = new Random();
                    int nextQuizType = random.nextInt(3) + 1;
                    switch(nextQuizType) {
                        case 1:             // single
                            
                            setVisible(false);
                            break;
                        case 2:             // yes/no
                            // TODO
                            setVisible(false);
                            break;  
                        case 3:             // insert
                            // TODO
                            setVisible(false);
                            break;
                    }
                }
            }

        }
    }
}
