package entities;

import java.awt.Graphics;
import java.awt.Image;

import engine.Config;

public class Bird extends Entity {

    private int velocityY;

    // Realistic Flappy Bird size
    private static final int BIRD_WIDTH = 24;
    private static final int BIRD_HEIGHT = 18;

    public Bird(Image sprite, int startX, int startY) {
        this.sprite = sprite;
        this.x = startX;
        this.y = startY;
        this.width = BIRD_WIDTH;
        this.height = BIRD_HEIGHT;
        this.velocityY = 0;
    }

    @Override
    public void update() {
        velocityY += Config.GRAVITY;
        y += velocityY;               // 🔥 MISSING LINE (MOST IMPORTANT)
    }

    public void flap() {
        velocityY = Config.FLAP_FORCE;
    }

    @Override
    public void render(Graphics g) {
        // 🔥 SCALE IMAGE TO BIRD SIZE
        g.drawImage(
                sprite,
                x,
                y,
                width,
                height,
                null
        );
    }

    public boolean isOutOfBounds() {
        return y < 0 || y + height > Config.GROUND_LIMIT;
    }

    public void reset(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.velocityY = 0;
    }
}
