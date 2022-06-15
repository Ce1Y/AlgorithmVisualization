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

public class BubbleSortPanel extends JPanel {
    public TimerAction timerAction;
    public Timer timer;

    private final String str;
    private final String[] code;
    private final JList codeList;

    private JScrollPane codeScrollPane;
    int fontSize = 15;

    private List<NumberRectangle> numbers = initialNumberRectangles();

    public BubbleSortPanel() {

        // panel setting
        setLayout(null);
        setOpaque(false);

        // set Timer
        timerAction = new TimerAction();
        timer = new Timer(1000, timerAction);

        // set code list ( change string -> stringList[] )
        SortInfoReader reader = new SortInfoReader("src/textSrc/BubbleSort.txt");
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

   // set variable in Selectionsertion Sort algorithm
   int i = 0;  // 0~9, total 10
   int j = 0;  // 0~9, total 10
   int k = 0;  // the minIndex of clean up the BLUE color
   boolean first = false;
   int lineIndex = 1;
   int temp = 0;



    private class TimerAction implements ActionListener, Serializable {
        public void actionPerformed(ActionEvent event) {
            switch (lineIndex) {
                case 1:             // i loop start
                    codeList.setSelectedIndex(lineIndex);
                    lineIndex++;
                    break;
                case 2:             // i loop start
                    codeList.setSelectedIndex(lineIndex);
                    //  initialize
                      
                    
                    if (i < 10) {   
                        j=0;
                        lineIndex++;
                    } else {        // end i loop
                        lineIndex = 10;
                    }
                    break;
                case 3:             
                    codeList.setSelectedIndex(lineIndex);
                    
                    for(k=0; k<10; k++) 
                        numbers.get(k).setColor(Color.WHITE);
                    
                    if(j< 9) {//j < arr.length - i - 1
                        numbers.get(j).setColor(Color.RED); // set target color = red
                        lineIndex++;
                        //System.out.println(lineIndex);
                    } else {
                        lineIndex = 2;
                        i++;
                    }
                    
                    break;
                case 4:
                    numbers.get(j+1).setColor(Color.BLUE);
                    codeList.setSelectedIndex(lineIndex);             
                    if(numbers.get(j).getValue() > numbers.get(j+1).getValue()){
                        lineIndex++;
                    }else{
                        lineIndex = 8;
                    }
                case 5:             
                    codeList.setSelectedIndex(lineIndex);
                    temp = numbers.get(j).getValue();
                    lineIndex++;
                    break;
                case 6:             
                    codeList.setSelectedIndex(lineIndex);
                    numbers.get(j).setValue(numbers.get(j + 1).getValue());
                    lineIndex++;
                    break;
                case 7:             // case 7~9 operate swap()
                    codeList.setSelectedIndex(lineIndex);
                    numbers.get(j+1).setValue(temp);
                    lineIndex++;
                    break;
                case 8:         
                    codeList.setSelectedIndex(lineIndex);
                    lineIndex++;      
                    break;
                case 9:             // j round finish
                    codeList.setSelectedIndex(lineIndex);
                    j++;
                    lineIndex = 3;
                    break;
                case 10:            // end loop
                    codeList.setSelectedIndex(lineIndex);
                    for(int r=0;r<10;r++){
                         numbers.get(r).setColor(Color.BLACK);
                    }
                   
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