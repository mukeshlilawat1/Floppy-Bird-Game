package rendering;

import engine.Config;
import engine.GameState;
import entities.Bird;
import entities.Pipe;
import UI.*;


import java.awt.*;
import java.util.List;

public class Renderer {

    private final Image background;

    // ---------- UI LAYER ----------
    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final GameOverScreen gameOverScreen = new GameOverScreen();
    private final ReadyScreen readyScreen = new ReadyScreen();

    public Renderer(Image background) {
        this.background = background;
    }

    public void renderScene(
            Graphics g,
            Bird bird,
            List<Pipe> pipes,
            int score,
            GameState gameState
    ) {

        // Background
        drawBackground(g);

        // Bird
        bird.render(g);

        // Pipes
        for (Pipe pipe : pipes) {
            pipe.render(g);
        }

        // ---------- UI OVERLAYS ----------
        if (gameState == GameState.READY) {
            readyScreen.render(g);
        }

        if (gameState == GameState.RUNNING) {
            scoreBoard.render(g, score);
        }

        if (gameState == GameState.GAME_OVER) {
            gameOverScreen.render(g, score);
        }
    }

    private void drawBackground(Graphics g) {
        g.drawImage(
                background,
                0,
                0,
                Config.BOARD_WIDTH,
                Config.BOARD_HEIGHT,
                null
        );
    }
}
