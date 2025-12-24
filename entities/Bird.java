package entities;

import java.awt.Graphics;
import java.awt.Image;

import engine.Config;

public class Bird extends Entity {
    private int velocityY;

    public Bird(Image sprite, int startX, int startY) {
        this.sprite = sprite;
        this.x = startX;
        this.y = startY;
        this.width = 34;
        this.height = 24;
        this.velocityY = 0;
    }

    @Override
    public void update() {
        velocityY += Config.Gravity;
    }

    public void flap() {
        velocityY = Config.Flab_force;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }

    public boolean isOutOfBounds() {
        return y > Config.Ground_Limit || y < 0;
    }

}
