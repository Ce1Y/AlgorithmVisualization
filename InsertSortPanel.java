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

public class InsertSortPanel extends JPanel {
    public TimerAction timerAction;
    public Timer timer;

    private final String str;
    private final String[] code;
    private final JList codeList;

    private JScrollPane codeScrollPane;
    int fontSize = 15;

    private List<NumberRectangle> numbers = initialNumberRectangles();

    public InsertSortPanel() {

        // panel setting
        setLayout(null);
        setOpaque(false);

        // set Timer
        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        // set code list ( change string -> stringList[] )
        SortInfoReader reader = new SortInfoReader("src/textSrc/InsertionSort.txt");
        str = reader.getContent();
        code = str.split("\n");
        codeList = new JList(code);

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

    // set variable in Insertion Sort algorithm
    int outerLoopCnt = 1;
    int innerLoopCnt = 0;
    int key = 0;
    int currentIndex = 1;

    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }

            switch (currentIndex) {
                case 1:
                    if (outerLoopCnt < 10) {
                        codeList.setSelectedIndex(currentIndex++);
                    } else {
                        currentIndex = 10;
                    }
                    break;
                case 2:
                    key = numbers.get(outerLoopCnt).getValue();
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 3:
                    innerLoopCnt = outerLoopCnt;
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 4:
                    if (innerLoopCnt > 0 && key < numbers.get(innerLoopCnt - 1).getValue()) {
                        codeList.setSelectedIndex(currentIndex++);
                    } else {
                        codeList.setSelectedIndex(currentIndex++);
                        currentIndex = 8;
                    }
                    break;
                case 5:
                    codeList.setSelectedIndex(currentIndex++);
                    numbers.get(innerLoopCnt).setColor(Color.RED);
                    numbers.get(innerLoopCnt).setValue(numbers.get(innerLoopCnt - 1).getValue());
                    break;
                case 6:
                    codeList.setSelectedIndex(currentIndex++);
                    numbers.get(innerLoopCnt).setColor(Color.BLACK);
                    innerLoopCnt--;
                    currentIndex = 4; // back to while
                    break;
                case 8:
                    codeList.setSelectedIndex(currentIndex);
                    numbers.get(innerLoopCnt).setValue(key);
                    numbers.get(innerLoopCnt).setColor(Color.BLACK);
                    currentIndex = 1;
                    outerLoopCnt++;
                    break;
                case 10:
                    if (currentIndex == 10) {
                        completed = true;
                        numbers.get(0).setColor(Color.BLACK);
                        codeList.setSelectedIndex(currentIndex + 1);
                    }
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