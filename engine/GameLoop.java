package engine;

public class GameLoop implements Runnable {

    private boolean running;
    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    @Override
    public void run() {

        long frameTime = 1000 / Config.FPS;

        while (running) {
            long start = System.currentTimeMillis();

            game.update();
            game.render();

            long sleep = frameTime - (System.currentTimeMillis() - start);
            if (sleep > 0) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
