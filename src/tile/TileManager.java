package tile;

import main.GamePanel;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;

import assets.SpriteReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tiles;
    public int map[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tiles = new Tile[10]; // an array of unique tile assets we will load in
        map = new int[gp.maxWorldRow][gp.maxWorldCol]; 

        // load in our tile assets
        loadTiles(SpriteReader.path);
        // load up our map
        loadMap("/tile/map/test50x50.txt");

    }

    public void loadTiles(String path) {
   
        try {
            tiles[0] = new Tile(SpriteReader.readSprite(path, 12, 22));
            //add different tile just for testing, it's the tile to the right of ours on the sprite sheet
            tiles[1] = new Tile(SpriteReader.readSprite(path, 12, 23));
            tiles[1].collision = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0, col = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    /* i had to flip row/col here 
                    to make collision work
                    //seems fishy to me, 
                    maybe we give a deep look at row/col 
                    in all our arrays at some point 
                    to prevent future errors/confusion */
                    map[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row ++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* BUggy? */
        // try {
        //     InputStream is = getClass().getResourceAsStream(path);
        //     BufferedReader br = new BufferedReader(new InputStreamReader(is));

        //     int row = 0, col = 0;
        //     for (row = 0; row < gp.maxScreenRow; row++) {
        //         String line = br.readLine();
        //         System.out.println(line);
                
        //         for (col = 0; col < gp.maxScreenCol; col++) {
        //             String tileRow[] = line.split(" ");
        //             map[row][col] = Integer.parseInt(tileRow[col]);
        //             System.out.print(Integer.parseInt(tileRow[col]) + " ");
        //         }
        //         System.out.println("");
        //     }
        //     br.close();

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
    public void draw(Graphics2D g2) {
        int worldCol = 0, worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tilenum = map[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX && worldX  - gp.tileSize < gp.player.worldX + gp.player.screenX && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tiles[tilenum].getImage(), screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            } 
        }

        /* Buggy? */
        // for (row = 0; row < gp.maxScreenRow; row++) {
        //     for (col = 0; col < gp.maxScreenCol; col++) {
        //         g.drawImage(tiles[map[row][col]].getImage(), x, y, gp.tileSize, gp.tileSize, null);
        //         x += gp.tileSize;
        //         col++;
        //     }
        //     x = 0;
        //     col = 0;
        //     row++;
        //     y += gp.tileSize;
        // }
    }
}
