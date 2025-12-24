import java.awt.*;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image sprite;

    public abstract void update();

    public abstract void render(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}