package engine;

public final class Config {

    // ================== BOARD ==================
    public static final int BOARD_WIDTH = 360;
    public static final int BOARD_HEIGHT = 640;

    // ================== GAME LOOP ==================
    public static final int FPS = 60;

    // ================== BIRD PHYSICS ==================
    public static final int GRAVITY = 1;
    public static final int FLAP_FORCE = -9;

    // ================== PIPES ==================
    public static final int PIPE_WIDTH = 64;
    public static final int PIPE_HEIGHT = 420;
    public static final int PIPE_GAP = 150;
    public static final int PIPE_SPEED = -4;
    public static final long PIPE_INTERVAL = 1500; // ms

    // ================== GROUND ==================
    // Background image me land already drawn hai
    // Isliye bottom ka kuch hissa playable nahi hona chahiye
    public static final int GROUND_HEIGHT = 100;   // adjust if needed
    public static final int GROUND_LIMIT = BOARD_HEIGHT - GROUND_HEIGHT;

    // ================== UI ==================
    public static final int SCORE_FONT_SIZE = 32;

    private Config() {
        // prevent instantiation
    }
}
