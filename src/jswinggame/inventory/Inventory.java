/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.inventory;

import gfx.Assets;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import jswinggame.Handler;
import jswinggame.item.Item;

/**
 *
 * @author Pinapelz
 */
public class Inventory {

    private Handler handler;
    private boolean active = false;
     int inventoryLength = 0;
    private int invX = 80, invY =  120, invWidth = 512, invHeight = 384
            ,invListCenterX = invX+171,invListCenterY = invY + invHeight /2 +5;
    private ArrayList<Item> inventoryItems;
private int invDescX = 440, invDescY = 300;
    private int invListSpacing = 30;
    private int invImageX = 470, invImageY = 150,invImageWidth = 64, invImageHeight = 64;
    private int selectedItem  = 0;
    	private int invCountX = 500, invCountY = 245;
    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }
    
    public void addItem(Item item){
       for (Item i : inventoryItems) {
            if(i.getId()==item.getId()){
                i.setCount(i.getCount()+item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }

    public boolean isActive() {
        return active;
    }
    public int getItem(int id){
        return inventoryItems.get(id).getCount();
    }

    public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W))
			selectedItem--;
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S))
			selectedItem++;
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
    }

    public void render(Graphics g) {
		if(!active)
			return;
		
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		for(int i = -5;i < 6;i++){
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0){
				Text.drawString(g, "- " + inventoryItems.get(selectedItem + i).getName() + " -", invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			}else{
				Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
                g.setColor(Color.white);
                g.setFont(Assets.gbFont13);
                g.drawString(inventoryItems.get(selectedItem).getDescription(), invDescX, invDescY);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
    }
}
