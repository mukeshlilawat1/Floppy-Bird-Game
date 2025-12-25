package input;

import engine.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardHandler extends KeyAdapter {

    private final Game game;

    public KeyboardHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println("KEY PRESSED: " + e.getKeyCode()); // 🔥 DEBUG

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("SPACE DETECTED"); // 🔥 DEBUG
            game.onFlap();
        }
    }
}
