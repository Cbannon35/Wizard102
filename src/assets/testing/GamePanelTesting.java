package assets.testing;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import assets.SpriteReader;
import java.awt.image.BufferedImage;

public class GamePanelTesting extends JPanel implements Runnable {
    int counter = 0;
    int FPS = 60;
    boolean color = false;
    Thread gameThread;
    BufferedImage image;
    int[][] arr;
    
    public GamePanelTesting() {
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        try {
            image = SpriteReader.readSprite("src/assets/gameboy_rpg_v09.png", 5, 1);
            System.out.println(image);
            arr = new int[16][16];

            for(int i = 0; i < 16; i++)
                for(int j = 0; j < 16; j++) {
                    arr[i][j] = image.getRGB(i, j);
                    System.out.println(arr[i][j]);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update() {
        counter += 1;
        if (counter > 300) {
            counter = 0;
            color = !color;
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        if (color) {
            g2.setColor(Color.white);
        } else {
            g2.setColor(Color.red);
        }
        g2.fillRect(1, 1, 20, 20);
        g2.drawImage(image, 8, 30, 100, 100, null);
        g2.fillRect(300, 300, 20, 20);
        
        g2.dispose();
        
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; 
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    
}
