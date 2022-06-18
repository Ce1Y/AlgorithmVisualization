package src.classSrc;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrueOrFalse extends JFrame implements TestFrameImplement{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    private JLabel correctAns = new JLabel("Correct! Keep going!");
    private JLabel wrongAns = new JLabel("The answer is another");
    private JLabel answerLabel;

    private JPanel backgroundPanel;

    private JTextArea quizArea;

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
    private Random random = new Random();
    
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score; //into 
 
    private String answer;

    
    public TrueOrFalse(int[][] visit, int quizNumber, int score) {
        // init GUI
        super("Quiz" + quizNumber);
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
        quizArea = new JTextArea();
        quizArea.setFont(new Font("", Font.BOLD, 14));
        quizArea.setBackground(Color.BLACK);
        quizArea.setForeground(Color.WHITE);
        quizArea.setEditable(false);
        quizArea.setBounds(90, 50, 800, 300);

        // set answer image
        JTextField textField = new JTextField();
        textField.setOpaque( false );
        answerLabel = new JLabel();
        answerLabel.setBounds(90, 485, 400, 50);
        answerLabel.add( textField );

        // set button
        menuButton = new JButton(new ImageIcon("src/imageSrc/Menu.png"));
        menuButton.setBounds(780, 510, 100, 50);
        menuButton.setActionCommand("menu");
        menuButton.addActionListener(cmdHandler);

        submitButton = new JButton(new ImageIcon("src/imageSrc/Submit.png"));
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
        add(answerLabel);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        setVisit(visit);
        setQuizNumber(quizNumber);
        setScore(score);
        setTest();

    }
    // set question & answer
    public void setTest() {

        int number;

        while(true) {
            number = random.nextInt(15) + 1;
            if (visit[1][number] != 1)
                break;
        }

        // read
        readerQuiz = new SortInfoReader("src/testSrc/TF/" + number +".txt", "UTF-8");
        
        // read answer
        readerAnswer = new SortInfoReader("src/answerSrc/TF/" + number +".txt", "UTF-8");

        // set textArea
        quizArea.setText(readerQuiz.getContent());

        // add visited
        visit[1][number] = 1;
        
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
            } else if (ans == "F") {
                answer = "F";
            } 

            answerLabel.setIcon(new ImageIcon("src/imageSrc/Option" + answer + ".png"));

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
                    new Menu();
                    setVisible(false);
                } 
            } else if (cmd == "submit") {
                String[] options = {"return", "next"};
                int result = -1;

                correctAns.setFont(new Font("Times New Roman",Font.BOLD,15));
                wrongAns.setFont(new Font("Times New Roman",Font.BOLD,15));

                if(answer.equals(readerAnswer.getContent())) //correct
                {
                    setScore(getScore() + 20);
                    result = JOptionPane.showOptionDialog(null, correctAns,
                    "Correct!",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                }
                else  //wrong 
                {
                    result = JOptionPane.showOptionDialog(null, wrongAns,
                    "You're wrong, dude...",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                }
                System.out.println("score = " + score);
                if(result == 0)
                {
                    new Menu();
                    setVisible(false);
                    return;
                }
                if (quizNumber == 5) {
                    JOptionPane.showMessageDialog(null, 
                        "Congratulation!!! You get " + score + " points in this test, well done!!!");
                    new Menu();
                    setVisible(false);
                    return;
                }
                int nextQuizType = random.nextInt(3) + 1;
                //nextQuizType = 2;
                switch(nextQuizType) {
                    case 1:             // single
                        new MultipleChoice(visit, ++quizNumber, score);   
                        setVisible(false);
                        break;
                    case 2:             // yes/no
                        new TrueOrFalse(visit, ++quizNumber, score);    // TODO
                        setVisible(false);
                        break;  
                    case 3:             // insert
                        new insertTest(visit, ++quizNumber, score); 
                        setVisible(false);
                        break;
                            
                    }
                }
                
                }
            }

        }
    
