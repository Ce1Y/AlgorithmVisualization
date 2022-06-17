package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrueAndFalse extends JFrame implements TestFrameImplement{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    private JLabel correctAns = new JLabel("You are nice");
    private JLabel wrongAns = new JLabel("You are bad");
    

    private JPanel backgroundPanel;

    private JTextArea quizArea;
    private JTextArea textChoice;

    private boolean IsCorrectButtonClicked;
    private boolean IsWrongButtonClicked;

    private JButton menuButton;
    private JButton submitButton;

    private JButton buttonCorrect;
    private JButton buttonWrong;
    
    private ButtonGroup answerGroup;

    private ActionListener ansListener = new AnswerEventListener();
    private ActionListener cmdHandler = new ButtonEventListener();

    private SortInfoReader readerQuiz;
    private SortInfoReader readerAnswer;
    
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score = 0; //into 
 
    private String answer;

    
    public TrueAndFalse() {
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
        Random random = new Random();
        setQuizNumber(random.nextInt(15) + 1);
        readerQuiz = new SortInfoReader("src/testSrc/TF/" + quizNumber +".txt");
        readerAnswer = new SortInfoReader("src/answerSrc/TF/" + quizNumber +".txt");
        quizArea = new JTextArea(readerQuiz.getContent());
        quizArea.setBackground(Color.BLACK);
        quizArea.setForeground(Color.WHITE);
        quizArea.setEditable(false);
        quizArea.setBounds(90, 50, 800, 300);
        // set textChoice
        textChoice = new JTextArea();
        //textChoice.setBackground(Color.BLACK);
        //textChoice.setForeground(Color.WHITE);
        textChoice.setEditable(false);
        textChoice.setBounds(350, 510, 300, 150);
        textChoice.setOpaque(false);
        // set button
        menuButton = new JButton("Menu");
        menuButton.setBounds(780, 510, 100, 50);
        menuButton.setActionCommand("menu");
        menuButton.addActionListener(cmdHandler);

        submitButton = new JButton("Submit");
        submitButton.setBounds(880, 510, 100, 50);
        submitButton.setActionCommand("submit");
        submitButton.setEnabled(false);
        submitButton.addActionListener(cmdHandler);
        submitButton.setVisible(true);

        buttonCorrect = new JButton("T");
        buttonCorrect.setBounds(323, 400, 100, 50);
        buttonCorrect.setActionCommand("T");
        buttonCorrect.addActionListener(ansListener);

        buttonWrong = new JButton("F");
        buttonWrong.setBounds(556, 400, 100, 50);
        buttonWrong.setActionCommand("F");
        buttonWrong.addActionListener(ansListener);

        
        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(buttonCorrect);
        add(buttonWrong);
        add(textChoice);
        

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
            

            if (ans == "T") {
                answer = "T";
                textChoice.setText("You choose True!");
                System.out.println(textChoice.getText());
            } else if (ans == "F") {
                answer = "F";
                textChoice.setText("You choose False!");
                System.out.println(textChoice.getText());
            } 

            submitButton.setEnabled(true);
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
                String[] options = {"return", "next"};
                int result = -1;

                correctAns.setFont(new Font("Times New Roman",Font.BOLD,15));
                wrongAns.setFont(new Font("Times New Roman",Font.BOLD,15));

                if(answer.equals(readerAnswer.getContent()))
                {
                    setScore(getScore() + 20);
                    result = JOptionPane.showOptionDialog(null, correctAns,
                    "Correct",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                }
                else 
                {
                    if(score == 0)
                    {
                        setScore(0);
                    }
                    else
                    {
                        setScore(getScore() - 20);
                    }
                    result = JOptionPane.showOptionDialog(null, wrongAns,
                    "Wrong",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                }
                if(result == 0)
                {
                    new Frame1();
                    setVisible(false);
                }
                else{
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
