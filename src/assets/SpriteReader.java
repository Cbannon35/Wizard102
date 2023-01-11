package assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io. IOException;
import javax.imageio.ImageIO;


public class SpriteReader {

    /* Default values for 16bit sprite sheet */
    final static int WIDTH = 16, HEIGHT = 16;
    
    /*
     * This method reads a sprite from a sprite sheet
     * @param path: path to the sprite sheet
     * @param row: row of the sprite
     * @param col: column of the sprite
     * 
     * Potential arguments for overloading (for different resolutions): 
     * @param width: width of the sprite
     * @param height: height of the sprite
     */
    public static BufferedImage readSprite(String path, int row, int col) throws IOException{
        /* Signaling this method thros IOException --> don't have to try&catch */
        BufferedImage spriteSheet = ImageIO.read(new File(path));
        BufferedImage sprite = spriteSheet.getSubimage((col*WIDTH)-WIDTH, (row*HEIGHT)-HEIGHT, WIDTH, HEIGHT);

        return sprite;
    }
}
