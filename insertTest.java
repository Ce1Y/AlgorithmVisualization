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
<<<<<<< HEAD
=======
    private JTextField textField3;
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404

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
<<<<<<< HEAD

    private String correctAns;

    public insertTest(int[][] visit, int quizNumber, int score) {

        // init GUI
        super("Quiz"+ quizNumber);
=======
    private String ans2;

    private String correctAns;

    public insertTest() {

        // init GUI
        super("Quiz");
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
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
<<<<<<< HEAD
        textField1.setBounds(90,375,750,50);
        textField1.setVisible(true);
   
=======
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
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404

        // add new elements to frame
        add(quizArea);
        add(menuButton);
        add(submitButton);
        add(textField1);
<<<<<<< HEAD
      
=======
        // add(textField2);
        // add(textField3);
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

<<<<<<< HEAD
        setVisit(visit);
        
        setQuizNumber(quizNumber);
        setScore(score);
=======
        // setVisit(visit);
        // setQuizNumber(quizNumber);
        // setScore(score);
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
        setTest();

    }
    // set question & answer
    public void setTest() {
        int number;
<<<<<<< HEAD
       

        while(true) {
            number = random.nextInt(14) + 1;
            if (visit[2][number] != 1)
                break;
        }
        //number = 1;
=======

        // while(true) {
        //     number = random.nextInt(14) + 1;
        //     if (visit[2][number] != 1)
        //         break;
        // }
        number = 1;
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404

        // read 
        quizReader = new SortInfoReader("src/testSrc/Insert/" + number + ".txt", "UTF-8");
        quiz = quizReader.getContent();
        // read answer
        ansReader = new SortInfoReader("src/answerSrc/Insert/" + number + ".txt", "UTF-8");
        correctAns = ansReader.getContent();

<<<<<<< HEAD
        code = correctAns.split(" ");
        

 

        
        if(code.length > 1){
            textField2 = new JTextField();
            textField2.setBounds(90,425,750,50);
            textField2.setVisible(true);
            add(textField2);

            System.out.println(code[0]);
            System.out.println(code[1]);
        }else{
            System.out.println(code[0]);
        }

=======
        code = correctAns.split("\n");
        
        if(code.length > 1){
            textField2 = new JTextField();
            textField2.setBounds(90,0,750,50);
            textField2.setVisible(true);
            ans2 = textField1.getText(); 
            add(textField2);
        }
        
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
        // set textArea
        quizArea.setText(quiz);

        // add visited
<<<<<<< HEAD
         visit[2][number] = 1;
=======
        // visit[2][number] = 1;
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404

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
<<<<<<< HEAD
                
                String[] options = {"return", "next"};
                
                
                


                
                if(code.length == 2){   //2 ans
                    String ans2 = textField2.getText();
                    System.out.println(ans);
                    System.out.println(ans2);

                    if (ans.equalsIgnoreCase(code[0]) == false && ans2.equalsIgnoreCase(code[1]) == false) {        // wrong 
                        JLabel y = new JLabel("oh-oooh, the answer is " + code[0] + " and " + code[1]);
=======
                String[] options = {"return", "next"};
                
                System.out.println(ans);
                // System.out.println(ans2);

                if(code.length == 2){   //2 ans
                    if (ans.equals(code[0]) == false && ans2.equals(code[1]) == false) {        // wrong 
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns);
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    
<<<<<<< HEAD
                    }else if(ans.equalsIgnoreCase(code[0]) == true && ans2.equalsIgnoreCase(code[1]) == false){     //ans2 wrong
                        setScore(getScore() + 10);
                        JLabel y = new JLabel("oh-oooh, the answer2 is " + code[1] + " but your answer2 is " + ans2);
=======
                    }else if(ans.equals(code[0]) == true && ans2.equals(code[1]) == false){     //ans2 wrong
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns + " but your answer2 is " + ans2);
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    
<<<<<<< HEAD
                    }else if(ans.equalsIgnoreCase(code[0]) == false && ans2.equalsIgnoreCase(code[1]) == true){     //ans1 wrong
                        setScore(getScore() + 10);
                        JLabel y = new JLabel("oh-oooh, the answer1 is " + code[0]  + " but your answer1 is " + ans);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    
                    }else {                                                                                // correct
                    setScore(getScore() + 20);
=======
                    }else if(ans.equals(code[0]) == false && ans2.equals(code[1]) == true){     //ans1 wrong
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns + " but your answer1 is " + ans);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("rc/imageSrc/Wrong.png"), options, options[0]);
                    
                    }else {                                                                                // correct
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                    JLabel y = new JLabel("Correct! Keep going!");
                    y.setFont(new Font("Times New Roman", Font.BOLD, 12));

                    TorF = JOptionPane.showOptionDialog(null, y, "Correct!", 
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                    }

                }else {        //1 ans
<<<<<<< HEAD
                    if (ans.equalsIgnoreCase(code[0]) == false) {        // wrong 
=======
                    if (ans.equals(code[0]) == false) {        // wrong 
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                        JLabel y = new JLabel("oh-oooh, the answer is " + correctAns);
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));
    
                        TorF = JOptionPane.showOptionDialog(null, y, "You're wrong, dude...", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Wrong.png"), options, options[0]);
                    } else {                                // correct
<<<<<<< HEAD
                        setScore(getScore() + 20);
=======
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                        JLabel y = new JLabel("Correct! Keep going!");
                        y.setFont(new Font("Times New Roman", Font.BOLD, 12));
    
                        TorF = JOptionPane.showOptionDialog(null, y, "Correct!", 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imageSrc/Right.png"), options, options[0]);
                    }

                }
<<<<<<< HEAD

                System.out.println("score = " + score);

=======
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                if (TorF == 0) {
                    new Menu();
                    setVisible(false);
                    return;
                }
<<<<<<< HEAD
                
=======

>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                if (quizNumber == 5) {
                    JOptionPane.showMessageDialog(null, 
                        "Congratulation!!! You get " + score + " points in this test, well done!!!");
                    new Menu();
                    setVisible(false);
                    return;
                }

<<<<<<< HEAD
                int nextQuizType = random.nextInt(2) + 1;
                //nextQuizType = 1;
                System.out.println(nextQuizType);
                switch(nextQuizType) {
                    case 1:             // single
                        new MultipleChoice(visit, ++quizNumber, score);
                        setVisible(false);
                        break;
                    case 2:             // yes/no
                        new TrueAndFalse(visit, ++quizNumber, score);
                        setVisible(false);
                        break;  
                    case 3:             // insert
                        new insertTest(visit, ++quizNumber, score);
=======
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
>>>>>>> 1855a60dd830137043aae5e0ff30e2737beef404
                        setVisible(false);
                        break;
                }
            }
            
        }
    }
}