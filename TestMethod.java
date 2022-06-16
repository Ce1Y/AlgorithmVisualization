/*
 * package src.classSrc;
 * 
 * import java.util.ArrayList;
 * 
 * import javax.swing.*;
 * 
 * import java.awt.*;
 * import java.awt.event.ActionEvent;
 * import java.awt.event.ActionListener;
 * 
 * public class TestMethod {
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
 * // Multiple choice
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
 * }
 */
