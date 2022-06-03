package src.classSrc;

import javax.swing.*;

public class index {
    

    public static void main(String[] args) {
        Frame1 frame1 = new Frame1();
        frame1.setSize(1000, 600);
        // set frame1 background
        ImageIcon background = new ImageIcon("src/imageSrc/whiteBackground.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
        JPanel imagePanel = (JPanel) frame1.getContentPane();
        imagePanel.setOpaque(false);
        frame1.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
    }
}
