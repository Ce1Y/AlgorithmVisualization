package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleChoice extends JFrame implements TestFrameImplement{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    private JLabel answerLabel;
    
    private JPanel backgroundPanel;

    private JTextArea quizArea;

    private JTextField answerMessage;
    
    private JButton menuButton;
    private JButton submitButton;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;

    private ActionListener ansListener = new AnswerEventListener();
    private ActionListener cmdHandler = new ButtonEventListener();

    private SortInfoReader quizReader;
    private SortInfoReader ansReader;
    private Random random = new Random();
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score;
    private String quiz;
    private String answer;
    private String correctAns;

    public MultipleChoice(int[][] visit, int quizNumber, int score) {
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

        // set answer image
        JTextField textField = new JTextField();
        textField.setOpaque( false );
        answerLabel = new JLabel();
        answerLabel.setBounds(90, 485, 400, 50);
        answerLabel.add( textField );

        // set textArea
        quizArea = new JTextArea();
        quizArea.setFont(new Font("", Font.BOLD, 14));
        quizArea.setBackground(Color.BLACK);
        quizArea.setForeground(Color.WHITE);
        quizArea.setEditable(false);
        quizArea.setBounds(90, 50, 800, 300);

        // set button
        menuButton = new JButton(new ImageIcon("src/imageSrc/Menu.png"));
        menuButton.setBounds(780, 510, 100, 50);
        menuButton.setActionCommand("menu");
        menuButton.addActionListener(cmdHandler);

        submitButton = new JButton(new ImageIcon("src/imageSrc/Submit.png"));
        submitButton.setBounds(880, 510, 100, 50);
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(cmdHandler);
        submitButton.setEnabled(false);

        buttonA = new JButton(new ImageIcon("src/imageSrc/A.png"));
        buttonA.setBounds(90, 400, 100, 50);
        buttonA.setActionCommand("A");
        buttonA.addActionListener(ansListener);

        buttonB = new JButton(new ImageIcon("src/imageSrc/B.png"));
        buttonB.setBounds(323, 400, 100, 50);
        buttonB.setActionCommand("B");
        buttonB.addActionListener(ansListener);
        
        buttonC = new JButton(new ImageIcon("src/imageSrc/C.png"));
        buttonC.setBounds(556, 400, 100, 50);
        buttonC.setActionCommand("C");
        buttonC.addActionListener(ansListener);
        
        buttonD = new JButton(new ImageIcon("src/imageSrc/D.png"));
        buttonD.setBounds(790, 400, 100, 50);
        buttonD.setActionCommand("D");
        buttonD.addActionListener(ansListener);
        
        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(buttonA);
        add(buttonB);
        add(buttonC);
        add(buttonD);
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
            number = random.nextInt(21) + 1;
            if (visit[0][number] != 1)
                break;
        }
        
        // read
        quizReader = new SortInfoReader("src/testSrc/Single/" + number + ".txt", "UTF-8");
        quiz = quizReader.getContent();

        // read answer
        ansReader = new SortInfoReader("src/answerSrc/Single/" + number + ".txt", "UTF-8");
        correctAns = ansReader.getContent();

        // set textArea
        quizArea.setText(quiz);

        // add visited
        visit[0][number] = 1;

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
            String option = event.getActionCommand();
            submitButton.setEnabled(true);

            if (option == "A") {
                answer = "A";
            } else if (option == "B") {
                answer = "B";
            } else if (option == "C") {
                answer = "C";
            } else if (option == "D") {
                answer = "D";
            }

            answerLabel.setIcon(new ImageIcon("src/imageSrc/Option" + answer + ".png"));
        }
    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd == "menu") {
                JLabel x = new JLabel("You want to back to Menu?");
                x.setFont(new Font("Times New Roman", Font.BOLD, 12));
                int result = JOptionPane.showConfirmDialog(null, x, "Warning",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imageSrc/Thinking.png"));
                
                if (result == JOptionPane.YES_OPTION) {     // yes button
                    new Menu();
                    setVisible(false);
                } 
            } else if (cmd == "submit") {
                int TorF;
                String[] options = {"return", "next"};
                System.out.println(answer);

                if (answer.equals(correctAns) == false) {        // wrong 
                    JLabel y = new JLabel("oh-oooh, the answer is " + correctAns);
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                } else {
                    setScore(getScore() + 20); // correct
                    JLabel y = new JLabel("Correct! Keep going!");
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "Correct!", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                }
                System.out.println("score = " + score);
                if (TorF == 0) {
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
                //nextQuizType = 1;
                System.out.println(nextQuizType);
                switch(nextQuizType) {
                    case 1:             // single
                        new MultipleChoice(visit, ++quizNumber, score);
                        setVisible(false);
                        break;
                    case 2:             // yes/no
                        new TrueOrFalse(visit, ++quizNumber, score);
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
