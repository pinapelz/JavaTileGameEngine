/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.enemies;

import java.awt.image.BufferedImage;
import jswinggame.Handler;
import jswinggame.entities.Entity;

/**
 *
 * @author Pinapelz
 */
public class Enemy{
    private static int health = 10;
    private static int attack = 3;
    private static String name;
    private static BufferedImage enemyGFX;         
    private static Handler handler;
    public Enemy(Handler handler,String name, BufferedImage enemyGFX){
        this.handler = handler;
        this.enemyGFX = enemyGFX;
        this.name = name;
    }

    public static int getHealth() {
        return health;
    }
   
    public static void setHealth(int health) {
        Enemy.health = health;
    }

    public static int getAttack() {
        return attack;
    }

    public static void setAttack(int attack) {
        Enemy.attack = attack;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static void setHandler(Handler handler) {
        Enemy.handler = handler;
    }
    
    
}
