/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.item;

import gfx.Assets;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import jswinggame.Handler;

/**
 *
 * @author Pinapelz
 */
public class Item {
    
    public static Item[] items =  new Item[256];
    public static Item woodItem =  new Item(Assets.wood,"Wood",0,"");
    public static Item rockItem = new Item(Assets.rock_item,"Rock",1,"");
    protected Rectangle bounds;
    
    public static String description;
    public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    protected int x,y,count;
    protected boolean pickedUp = false;
    public Item(BufferedImage texture, String name, int id, String description){
        this.texture = texture;
        this.description = description;
        this.name = name;
        this.id = id;
        count = 1;
        bounds = new Rectangle(x,y,ITEMWIDTH,ITEMHEIGHT);
        items[id] = this;
    }
    public void tick(){
        if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f,0f).intersects(bounds)){
            pickedUp = true;
            handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT,null);
    }
    public void render(Graphics g){
        if(handler == null){
            return;
        }
        render(g,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()));
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Item.description = description;
    }

    public int getCount() {
        return count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    public int getId() {
        return id;
    }
    

    public void setCount(int count) {
        this.count = count;
    }
    public Item createNew(int x, int y){
        Item i = new Item(texture,name,id,description);
        i.setPosition(x, y);
        return i;
    }
        public Item createNew(int count){
        Item i = new Item(texture,name,id,description);
        i.setPickedUp(true);
        i.setCount(count);
        return i;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x  =x;
        bounds.y = y;
    }
    
}
