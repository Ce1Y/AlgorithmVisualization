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

public class MergeSortPanel extends JPanel {
    public TimerAction timerAction;
    public Timer timer;

    private final String str;
    private final String[] code;
    private final JList<String> codeList;

    private JScrollPane codeScrollPane;
    int fontSize = 15;

    private List<NumberRectangle> numbers = initialNumberRectangles();

    public MergeSortPanel() {

        // panel setting
        setLayout(null);
        setOpaque(false);

        // set Timer
        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        // set code list ( change string -> stringList[] )
        SortInfoReader reader = new SortInfoReader("src/textSrc/MergeSort.txt");
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
    int runtime = 0;
    int l = 0, l0 = 0, l1 = 2, l2 = 4, l3 = 6;
    int r = 8, r0 = 8, r1 = 6, r2 = 4, r3 = 2;
    int check;
    int mid;
    int li;
    int ri;
    int arri;
    int[] tmp = new int[11];

    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }

            switch (currentIndex) {
                case 1:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 4;
                    break;
                case 4:
                    runtime++;
                    if (r - l != 2) {
                        mid = (l + r) / 2;
                        r = mid;
                        codeList.setSelectedIndex(currentIndex);
                    } else {
                        codeList.setSelectedIndex(currentIndex++);
                    }
                    break;
                case 5:
                    if (r - l != 2) {
                        if (runtime == 3 || runtime == 6)
                            l += 2;
                        if (runtime == 4)
                            l += 4;
                        codeList.setSelectedIndex(currentIndex--);
                    } else {
                        codeList.setSelectedIndex(currentIndex++);
                    }
                    break;
                case 6:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 10;
                    break;
                case 8:
                    completed = true;
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 10:
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 14;
                    break;
                case 14:
                    for (int i = l; i < r; ++i) {
                        int n = numbers.get(i).getValue();
                        tmp[i] = n;
                    }
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 15:
                    li = l;
                    ri = mid;
                    arri = l;
                    codeList.setSelectedIndex(currentIndex++);
                    break;
                case 16:
                    if (arri < r) {
                        codeList.setSelectedIndex(currentIndex++);
                    } else {
                        if (runtime == 3) {
                            r = 4;
                            mid = 2;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 5;
                        }
                        if (runtime == 4 && r - l == 2) {
                            r = 4;
                            l = 0;
                            mid = 2;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 6;
                        }
                        if (runtime == 4 && r - l == 4) {
                            r = 8;
                            l = 0;
                            mid = 4;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 5;
                        }
                        if (runtime == 6) {
                            r = 8;
                            l = 4;
                            mid = 6;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 5;
                        }
                        if (runtime == 7 && l == 6) {
                            r = 8;
                            l = 4;
                            mid = 6;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 6;
                        }
                        if (runtime == 7 && l == 4) {
                            r = 8;
                            l = 0;
                            mid = 4;
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 6;
                        }
                        if (runtime == 7 && l == 0) {
                            codeList.setSelectedIndex(currentIndex);
                            currentIndex = 8;
                        }
                    }
                    break;
                case 17:
                    if ((li < mid && tmp[li] < tmp[ri]) || ri >= r) {
                        codeList.setSelectedIndex(currentIndex++);
                    } else {
                        codeList.setSelectedIndex(currentIndex);
                        currentIndex = 20;
                    }
                    break;
                case 18:
                    numbers.get(arri+1).setColor(Color.RED);
                    numbers.get(arri+1).setValue(tmp[li++]);
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 16;
                    break;
                case 20:
                    numbers.get(arri).setColor(Color.RED);
                    numbers.get(arri++).setValue(tmp[ri++]);
                    codeList.setSelectedIndex(currentIndex);
                    currentIndex = 16;
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