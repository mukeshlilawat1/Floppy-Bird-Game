package physics;

import entities.*;

public class CollisionDetector {
    private CollisionDetector() {}

    public static boolean isColliding(Entity a, Entity b) {
        return a.getBounds().intersects(b.getBounds());
    }

}
