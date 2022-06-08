package ntou.cs.java2022;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Image;

public class CustomImgPanel extends JPanel{
    private int width = 0;
    private int height = 0;
    private String imgPath = "";

    public CustomImgPanel(int width, int height, String imgPath){
        this.width = width;
        this.height = height;
        this.imgPath = imgPath;
        setSize(this.width, this.height);
        setVisible(true);
    }

    public CustomImgPanel(double width, double height, String imgPath){
        this.width = (int)width;
        this.height = (int)height;
        this.imgPath = imgPath;
        setSize(this.width, this.height);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics gs) {
        Graphics2D g = (Graphics2D) gs;
        super.paintComponent(g);
        // 畫背景圖片
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgPath));
        g.drawImage(image, 0, 0, width,height, this);
    }
}
