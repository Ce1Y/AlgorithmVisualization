package src.classSrc;

import javax.swing.*;

public class GUIFrameTest {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
