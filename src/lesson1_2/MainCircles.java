package lesson1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Sprite[] sprites = new Sprite[10];
    private Sprite[] sprites1 = new Sprite[10];
    private Sprite[] sprites2 = new Sprite[10];
    private Sprite[] sprites3 = new Sprite[10];
    private Sprite[] sprites4 = new Sprite[10];
    private Sprite[] sprites5 = new Sprite[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initApplication();
        setVisible(true);
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                initNewAppByClick(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private void initNewAppByClick(int X, int Y) {
        int i = 0;
        while (sprites1[i] instanceof Ball && sprites1.length<=i){
            i++;
        }
        if (i<sprites1.length) sprites1[i] = new Ball(X,Y);
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void onBackgroundRepainted(BackGround backGround, Graphics g, Color color) {
        render(backGround, g, color);
    }

    private void render(BackGround backGround,Graphics g, Color color) {
        backGround.render(g , color);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++)
            sprites[i].update(canvas, deltaTime);

        for (int j = 0; j < sprites1.length; j++) {
            if (sprites1[j] instanceof Ball && sprites1.length <= j)
                sprites1[j].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++)
            sprites[i].render(canvas, g);
        for (int j = 0; j < sprites1.length; j++) {
            if (sprites1[j] instanceof Ball && sprites1.length <= j)
                sprites[j].render(canvas, g);
        }
    }

}
