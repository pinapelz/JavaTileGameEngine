/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worlds;

import gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import jswinggame.Handler;
import jswinggame.entities.EntityManager;
import jswinggame.entities.creatures.Player;
import jswinggame.entities.statics.ArrowsText;
import jswinggame.entities.statics.Gate;
import jswinggame.entities.statics.InventoryText;
import jswinggame.entities.statics.Rock;
import jswinggame.entities.statics.Tree;
import jswinggame.entities.statics.WASDText;
import jswinggame.item.ItemManager;
import tiles.Tile;
import utils.Utils;

/**
 *
 * @author Pinapelz
 */
public class TutorialWorld extends World{

	public Handler handler;
        boolean alreadyRendered = false;
	private int width, height;
	private int spawnX, spawnY;
        private ItemManager itemManager;
	private int[][] tiles;
	//Entities
	private EntityManager entityManager;
	
	public TutorialWorld(Handler handler, String path){
            super(handler,path);
		this.handler = handler;
                itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
                entityManager.addEntity(new WASDText(handler,100,100));
                entityManager.addEntity(new ArrowsText(handler,725,100));
                entityManager.addEntity(new InventoryText(handler,1000,600));
                entityManager.addEntity(new Tree(handler,524,358));
                entityManager.addEntity(new Rock(handler,776,235));
                entityManager.addEntity(new Gate(handler,1283,319));
                entityManager.addEntity(new Gate(handler,1283,390));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	public void tick(){
                    
		entityManager.tick();
                itemManager.tick();
	}
	
	public void render(Graphics g){
       
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
                itemManager.render(g);
		entityManager.render(g);
                if(!alreadyRendered){
                    renderText(g);
                    alreadyRendered = true;
                }
                     
	}
	private void renderText(Graphics g){
            g.setFont(Assets.font28);
            g.setColor(Color.YELLOW);
            g.drawString("Use WASD to move", 100, 100);
        }
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	public void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }    
}
