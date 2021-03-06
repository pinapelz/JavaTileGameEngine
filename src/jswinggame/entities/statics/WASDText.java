/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.statics;

import gfx.Assets;
import java.awt.Graphics;
import jswinggame.Handler;
import jswinggame.item.Item;
import tiles.Tile;

/**
 *
 * @author Pinapelz
 */
public class WASDText extends StaticEntity{
    public WASDText(Handler handler, float x, float y){
        super(handler,x,y,Tile.TILEWIDTH*3, Tile.TILEHEIGHT*2);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;
    }
    @Override
    public void tick(){
        
    }
        public void die(){
         handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)x,(int)y));
  
    }
    @Override
    public void render(Graphics g){
        g.drawImage(Assets.textWASD,(int) (x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height,null);

       /*   g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
    }
}
