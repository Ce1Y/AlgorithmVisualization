package src.classSrc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class NumberRectangle {

    private int x;
    private int y;
    private int value;
    private Color color;

    public NumberRectangle(int x, int y, int value, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.value = value;
    }

    public void draw(Graphics2D g2) {

        int clientX = 85 + x * 30;
        int clientY = 150 + y * 10;
        Rectangle2D.Double rect = new Rectangle2D.Double(clientX, clientY, 20, value * 20);
        g2.setPaint(color);
        g2.fill(rect);
        g2.setPaint(Color.BLACK);
        g2.draw(rect);
        g2.drawString(String.valueOf(value), clientX, clientY - 10);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}