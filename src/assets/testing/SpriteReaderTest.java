package assets.testing;
import javax.swing.JFrame;

public class SpriteReaderTest{
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("test");

        GamePanelTesting gamePanel = new GamePanelTesting();
        window.add(gamePanel);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
        
    }
}
