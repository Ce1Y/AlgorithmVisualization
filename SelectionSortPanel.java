package src.classSrc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class SelectionSortPanel extends JPanel {
    public TimerAction timerAction;
    public Timer timer;

    private final String str;
    private final String[] code;
    private final JList<String> codeList;

    private JScrollPane codeScrollPane;
    int fontSize = 15;

    private List<NumberRectangle> numbers = initialNumberRectangles();

    public SelectionSortPanel() {

        // panel setting
        setLayout(null);
        setOpaque(false);

        // set Timer
        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        // set code list ( change string -> stringList[] )
        SortInfoReader reader = new SortInfoReader("src/textSrc/SelectionSort.txt");
        str = reader.getContent();
        code = str.split("\n");
        codeList = new JList<String>(code);

        // set code text area
        codeList.setFont(new Font("Consolas", Font.PLAIN, fontSize));
        codeScrollPane = new JScrollPane(codeList);
        codeScrollPane.setBounds(510, 100, 425, 400);
        add(codeScrollPane);
    }

    // if sort is finished
    private boolean completed = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawNumberRectangles(g2);
    }

    private void drawNumberRectangles(Graphics2D g2) {

        // draw chart bar area
        Rectangle2D.Double area = new Rectangle2D.Double(50, 100, 425, 398);
        g2.setPaint(Color.white);
        g2.fill(area);
        g2.setPaint(Color.BLACK);
        g2.draw(area);

        for (NumberRectangle rectangle : numbers) {
            rectangle.draw(g2);
        }
    }

    // set variable in Selectionsertion Sort algorithm
    int i = 0;  // 0~9, total 10
    int j = 0;  // 0~9, total 10
    int k = 0;  // the minIndex of clean up the BLUE color
    boolean first = false;
    int lineIndex = 1;
    int minIndex = 0;
    int minNumber = 0;

    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }

            switch (lineIndex) {
                case 1:             // i loop start
                    codeList.setSelectedIndex(lineIndex);
                    lineIndex++;
                    break;
                case 2:             // i loop start
                    codeList.setSelectedIndex(lineIndex);
                    if(i!=0)
                        numbers.get(i-1).setColor(Color.BLACK);
                    //  initialize
                    for(k=i; k<10; k++) 
                        numbers.get(k).setColor(Color.WHITE);   
                    
                    if (i < 9) {   
                        numbers.get(i).setColor(Color.RED); // set target color = red
                        j = i + 1;
                        lineIndex++;
                    } else {        // end i loop
                        lineIndex = 10;
                    }
                    break;
                case 3:             
                    codeList.setSelectedIndex(lineIndex);
                    minIndex = i;
                    lineIndex++;    
                    break;
                case 4:             // j loop start
                    codeList.setSelectedIndex(lineIndex);
                    if (j < 10) {   // j < array.length
                        numbers.get(j).setColor(Color.BLUE);
                        lineIndex++;
                    } else {        // end j loop
                        lineIndex = 7;
                    }
                    break;
                case 5:             // if judge
                    codeList.setSelectedIndex(lineIndex);
                    if (numbers.get(j).getValue() < numbers.get(minIndex).getValue()) {
                        lineIndex = 6;
                    } else {
                        numbers.get(j).setColor(Color.WHITE);
                        j++;
                        lineIndex = 4;
                    }
                    break;
                case 6:             // if (true)
                    for(k=i+1; k<10; k++)
                        numbers.get(k).setColor(Color.WHITE);
                    numbers.get(j).setColor(Color.GREEN);
                    codeList.setSelectedIndex(lineIndex);
                    minIndex = j;
                    j++;            // for(...; ...; j++)
                    lineIndex = 4;  // back to "for j loop" line
                    break;
                case 7:             // case 7~9 operate swap()
                    codeList.setSelectedIndex(lineIndex);
                    minNumber = numbers.get(minIndex).getValue();
                    lineIndex++;
                    break;
                case 8:         
                    codeList.setSelectedIndex(lineIndex);
                    numbers.get(minIndex).setValue(numbers.get(i).getValue());
                    lineIndex++;      
                    break;
                case 9:             // i round finish
                    codeList.setSelectedIndex(lineIndex);
                    numbers.get(i).setValue(minNumber);
                    i++;
                    first = true;
                    lineIndex = 2;      
                    break;
                case 10:            // end loop
                    codeList.setSelectedIndex(lineIndex);
                    numbers.get(9).setColor(Color.BLACK);
                    lineIndex++;
                    break;
                case 11:            // end algorithm
                    codeList.setSelectedIndex(lineIndex);
                    completed = true;
                    break;
                default:
                    break;
            }
            repaint();
        }
    }

    private List<NumberRectangle> initialNumberRectangles() {
        List<NumberRectangle> list = new ArrayList<NumberRectangle>();

        // generate 10 random numbers
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            list.add(new NumberRectangle(i, 1, random.nextInt(15) + 1, Color.white));
        }
        return list;
    }
}