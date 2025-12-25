package rendering;

import javax.swing.*;
import java.awt.*;

public class SpriteLoader {

    private SpriteLoader() {}

    public static Image load(String path) {
        return new ImageIcon(SpriteLoader.class.getResource(path)).getImage();
    }

}
