package entity;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.awt.Rectangle;

public class Entity {
    public int worldX, worldY;
    public int speed;

    /* each entity will have a map dictating their animation cycles
     * for example: a single entity can have
     * "idle": BufferedImage[idle1, idle2...]
     * "left": BufferedImage[leftIdle1, leftIdle2...]
     * "leftWalk": etc
     */
    public HashMap<String, BufferedImage[]> animations;
    public String direction;

    public int spriteNum = 0;
    public int spriteCounter = 0;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}