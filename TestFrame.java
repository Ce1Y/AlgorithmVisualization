package src.classSrc;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame{

    private ImageIcon backgroundImg;

    private JLabel backgroundLabel;
    
    private JPanel backgroundPanel;

    private JTextArea quizArea;
    
    private JButton returnButton;
    private JButton submitButton;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;

    private ButtonGroup answerGroup;

    private ActionListener listener = new ButtonEventListener();

    private SortInfoReader reader;
    private ArrayList<String> quizAnswer = new ArrayList<String>();

    private int typeA = 20;
    private int typeB = 20;
    private int typeC = 20;

    public TestFrame() {
        // set GUI
        super("Quiz");
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

        test();
    }

    private void test() {
        Random random = new Random();

        int quizType;
        int quizNumber;
        int index = 0;
        int[] visit = new int[20];
        
    }

    private class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private void readAnswer(int totalQuiz) {
        int quizAnswerIndex = 1;

        while(quizAnswerIndex <= totalQuiz) {
            quizAnswer.add(quizAnswerIndex + ".txt");   // quizAnswerIndex.txt get(quizAnswerIndex-1)
            quizAnswerIndex++;
        }
    }

}