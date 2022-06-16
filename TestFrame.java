/*
 * package src.classSrc;
 * 
 * import java.util.ArrayList;
 * import java.util.Random;
 * 
 * import javax.swing.*;
 * 
 * import java.awt.*;
 * import java.awt.event.ActionEvent;
 * import java.awt.event.ActionListener;
 * 
 * public class TestFrame extends JFrame{
 * 
 * private ImageIcon backgroundImg;
 * 
 * private JLabel backgroundLabel;
 * 
 * private JPanel backgroundPanel;
 * 
 * private JTextArea quizArea;
 * 
 * private JButton returnButton;
 * private JButton submitButton;
 * private JButton buttonA;
 * private JButton buttonB;
 * private JButton buttonC;
 * private JButton buttonD;
 * 
 * private ButtonGroup answerGroup;
 * 
 * private ActionListener listener = new ButtonEventListener();
 * 
 * private SortInfoReader reader;
 * private ArrayList<String> quizAnswer = new ArrayList<String>();
 * 
 * private int typeA = 20;
 * private int typeB = 20;
 * private int typeC = 20;
 * 
 * public TestFrame() {
 * // set GUI
 * super("Quiz");
 * setSize(1000, 600);
 * setLayout(null);
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * setLocationRelativeTo(null);
 * setResizable(false);
 * setVisible(true);
 * 
 * // set background
 * backgroundImg = new ImageIcon("src/imageSrc/Background.png");
 * backgroundLabel = new JLabel(backgroundImg);
 * backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
 * backgroundPanel = (JPanel) this.getContentPane();
 * backgroundPanel.setOpaque(false);
 * getLayeredPane().add(backgroundLabel, Integer.valueOf(Integer.MIN_VALUE));
 * 
 * test();
 * }
 * 
 * private void test() {
 * Random random = new Random();
 * 
 * int quizType;
 * int quizNumber;
 * int index = 0;
 * int[] visit = new int[20];
 * 
 * // readfile()
 * // readAnswer()
 * 
 * // read quiz
 * while(index < 10) {
 * // choose a quiz from 1 ~ arrayList.size()
 * quizType = random.nextInt(3) + 1;
 * switch(quizType) {
 * case 1:
 * while(true) {
 * quizNumber = random.nextInt(typeA) + 1;
 * if (visit[quizNumber] != 1) { // haven't been visited yet
 * multipleChoiceFrame();
 * visit[quizNumber] = 1;
 * break;
 * }
 * }
 * break;
 * case 2:
 * while(true) {
 * quizNumber = random.nextInt(typeA) + 1;
 * if (visit[quizNumber] != 1) { // haven't been visited yet
 * yesNoFrame();
 * visit[quizNumber] = 1;
 * break;
 * }
 * }
 * break;
 * case 3:
 * while(true) {
 * quizNumber = random.nextInt(typeA) + 1;
 * if (visit[quizNumber] != 1) { // haven't been visited yet
 * insertFrame();
 * visit[quizNumber] = 1;
 * break;
 * }
 * }
 * break;
 * }
 * index++;
 * }
 * }
 * 
 * public boolean multipleChoiceFrame() {
 * 
 * boolean accomplished = false;
 * 
 * // set textArea
 * quizArea = new JTextArea("src/textSrc/InsertionSort.txt");
 * quizArea.setEditable(false);
 * quizArea.setBounds(90, 50, 800, 300);
 * 
 * // set button
 * returnButton = new JButton("Menu");
 * returnButton.setBounds(780, 510, 100, 50);
 * returnButton.addActionListener(listener);
 * 
 * submitButton = new JButton("submit");
 * submitButton.setBounds(880, 510, 100, 50);
 * submitButton.addActionListener(listener);
 * 
 * buttonA = new JButton("A");
 * buttonA.setBounds(90, 400, 100, 50);
 * buttonA.addActionListener(listener);
 * 
 * buttonB = new JButton("B");
 * buttonB.setBounds(323, 400, 100, 50);
 * buttonB.addActionListener(listener);
 * 
 * buttonC = new JButton("C");
 * buttonC.setBounds(556, 400, 100, 50);
 * buttonC.addActionListener(listener);
 * 
 * buttonD = new JButton("D");
 * buttonD.setBounds(790, 400, 100, 50);
 * buttonD.addActionListener(listener);
 * 
 * // set buttonGroup
 * answerGroup = new ButtonGroup();
 * answerGroup.add(buttonA);
 * answerGroup.add(buttonB);
 * answerGroup.add(buttonC);
 * answerGroup.add(buttonD);
 * 
 * // add new elements to frame
 * this.add(quizArea);
 * this.add(returnButton);
 * this.add(submitButton);
 * this.add(buttonA);
 * this.add(buttonB);
 * this.add(buttonC);
 * this.add(buttonD);
 * 
 * if (accomplished) {
 * return true;
 * }
 * 
 * }
 * 
 * // Yes/No
 * public void yesNoFrame() {
 * 
 * }
 * 
 * // Insert
 * public void insertFrame() {
 * 
 * }
 * 
 * private class ButtonEventListener implements ActionListener {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * 
 * }
 * }
 * 
 * private void readAnswer(int totalQuiz) {
 * int quizAnswerIndex = 1;
 * 
 * while(quizAnswerIndex <= totalQuiz) {
 * quizAnswer.add(quizAnswerIndex + ".txt"); // quizAnswerIndex.txt
 * get(quizAnswerIndex-1)
 * quizAnswerIndex++;
 * }
 * }
 * 
 * }
 * 
 */