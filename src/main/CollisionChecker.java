package main;

import entity.Entity;

public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "upWalk":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.map[entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.map[entityRightCol][entityTopRow];
                if (gp.tm.tiles[tileNum1].collision || gp.tm.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "downWalk":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.map[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tm.map[entityRightCol][entityBottomRow];
                if (gp.tm.tiles[tileNum1].collision || gp.tm.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "leftWalk":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.map[entityLeftCol][entityTopRow];
                tileNum2 = gp.tm.map[entityLeftCol][entityBottomRow];
                if (gp.tm.tiles[tileNum1].collision || gp.tm.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "rightWalk":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tm.map[entityRightCol][entityTopRow];
                tileNum2 = gp.tm.map[entityRightCol][entityBottomRow];
                if (gp.tm.tiles[tileNum1].collision || gp.tm.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }

    }

}
