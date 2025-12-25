package engine;

import entities.Bird;
import physics.PhysicsEngine;
import rendering.Renderer;
import rendering.SpriteLoader;
import world.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Game extends JPanel {

    private GameState gameState;

    private final World world;
    private final PhysicsEngine physicsEngine;
    private final Renderer renderer;
    private final GameLoop gameLoop;

    public Game() {

        setPreferredSize(new Dimension(
                Config.BOARD_WIDTH,
                Config.BOARD_HEIGHT
        ));
        setFocusable(true);
        setDoubleBuffered(true);

        // -------- LOAD SPRITES --------
        Image bg = SpriteLoader.load("../flappybirdbg.png");
        Image birdSprite = SpriteLoader.load("../flappybird.png");
        Image topPipe = SpriteLoader.load("../toppipe.png");
        Image bottomPipe = SpriteLoader.load("../bottompipe.png");

        this.physicsEngine = new PhysicsEngine();
        this.renderer = new Renderer(bg);

        this.world = new World(
                new Bird(
                        birdSprite,
                        Config.BOARD_WIDTH / 8,
                        Config.BOARD_HEIGHT / 2
                ),
                topPipe,
                bottomPipe
        );

        this.gameState = GameState.READY;
        this.gameLoop = new GameLoop(this);

        // 🔥 KEY BINDINGS (FINAL FIX)
        setupKeyBindings();
    }

    private void setupKeyBindings() {

        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke("SPACE"), "flap");

        am.put("flap", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onFlap();
            }
        });
    }

    // ---------------- GAME FLOW ----------------

    public void start() {
        gameState = GameState.RUNNING;
        gameLoop.start();
    }

    public void restart() {
        world.reset();
        gameState = GameState.RUNNING;
    }

    public void update() {
        if (gameState != GameState.RUNNING) return;

        world.update();

        gameState = physicsEngine.updatePhysics(
                world.getBird(),
                world.getPipes(),
                gameState
        );
    }

    public void render() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        renderer.renderScene(
                g,
                world.getBird(),
                world.getPipes(),
                world.getScore(),
                gameState
        );
    }

    public void onFlap() {

        if (gameState == GameState.READY) {
            start();
            return;
        }

        if (gameState == GameState.RUNNING) {
            world.getBird().flap();
        } else if (gameState == GameState.GAME_OVER) {
            restart();
        }
    }
}
