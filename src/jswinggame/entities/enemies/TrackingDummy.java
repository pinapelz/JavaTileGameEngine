/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.enemies;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import jswinggame.Handler;
import jswinggame.entities.Entity;
import jswinggame.entities.creatures.Creature;

/**
 *
 * @author Pinapelz
 */
public class TrackingDummy extends Creature {

    //private static Handler handler;
    

    private static boolean moveLeft = true;
    private static int speed = 1;
    
    private static boolean moveRight = false;

    public TrackingDummy(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 16;
        isDangerous = true;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 32;
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {
        botInput();
        

    }

    @Override
    public boolean checkEntityCollisions(float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {

                return true;
            }

        }
        return false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.dummy, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    public void botInput() {
        if (moveLeft == true) {
            xMove = -speed;
        }
        if (checkEntityCollisions(xMove, 0f)) {
           handler.getWorld().getEntityManager().getPlayer().setX(100);
           handler.getWorld().getEntityManager().getPlayer().setY(100);
       
        }
        if (checkEntityCollisions(0f, yMove)) {
            handler.getWorld().getEntityManager().getPlayer().setX(100);
           handler.getWorld().getEntityManager().getPlayer().setY(100);
        } else if (moveRight == true) {
            xMove = speed;

        }

        move();
     

    }

}
