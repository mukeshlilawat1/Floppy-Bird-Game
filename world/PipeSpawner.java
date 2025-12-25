package world;

import engine.Config;
import entities.Pipe;

import java.awt.Image;
import java.util.List;
import java.util.Random;

public class PipeSpawner {

    private final List<Pipe> pipes;
    private final Image topPipeSprite;
    private final Image bottomPipeSprite;

    private long lastSpawnTime = 0;
    private final Random random = new Random();

    public PipeSpawner(List<Pipe> pipes, Image topPipeSprite, Image bottomPipeSprite) {
        this.pipes = pipes;
        this.topPipeSprite = topPipeSprite;
        this.bottomPipeSprite = bottomPipeSprite;
    }

    public void update() {
        long now = System.currentTimeMillis();

        if (now - lastSpawnTime >= Config.PIPE_INTERVAL) {
            spawnPipePair();
            lastSpawnTime = now;
        }
    }

    private void spawnPipePair() {

        // Top pipe ka bottom hamesha visible & safe range me
        int minTopPipeBottom = 120;

        // Ground se thoda upar tak hi allow karo
        int maxTopPipeBottom = Config.GROUND_LIMIT - Config.PIPE_GAP - 40;

        // Safety check (kabhi negative na ho)
        if (maxTopPipeBottom <= minTopPipeBottom) {
            return;
        }

        int topPipeBottomY = minTopPipeBottom +
                random.nextInt(maxTopPipeBottom - minTopPipeBottom);

        // Top pipe poora screen ke upar rahe
        int topPipeY = topPipeBottomY - Config.PIPE_HEIGHT;

        int bottomPipeY = topPipeBottomY + Config.PIPE_GAP;

        pipes.add(new Pipe(
                topPipeSprite,
                Config.BOARD_WIDTH,
                topPipeY,
                true));

        pipes.add(new Pipe(
                bottomPipeSprite,
                Config.BOARD_WIDTH,
                bottomPipeY,
                false));
    }

}
