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
public class OneDDummy extends Creature {

    //private static Handler handler;
    private static boolean moveLeft = true;
    private static int speed = 1;
    private float stopOne, stopTwo;
    private int direction = 0;
    boolean moveRight = false;
    boolean moveLet = false;
    boolean moveUp = false;
    boolean moveDown = false;

    /*
    0 = Move along X and left first
    1 = Move along X and right first
    2 = Move along Y and up first
    3 = Move along Y and down first
     */
    public OneDDummy(Handler handler, float x, float y, int direction, float stopOne, float stopTwo) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        isDangerous = true;
        this.direction = direction;
        this.stopOne = stopOne;
        this.stopTwo = stopTwo;
        bounds.x = 7;
        bounds.y = 20;
        bounds.width = 43;
        bounds.height = 36;
        if (direction == 0) {
            moveLeft = true;
            moveRight = false;
        } else if (direction == 1) {
            moveLeft = false;
            moveRight = true;
        } else if (direction == 2) {
            moveUp = true;
            moveDown = false;
        } else if (direction == 3) {
            moveUp = false;
            moveDown = true;
        }
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

      /*  g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
                bounds.width, bounds.height);*/

    }

    public void botInput() {

        if (checkEntityCollisions(xMove, 0f)) {
            handler.getWorld().getEntityManager().getPlayer().setX(100);
            handler.getWorld().getEntityManager().getPlayer().setY(100);

        }
        if (checkEntityCollisions(0f, yMove)) {
        
            handler.getWorld().getEntityManager().getPlayer().setX(100);
            handler.getWorld().getEntityManager().getPlayer().setY(100);
        }
        if (direction == 0) {
         
            if (moveLeft == true) {
                xMove = -speed;
            } else if (moveRight == true) {
                xMove = speed;
            }
            if (this.getX() == stopOne) {
                moveLeft = false;
                moveRight = true;

            } else if (this.getX() == stopTwo) {
        
                moveLeft = true;
                moveRight = false;
            }
        } else if (direction == 1) {

            if (moveLeft == true) {
                xMove = -speed;
            } else if (moveRight == true) {
                xMove = speed;
            }
            if (this.getX() == stopOne) {
                moveRight = false;
                moveLeft = true;

            } else if (this.getX() == stopTwo) {
                moveRight = true;
                moveLeft = false;
            }
        } else if (direction == 2) {
            if (moveUp == true) {
                yMove = -speed;
            } else if (moveDown == true) {
                yMove = speed;
            }
            if (this.getY() == stopOne) {
                moveDown = true;
                moveUp = false;

            } else if (this.getY() == stopTwo) {
                moveUp = true;
                moveDown = false;
            }
        } else if (direction == 3) {
            if (moveUp == true) {
                yMove = -speed;
            } else if (moveDown == true) {
                yMove = speed;
            }
            if (this.getY() == stopOne) {
                moveDown = false;
                moveUp = true;

            } else if (this.getY() == stopTwo) {
                moveUp = false;
                moveDown = true;
            }
        }

        if (this.getX() == 496.0f) {
            moveLeft = false;
            moveRight = true;
        } else if (this.getX() == 719.0f) {
            moveRight = false;
            moveLeft = true;
        }
        move();

    }

}
