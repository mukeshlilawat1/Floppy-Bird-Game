package world;

import engine.Config;
import entities.Bird;
import entities.Pipe;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {

    private final Bird bird;
    private final List<Pipe> pipes;

    private final PipeSpawner pipeSpawner;
    private int score;

    public World(Bird bird, Image topPipeSprite, Image bottomPipeSprite) {
        this.bird = bird;
        this.pipes = new ArrayList<>();
        this.pipeSpawner = new PipeSpawner(pipes, topPipeSprite, bottomPipeSprite);
        this.score = 0;
    }

    // ================= UPDATE =================

    public void update() {

        // Update bird physics
        bird.update();

        // Spawn pipes
        pipeSpawner.update();

        // Update pipes + score
        Iterator<Pipe> iterator = pipes.iterator();
        while (iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.update();

            // Score logic
            if (pipe.isPassed(bird.getX())) {
                score++;
            }

            // Remove off-screen pipes
            if (pipe.isOffScreen()) {
                iterator.remove();
            }
        }
    }

    // ================= RESET =================

    public void reset() {
        pipes.clear();
        score = 0;
        bird.reset(
                Config.BOARD_WIDTH / 8,
                Config.BOARD_HEIGHT / 2
        );
    }

    // ================= GETTERS =================

    public Bird getBird() {
        return bird;
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    public int getScore() {
        return score;
    }
}
