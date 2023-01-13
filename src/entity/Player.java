package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import assets.SpriteReader;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        /* Create our player animations */
        animations = new HashMap<String, BufferedImage[]>();
        /* Resolve our sprite sheet path */
        String path = SpriteReader.path;

        try {
            /* up */
            BufferedImage[] upArr = new BufferedImage[1];
            upArr[0] = SpriteReader.readSprite(path, 30, 8);
            animations.put("up", upArr);
            /* upWalk */
            BufferedImage[] upWalkArr = new BufferedImage[2];
            upWalkArr[0] = SpriteReader.readSprite(path, 33, 8);
            upWalkArr[1] = SpriteReader.readSprite(path, 34, 8);
            animations.put("upWalk", upWalkArr);
            /* down */
            BufferedImage[] downArr = new BufferedImage[1];
            downArr[0] = SpriteReader.readSprite(path, 29, 8);
            animations.put("down", downArr);
            /* downWalk */
            BufferedImage[] downWalkArr = new BufferedImage[2];
            downWalkArr[0] = SpriteReader.readSprite(path, 31, 8);
            downWalkArr[1] = SpriteReader.readSprite(path, 32, 8);
            animations.put("downWalk", downWalkArr);
            /* left */
            BufferedImage[] leftArr = new BufferedImage[1];
            leftArr[0] = SpriteReader.readSprite(path, 37, 8);
            animations.put("left", leftArr);
            /* leftWalk */
            BufferedImage[] leftWalkArr = new BufferedImage[2];
            leftWalkArr[0] = SpriteReader.readSprite(path, 37, 8);
            leftWalkArr[1] = SpriteReader.readSprite(path, 38, 8);
            animations.put("leftWalk", leftWalkArr);
            /* right */
            BufferedImage[] rightArr = new BufferedImage[1];
            rightArr[0] = SpriteReader.readSprite(path, 35, 8);
            animations.put("right", rightArr);
            /* rightWalk */
            BufferedImage[] rightWalkArr = new BufferedImage[2];
            rightWalkArr[0] = SpriteReader.readSprite(path, 35, 8);
            rightWalkArr[1] = SpriteReader.readSprite(path, 36, 8);
            animations.put("rightWalk", rightWalkArr);
        } catch (IOException e) {
            e.printStackTrace();
    }
}

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        /* Retrieve current image in animation
         * Direction --> what animation cycle
         * spriteNum --> where in animation cycle
         */
        image = animations.get(direction)[spriteNum];
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    public void update() {
        //System.out.println(direction);
        if (!keyH.isIdle()) {
            if (keyH.upPressed) {
                direction = "upWalk";
                worldY -= speed;
            }
            if (keyH.downPressed) {
                direction = "downWalk";
                worldY += speed;
            }
            if (keyH.leftPressed) {
                direction = "leftWalk";
                worldX -= speed;
            }
            if (keyH.rightPressed) {
                direction = "rightWalk";
                worldX += speed;
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