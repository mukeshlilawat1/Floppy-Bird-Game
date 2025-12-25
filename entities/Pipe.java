package entities;

import java.awt.Graphics;
import java.awt.Image;

import engine.Config;

public class Pipe extends Entity {

    private boolean passed;
    private final boolean top; // 🔥 NEW

    public Pipe(Image sprite, int x, int y, boolean top) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.top = top;
        this.width = Config.PIPE_WIDTH;
        this.height = Config.PIPE_HEIGHT;
        this.passed = false;
    }

    @Override
    public void update() {
        x += Config.PIPE_SPEED;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, x, y, width, height, null);
    }

    public boolean isPassed(int birdX) {
        if (!passed && birdX > x + width) {
            passed = true;
            return true;
        }
        return false;
    }

    public boolean isOffScreen() {
        return x + width < 0;
    }

    public boolean isTop() {
        return top;
    }
}
