package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cloze extends JFrame implements TestFrameImplement{

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
    private JTextField textField;


    private ButtonGroup answerGroup;

    private ActionListener ansListener = new AnswerEventListener();
    private ActionListener cmdHandler = new ButtonEventListener();

    private SortInfoReader reader;
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score;
    private String quiz;
    private String ans;
    private String correctAns;

    
    public Cloze(int[][] visit, int quizNumber, int score) {

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
        submitButton.setVisible(true);


        
        textField = new JTextField();
        textField.setBounds(90,400,750,50);
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(cmdHandler);
        textField.setVisible(true);

        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(textField);
        

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
        quizReader = new SortInfoReader();
        quiz = quizReader.getContent();
        // read answer
        ansReader = new SortInfoReader();
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



    /// ans Action 


    private class AnswerEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            submitButton.setEnabled(true);
            

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
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, new ImageIcon("src/imageSrc/Thinking4.png"));
                
                if (result == JOptionPane.YES_OPTION) {     // yes button
                    new Frame1();
                    setVisible(false);
                } 


            } else if (cmd == "submit") {
                int TorF;
                String ans = textField.getText(); 
                String[] options = {"return", "next"};
                System.out.println(ans);

                if (ans.equals(correctAns) == false) {        // wrong 
                    JLabel y = new JLabel("oh-oooh, the answer is " + correctAns);
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                } else {                                // correct
                    JLabel y = new JLabel("Correct! Keep going!");
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "Correct!", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                }

                if (TorF == 0) {
                    new Frame1();
                    setVisible(false);
                    return;
                }

                if (quizNumber == 5) {
                    JOptionPane.showMessageDialog(null, 
                        "Congratulation!!! You get " + score + " points in this test, well done!!!");
                    new Frame1();
                    setVisible(false);
                    return;
                }

                int nextQuizType = random.nextInt(3) + 1;
                System.out.println(nextQuizType);
                switch(nextQuizType) {
                    case 1:             // single
                        // TODO
                        break;
                    case 2:             // yes/no
                        // TODO
                        setVisible(false);
                        break;  
                    case 3:             // insert
                        new Cloze(visit, quizNumber, score);
                        setVisible(false);
                        break;
                }
            }

        }
    }
}