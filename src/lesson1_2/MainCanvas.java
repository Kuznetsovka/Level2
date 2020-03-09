package lesson1_2;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    protected long lastFrameTime;
    private MainCircles controller;
    private int updateTime;

    public MainCanvas(MainCircles controller, int updateTime) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
        this.updateTime = updateTime;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;

        controller.onCanvasRepainted(this,g, deltaTime);
        try {
            Thread.sleep(updateTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
