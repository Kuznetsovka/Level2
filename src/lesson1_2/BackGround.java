package lesson1_2;

import javax.swing.*;
import java.awt.*;

public class BackGround extends JPanel{
    protected long lastFrameTime;
    private MainCircles controller;
    protected int width;
    protected int height;

    public BackGround(MainCircles controller, int width, int height) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
        this.height = height;
        this.width = width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        Color color = newColor();
        controller.onBackgroundRepainted(this,  g, color);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint();
    }

    private Color newColor() {
        return new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    public void render(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0,0, getWidth(), getHeight());
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
