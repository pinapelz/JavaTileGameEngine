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
public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
        bounds.x = 10;
        bounds.y = (int) (height / 1.5);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5);

    }

    @Override
    public void tick() {

    }
    @Override
    public void die() {
        handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        /* g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
    }
}
