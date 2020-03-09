package lesson1_2;

import java.awt.*;

public class BackGround extends Sprite{
    protected int width;
    protected int height;

    public BackGround(int width, int height) {
        this.height = height;
        this.width = width;
    }

    private Color getColor() {
        return new Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255));
    }

    public void render(MainCanvas canvas,Graphics g) {
        g.setColor(getColor());
        g.fillRect(0,0, (int) getWidth(), (int) getHeight());
    }

    public void update(MainCanvas canvas,Graphics g) {
        g.setColor(getColor());
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }
}
