package UI;

import engine.*;

import java.awt.*;

public class ReadyScreen {

    private final Font titleFont;
    private final Font hintFont;

    public ReadyScreen() {
        this.titleFont = new Font("Arial", Font.BOLD, 28);
        this.hintFont = new Font("Arial", Font.PLAIN, 16);
    }

    public void render(Graphics g) {

        g.setColor(new Color(0, 0, 0, 120));
        g.fillRect(0, 0, Config.BOARD_WIDTH, Config.BOARD_HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("FLAPPY BIRD",
                Config.BOARD_WIDTH / 2 - 80,
                Config.BOARD_HEIGHT / 2 - 20
        );

        g.setFont(hintFont);
        g.drawString("Press SPACE to Start",
                Config.BOARD_WIDTH / 2 - 85,
                Config.BOARD_HEIGHT / 2 + 20
        );
    }
}
