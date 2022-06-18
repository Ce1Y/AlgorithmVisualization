package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertTest extends JFrame implements TestFrameImplement{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    
    private JPanel backgroundPanel;

    private JTextArea quizArea;
    
    private JButton menuButton;
    private JButton submitButton;

    private  String[] code;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private SortInfoReader quizReader;
    private SortInfoReader ansReader;
    private Random random = new Random();

    private ActionListener ansListener = new AnswerEventListener();
    private ActionListener cmdHandler = new ButtonEventListener();

    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int[][] visit;
    private int quizNumber;
    private int score;
    private String quiz;
    private String ans2;

    private String correctAns;

    public insertTest() {

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
        quizArea = new JTextArea();
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

        textField1 = new JTextField();
        textField1.setBounds(90,400,750,50);
        textField1.setVisible(true);
        /* 
        textField2 = new JTextField();
        textField2.setBounds(90,400,750,50);
        textField2.setVisible(true);

        textField3 = new JTextField();
        textField3.setBounds(90,400,750,50);
        textField3.setVisible(true);
        */

        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(textField1);
        // add(textField2);
        // add(textField3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // setVisit(visit);
        // setQuizNumber(quizNumber);
        // setScore(score);
        setTest();

    }
    // set question & answer
    public void setTest() {
        int number;

        // while(true) {
        //     number = random.nextInt(14) + 1;
        //     if (visit[2][number] != 1)
        //         break;
        // }
        number = 1;

        // read 
        quizReader = new SortInfoReader("src/testSrc/Insert/" + number + ".txt", "UTF-8");
        quiz = quizReader.getContent();
        // read answer
        ansReader = new SortInfoReader("src/answerSrc/Insert/" + number + ".txt", "UTF-8");
        correctAns = ansReader.getContent();

        code = correctAns.split("\n");
        
        if(code.length > 1){
            textField2 = new JTextField();
            textField2.setBounds(90,0,750,50);
            textField2.setVisible(true);
            ans2 = textField1.getText(); 
            add(textField2);
        }
        
        // set textArea
        quizArea.setText(quiz);

        // add visited
        // visit[2][number] = 1;

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
            //String option = event.getActionCommand();
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
                    new Menu();
                    setVisible(false);
                } 
            } else if (cmd == "submit") {
                int TorF;
                
                String ans = textField1.getText(); 
                String[] options = {"return", "next"};
                
                System.out.println(ans);
                // System.out.println(ans2);

                if(code.length == 2){   //2 ans
                    if (ans.equals(code[0]) == false && ans2.equals(code[1]) == false) {        // wrong 
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    
                    }else if(ans.equals(code[0]) == true && ans2.equals(code[1]) == false){     //ans2 wrong
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns + " but your answer2 is " + ans2);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    
                    }else if(ans.equals(code[0]) == false && ans2.equals(code[1]) == true){     //ans1 wrong
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns + " but your answer1 is " + ans);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("rc/imageSrc/Wrong.png"), options, options[0]);
                    
                    }else {                                                                                // correct
                    JLabel y = new JLabel("Correct! Keep going!");
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "Correct!", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                    }

                }else {        //1 ans
                    if (ans.equals(code[0]) == false) {        // wrong 
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

                }
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

                //int nextQuizType = random.nextInt(3) + 1;
                int nextQuizType = 3;
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
                        new insertTest();
                        setVisible(false);
                        break;
                }
            }
            
        }
    }
}