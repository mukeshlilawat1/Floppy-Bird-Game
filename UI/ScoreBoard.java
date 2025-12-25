package UI;

import engine.*;

import java.awt.*;

public class ScoreBoard {

    private final Font scoreFont;

    public ScoreBoard() {
        this.scoreFont = new Font(
                "Arial",
                Font.BOLD,
                Config.SCORE_FONT_SIZE
        );
    }

    public void render(Graphics g, int score) {
        g.setFont(scoreFont);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(score), 15, 40);
    }
}

