package physics;

import java.util.List;

import engine.*;
import entities.*;

public class PhysicsEngine {
    public GameState updatePhysics(
            Bird bird, List<? extends Entity> obstacles,
            GameState currentState) {
        // bird physics already applied in bird.update()

        // Ground / ceiling check
        if (bird.isOutOfBounds()) {
            return GameState.GAME_OVER;
        }

        for (Entity entity : obstacles) {
            if (CollisionDetector.isColliding(bird, entity)) {
                return GameState.GAME_OVER;
            }
        }
        return currentState;
    }

}
