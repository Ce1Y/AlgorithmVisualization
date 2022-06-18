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
    private final JList codeList;

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

    int currentIndex = 1;
    int p = 0;
    int r = 9;
    int index;
    int tmp;
    int index_new;
    int flag = 0;
    int check = 0;

    int pivot;

    private List<Integer> pivot_pre = new ArrayList<Integer>();
    private List<Integer> pivot_next = new ArrayList<Integer>();


    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            if (completed) {
                return;
            }
            if (check == 0) {
                pivot_pre.add(8);
                pivot_next.add(10);
                check = 1;
            }

            switch (currentIndex) {
                case 1:
                    codeList.setSelectedIndex(currentIndex++);
                    if (flag == 0)
                        numbers.get(r).setColor(Color.RED);
                    else {
                        if (pivot == 0) {

                        } else {
                            numbers.get(pivot - 1).setColor(Color.RED);
                        }

                    }

                    break;
                case 2:
                    codeList.setSelectedIndex(currentIndex++);
                    if (flag == 0)
                        numbers.get(r).setColor(Color.WHITE);
                    else {
                        if (pivot == 0) {

                        } else {
                            numbers.get(pivot - 1).setColor(Color.WHITE);
                        }
                    }

                    if (flag == 0) {
                        flag = 1;
                        pivot = partition(numbers, p, r);
                    } else {
                        if (pivot == 0 ) {
                            while (pivot_next.get(tmp) >= pivot_pre.get(tmp - 1))
                                tmp--;
                            pivot = partition(numbers, pivot_next.get(tmp), pivot_pre.get(tmp - 1));
                        } else {
                            pivot = partition(numbers, p, pivot - 1);
                        }
                    }

                    break;
                case 3:
                    codeList.setSelectedIndex(currentIndex++);
                    for (int k = 0; k < numbers.size(); k++) {
                        System.out.print(numbers.get(k).getValue() + "  ");
                    }
                    System.out.println();
                    numbers.get(pivot).setColor(Color.RED);


                    pivot_pre.add(pivot - 1);
                    pivot_next.add(pivot + 1);
                    index = pivot_pre.size() - 1;


                    System.out.println("pivot = " + pivot);
                    System.out.println("pivot_pre = " + pivot_pre);
                    System.out.println("pivot_next = " + pivot_next);
                    System.out.println("index = " + index);
                    break;
                case 4:
                    numbers.get(pivot).setColor(Color.BLACK);
                    codeList.setSelectedIndex(currentIndex++);
                    currentIndex = 1;
                    break;
                case 5:
                    codeList.setSelectedIndex(currentIndex++);
                    currentIndex = 3;
                    break;
                case 6:

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

    private int partition(List<NumberRectangle> numbers, int p, int r) {
        int val1, val2;
        int x = numbers.get(r).getValue();
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (numbers.get(j).getValue() <= x) {
                i++;
                val1 = numbers.get(i).getValue();
                val2 = numbers.get(j).getValue();
                numbers.get(i).setValue(val2);
                numbers.get(j).setValue(val1);
            }
        }
        val1 = numbers.get(i + 1).getValue();
        val2 = numbers.get(r).getValue();
        numbers.get(i + 1).setValue(val2);
        numbers.get(r).setValue(val1);
        return i + 1;

    }


}