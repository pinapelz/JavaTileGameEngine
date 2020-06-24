/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author donal
 */
public class SpriteSheet {
    private BufferedImage spritesheet;
    
    public SpriteSheet(BufferedImage sheet){
        spritesheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height){
        return spritesheet.getSubimage(x, y, width, height);
    }
    
}
