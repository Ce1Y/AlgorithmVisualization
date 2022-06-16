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

public class QuickSortPanel extends JPanel {
    public TimerAction timerAction;
    public Timer timer;

    private final String str;
    private final String[] code;
    private final JList<String> codeList;

    private JScrollPane codeScrollPane;
    int fontSize = 15;

    private List<NumberRectangle> numbers = initialNumberRectangles();

    public QuickSortPanel() {

        // panel setting
        setLayout(null);
        setOpaque(false);

        // set Timer
        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        // set code list ( change string -> stringList[] )
        SortInfoReader reader = new SortInfoReader("src/textSrc/QuickSort.txt");
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

    // set variable in Insertion Sort algorithm

    int currentIndex = 1;
    int p = 0;
    int r = 9;
    int x;
    int i;
    int tmp;
    int runtime = 0;
    int j;
    int q;

    private List<Integer> pivot_pre = new ArrayList<Integer>();
    private List<Integer> pivot_next = new ArrayList<Integer>();

    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }

            switch (currentIndex) {
                case 1:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 3;
                    break;
                case 3:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 9;
                    runtime++;
                    break;
                case 4:
                    q = i;
                    if (runtime == 2 || runtime == 4 || runtime == 6 || runtime == 8) {
                        r = q - 1;
                        codeList.setSelectedIndex(currentIndex--);
                    } else {
                        codeList.setSelectedIndex(currentIndex++);
                    }
                    break;
                case 5:
                    if (runtime == 9) {
                        codeList.setSelectedIndex(currentIndex);
                        currentIndex = 7;
                    }
                    if (runtime == 1 || runtime == 3 || runtime == 5 || runtime == 7) {
                        p = q + 1;
                        codeList.setSelectedIndex(currentIndex);
                        currentIndex = 3;
                    }
                    break;
                case 7:
                    completed = true;
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 9:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 13;
                    x = numbers.get(r).getValue();
                    i = p - 1;
                    j = p;
                    break;
                case 12:
                    codeList.setSelectedIndex(currentIndex);
                    if (j <= r - 1) {
                        currentIndex++;
                    } else {
                        currentIndex = 18;
                    }
                    break;
                case 13:
                    if (numbers.get(j).getValue() <= x) {
                        codeList.setSelectedIndex(currentIndex);
                        currentIndex = 15;
                    } else {
                        codeList.setSelectedIndex(currentIndex--);
                        j++;
                    }
                    break;
                case 15:
                    codeList.setSelectedIndex(currentIndex);
                    i++;
                    tmp = numbers.get(i).getValue();
                    numbers.get(i).setColor(Color.black);
                    numbers.get(i).setValue(numbers.get(j).getValue());
                    numbers.get(j).setValue(tmp);
                    currentIndex = 12;
                    j++;
                    break;
                case 18:
                    codeList.setSelectedIndex(currentIndex++);
                    tmp = numbers.get(i + 1).getValue();
                    numbers.get(i + 1).setColor(Color.red);
                    numbers.get(i + 1).setValue(numbers.get(r).getValue());
                    numbers.get(r).setValue(tmp);
                    i++;
                    break;
                case 19:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 4;
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