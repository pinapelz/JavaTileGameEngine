/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.creatures;

import gfx.Animation;
import gfx.Assets;
import gfx.TextAnimation;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import jswinggame.Game;
import jswinggame.Handler;
import jswinggame.entities.Entity;
import jswinggame.inventory.Inventory;

/**
 *
 * @author donal
 */
public class Player extends Creature {

    private boolean playingHitSound = false;
    private Inventory inventory;
    private int attack = 1;
    private int attackPower = 5;
    private Animation animDown, animUp, animLeft, animRight, animidle;
    private Animation anim_attack_left, anim_attack_right, anim_attack_up, anim_attack_down;
    private boolean left_attack, right_attack, up_attack, down_attack;
    private boolean hit = false;
    private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 15;
        bounds.y = 15;
        bounds.width = 34;
        bounds.height = 35;
        anim_attack_up = new Animation(50, Assets.player_attack_up);
        anim_attack_left = new Animation(50, Assets.player_attack_left);
        anim_attack_down = new Animation(50, Assets.player_attack_down);
        anim_attack_right = new Animation(50, Assets.player_attack_right);
        animidle = new Animation(200, Assets.player_idle);
        animDown = new Animation(300, Assets.player_down);
        animUp = new Animation(300, Assets.player_up);
        inventory = new Inventory(handler);
        animLeft = new Animation(300, Assets.player_left);
        animRight = new Animation(300, Assets.player_right);

    }

    @Override
    public void tick() {

        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        getInput();
        move();
        checkAttacks();
        handler.getGameCamera().centerOnEntity(this);
        inventory.tick();

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

    private void checkAttacks() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }
        if (inventory.isActive()) {
            return;
        }
        
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().up) {
                
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
            up_attack = true;
            hit = false;
        } else if (handler.getKeyManager().down) {
           
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            down_attack = true;
            hit = false;
        } else if (handler.getKeyManager().left) {
         
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            left_attack = true;
            hit = false;
        } else if (handler.getKeyManager().right) {
           
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            right_attack = true;
            hit = false;
        } else {
            left_attack = false;
            right_attack = false;
            down_attack = false;
            up_attack = false;
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {

                if (e.equals(this)) {

                } else {
                    hit = true;
                    
                    e.hurt(attack);
                    
                }
             
                return;

            }
        }

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

    @Override
    public void die() {
        System.out.println("You lose");
    }

    private void getInput() {

        xMove = 0;
        yMove = 0;
        if (inventory.isActive() == true) {
            return;
        }
        if (handler.getKeyManager().w) {
            yMove = -speed;
        }
        if (handler.getKeyManager().s) {
            yMove = speed;
        }
        if (handler.getKeyManager().a) {
            xMove = -speed;
        }
        if (handler.getKeyManager().d) {
            xMove = speed;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void render(Graphics g) {
      
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.YELLOW);
       g.setFont(new Font("Arial", Font.BOLD, 13));
        g.drawString("X: " + this.getX() + " Y: " + this.getY(), 0, 30);

    }

    public void postRender(Graphics g) {
        inventory.render(g);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
              
            return animLeft.getCurrentFrame();
        }
        else if (left_attack && hit) {
            
       
            return anim_attack_left.getCurrentFrame();

        } else if (right_attack && hit) {

            return anim_attack_right.getCurrentFrame();
        } else if (down_attack && hit) {
            
            return anim_attack_down.getCurrentFrame();
        } else if (up_attack && hit) {
            
            
            return anim_attack_up.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {
            return animDown.getCurrentFrame();
        } else {
            return animidle.getCurrentFrame();
        }

    }

}
