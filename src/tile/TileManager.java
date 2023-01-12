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
    Tile[] tiles;
    int map[][];

    public TileManager(GamePanel gp) {

        this.gp = gp;
        tiles = new Tile[10]; // an array of unique tile assets we will load in
        map = new int[gp.maxScreenRow][gp.maxScreenCol]; 


        // load in our tile assets
        loadTiles(SpriteReader.path);
        // load up our map
        loadMap("/tile/map/test.txt");

    }

    public void loadTiles(String path) {
   
        try {
            tiles[0] = new Tile(SpriteReader.readSprite(path, 12, 22));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0, col = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while (col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    map[row][col] = num;
                    col++;
                }
                col = 0;
                row ++;
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
        int col = 0, row = 0;
        int x = 0, y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tilenum = map[row][col];
            g2.drawImage(tiles[tilenum].getImage(), x, y, gp.tileSize, gp.tileSize, null);
            x += gp.tileSize;
            col++;

            if (col == gp.maxScreenCol) {
                x = 0;
                y += gp.tileSize;
                col = 0;
                row++;
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
