package src.classSrc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;
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
    int ch = 0;
    int[] a = new int[11];
    int[] b = new int[11];
    int[] c = new int[11];
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
                    System.out.println(p + " " + q + " " + r);
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 9;
                    if (p == r - 1 && runtime == 0) {
                        ch = 1;
                    }
                    break;
                case 4:
                    codeList.setSelectedIndex(currentIndex--);
                    r = q - 1;
                    break;
                case 5:
                    codeList.setSelectedIndex(currentIndex);
                    p = q + 1;
                    currentIndex = 3;
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
                    q = i;
                    if (q - 1 > p && q + 1 < r) {
                        a[runtime] = p;
                        b[runtime] = r;
                        c[runtime] = q;
                        runtime++;
                    }
                    break;
                case 19:
                    codeList.setSelectedIndex(currentIndex);
                    if (q - 1 > p)
                        currentIndex = 4;
                    else
                        currentIndex = 5;
                    if (q == p + 1 && q == r - 1) {
                        runtime--;
                        p = a[runtime];
                        r = b[runtime];
                        q = c[runtime];
                        currentIndex = 5;
                    }
                    if (ch == 1)
                        currentIndex = 7;
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
        /*
         * for (int i = 1; i <= 10; i++) {
         * list.add(new NumberRectangle(i, 1, random.nextInt(15) + 1, Color.white));
         * }
         */
        list.add(new NumberRectangle(1, 1, 2, Color.white));
        list.add(new NumberRectangle(2, 1, 7, Color.white));
        list.add(new NumberRectangle(3, 1, 12, Color.white));
        list.add(new NumberRectangle(4, 1, 2, Color.white));
        list.add(new NumberRectangle(5, 1, 5, Color.white));
        list.add(new NumberRectangle(6, 1, 11, Color.white));
        list.add(new NumberRectangle(7, 1, 10, Color.white));
        list.add(new NumberRectangle(8, 1, 2, Color.white));
        list.add(new NumberRectangle(9, 1, 2, Color.white));
        list.add(new NumberRectangle(10, 1, 1, Color.white));
        return list;
    }

}