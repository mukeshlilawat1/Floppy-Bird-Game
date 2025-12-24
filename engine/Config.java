package engine;

public final class Config {
    //Board
    public static final int Board_width = 360;
    public static final int Board_Height = 640;

    // bird physics
    public static final int Gravity = 1;
    public static final int Flab_force = -9;

    // pipes
    public static final int pipe_width = 64;
    public static final int pipe_height = 512;
    public static final int pipe_gap = 150;
    public static final int pipe_speed = -4;
    public static final long pipe_interval = 1500; //ms

    // Game
    public static final int Ground_Limit = Board_Height;
    public static final int score_font_size = 32;

    private Config() {

    }
}
