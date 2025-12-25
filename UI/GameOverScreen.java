package UI;

import engine.Config;

import java.awt.*;

public class GameOverScreen {

    private final Font titleFont;
    private final Font hintFont;

    public GameOverScreen() {
        this.titleFont = new Font("Arial", Font.BOLD, 36);
        this.hintFont = new Font("Arial", Font.PLAIN, 18);
    }

    public void render(Graphics g, int score) {

        // Semi-transparent background
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(
                0,
                0,
                Config.BOARD_WIDTH,
                Config.BOARD_HEIGHT
        );

        // Game Over text
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString(
                "GAME OVER",
                Config.BOARD_WIDTH / 2 - 100,
                Config.BOARD_HEIGHT / 2 - 40
        );

        // Score
        g.setFont(hintFont);
        g.drawString(
                "Score : " + score,
                Config.BOARD_WIDTH / 2 - 45,
                Config.BOARD_HEIGHT / 2
        );

        // Restart hint
        g.drawString(
                "Press SPACE to Restart",
                Config.BOARD_WIDTH / 2 - 90,
                Config.BOARD_HEIGHT / 2 + 30
        );
    }
}
