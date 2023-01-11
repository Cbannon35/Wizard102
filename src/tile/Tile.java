package tile;

import java.awt.image.BufferedImage;

public class Tile {

    public BufferedImage image;
    public int type;

    public Tile (BufferedImage image, int type) {
        this.image = image;
        this.type = type;
    }

    public Tile (BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    
}
