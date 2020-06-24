/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import jswinggame.Game;
import jswinggame.Handler;
import jswinggame.entities.Entity;
import tiles.Tile;

/**
 *
 * @author Pinapelz
 */
public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
                checkForBorder();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
                checkForBorder();
	}
        public void checkForBorder(){
            if(xOffset<0){
                xOffset = 0;
            }
            else if(xOffset>handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth()){
                xOffset = handler.getWorld().getWidth()*Tile.TILEWIDTH-handler.getWidth();
            }
            if(yOffset <0){
                yOffset = 0;
            }
            else if(yOffset>handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight()){
                yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT-handler.getHeight();
            }
        }

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
