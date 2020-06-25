/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities;

import gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import jswinggame.Game;
import jswinggame.Handler;

/**
 *
 * @author donal
 */
public abstract class Entity {

    protected float x, y;
    public boolean isDangerous = false;
    protected int health;
    protected boolean active = true;
    public static final int DEFAULT_HEALTH = 10;
    protected Handler handler;
    protected Rectangle bounds;
    public int width, height;
    
    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        health = DEFAULT_HEALTH;
        this.handler = handler;
        this.height = height;
        bounds = new Rectangle(0, 0, width, height);
    }
        public void play(String filename) {
        try {

       
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.setFramePosition(0);

            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }

    public void hurt(int damage){
         play(Assets.hitSound);
        health-=damage;
        if(health<=0){
            active = false;
            die();
        }
    }

    public abstract void die();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public abstract void tick();

    public abstract void render(Graphics g);

    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
