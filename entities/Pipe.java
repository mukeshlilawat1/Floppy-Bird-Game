package entities;

import java.awt.Graphics;
import java.awt.*;

import engine.Config;

public class Pipe extends Entity {

    private boolean passed;

    public Pipe(Image sprite, int x, int y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.width = Config.pipe_width;
        this.height = Config.pipe_height;
        this.passed = false;
    }

    @Override
    public void update() {
        x += Config.pipe_speed;
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

}
