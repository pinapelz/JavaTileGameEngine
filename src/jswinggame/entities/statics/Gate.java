/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.statics;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import jswinggame.Handler;
import jswinggame.item.Item;
import tiles.Tile;

/**
 *
 * @author Pinapelz
 */
public class Gate extends StaticEntity {

    private static Handler handler;

    public Gate(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        this.setHealth(999999999);
        this.handler = handler;
        //1.5
    }

    @Override
    public void tick() {

    }

    @Override
    public void hurt(int damage) {
        try {
            System.out.println(handler.getWorld().getEntityManager().getPlayer().getInventory().getItem(0));
        } catch (Exception e) {

        }
        //}
    }

    public void setBounds(int x, int y, int width, int height) {
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gate, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        /*   g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
    }

    @Override
    public void die() {

    }
}
