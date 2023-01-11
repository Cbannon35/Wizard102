package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.HashMap;
import assets.SpriteReader;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        /* Create our player animations */
        animations = new HashMap<String, BufferedImage[]>();
        /* Resolve our sprite sheet path */
        String path = "src/assets/gameboy_rpg_v09.png";

        try {
            /* up */
            BufferedImage[] upArr = new BufferedImage[1];
            upArr[0] = SpriteReader.readSprite(path, 8, 30);
            animations.put("up", upArr);
            /* upWalk */
            BufferedImage[] upWalkArr = new BufferedImage[2];
            upWalkArr[0] = SpriteReader.readSprite(path, 8, 33);
            upWalkArr[1] = SpriteReader.readSprite(path, 9, 34);
            animations.put("upWalk", upWalkArr);
            /* down */
            BufferedImage[] downArr = new BufferedImage[1];
            downArr[0] = SpriteReader.readSprite(path, 8, 29);
            animations.put("down", downArr);
            /* downWalk */
            BufferedImage[] downWalkArr = new BufferedImage[2];
            downWalkArr[0] = SpriteReader.readSprite(path, 8, 31);
            downWalkArr[1] = SpriteReader.readSprite(path, 9, 32);
            animations.put("downWalk", downWalkArr);
            /* left */
            BufferedImage[] leftArr = new BufferedImage[1];
            leftArr[0] = SpriteReader.readSprite(path, 8, 37);
            animations.put("left", leftArr);
            /* leftWalk */
            BufferedImage[] leftWalkArr = new BufferedImage[2];
            leftWalkArr[0] = SpriteReader.readSprite(path, 8, 37);
            leftWalkArr[1] = SpriteReader.readSprite(path, 9, 38);
            animations.put("leftWalk", leftWalkArr);
            /* right */
            BufferedImage[] rightArr = new BufferedImage[1];
            rightArr[0] = SpriteReader.readSprite(path, 8, 35);
            animations.put("right", rightArr);
            /* rightWalk */
            BufferedImage[] rightWalkArr = new BufferedImage[2];
            rightWalkArr[0] = SpriteReader.readSprite(path, 8, 35);
            rightWalkArr[1] = SpriteReader.readSprite(path, 9, 36);
            animations.put("rightWalk", rightWalkArr);
        } catch (IOException e) {
            e.printStackTrace();
    }
}

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);

        g2.fillRect(x + 100, y + 100, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        /* Retrieve current image in animation
         * Direction --> what animation cycle
         * spriteNum --> where in animation cycle
         */
        image = animations.get(direction)[spriteNum];
        System.out.println(direction);
        System.out.println(spriteNum);
        System.out.println(image);
        System.out.println(image.getClass());
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

    public void update() {
        //System.out.println(direction);
        if (!keyH.isIdle()) {
            if (keyH.upPressed) {
                direction = "upWalk";
                y -= speed;
            }
            if (keyH.downPressed) {
                direction = "downWalk";
                y += speed;
            }
            if (keyH.leftPressed) {
                direction = "leftWalk";
                x -= speed;
            }
            if (keyH.rightPressed) {
                direction = "rightWalk";
                x += speed;
            }
        } else {
            /* Revert to idle */
            direction = direction.replace("Walk", "");
        }
        /*
         * This code currently has spriteNum always incrementing...
         * modulo arithmatic should prevent any erros, but this might
         * result in unwanted frames somewhere
         */
        /* Edge case check */
        int animationLength = animations.get(direction).length;
        if (spriteNum >= animationLength) {
            spriteNum = 0;
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            //System.out.println(animationLength);
            spriteNum = (spriteNum + 1) % animationLength;
            spriteCounter = 0;
        }
    }
}