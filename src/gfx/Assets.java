/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfx;

import gfx.fonts.FontLoader;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author donal
 */
public class Assets {

    public static BufferedImage player, bush, grass, stone, tree, dummy, wood, inventoryScreen, rock, rock_item,pebble_path,gate;
    public static BufferedImage[] player_down, player_up, player_left, player_right, player_idle;
    public static BufferedImage[] player_attack_left, player_attack_right, player_attack_up, player_attack_down;
    public static String hitSound;
    public static BufferedImage[] btn_attack, btn_defend;
    public static BufferedImage textWASD, textArrows, textInventory;
    public static BufferedImage[] btn_start;
    private static final int width = 31, height = 31;
    public static Font font28;
    public static Font gbFont13;
    //81
    private static final int btnwidth = 81, btnheight = 51;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet startbtnsheet = new SpriteSheet(ImageLoader.loadImage("/textures/startbtnsheet.png"));
        inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
        
        player_down = new BufferedImage[4];
        player_idle = new BufferedImage[1];
        player_attack_left = new BufferedImage[1];
        btn_defend  = new BufferedImage[2];
        btn_attack = new BufferedImage[2];
        player_attack_down = new BufferedImage[1];
        player_attack_up = new BufferedImage[1];
        btn_start = new BufferedImage[12];
        player_up = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_attack_right = new BufferedImage[1];
        player_right = new BufferedImage[4];
        // player_down[0] = sheet.crop((width*2)+4,(height*2)+4,(width)-1,(height)-1);
        player_down[0] = sheet.crop((width * 4) + 5, (height * 3) + 4, width, height - 1);
        player_down[1] = sheet.crop((width * 5) + 6, (height * 3) + 4, width, height - 1);
        player_down[2] = sheet.crop((width * 6) + 7, (height * 3) + 4, width, height - 1);
        player_down[3] = sheet.crop((width * 7) + 8, (height * 3) + 4, width, height - 1);
        player_attack_down[0] = sheet.crop((width * 2) + 3, (height * 4) + 4, width, height - 1);
        // player_up[0] = sheet.crop((width*3)+4,(height*2)+3,width,height);
        player_up[0] = sheet.crop((width * 4) + 5, (height * 4) + 4, width, height - 1);
        player_up[1] = sheet.crop((width * 5) + 6, (height * 4) + 4, width, height - 1);
        player_up[2] = sheet.crop((width * 6) + 7, (height * 4) + 4, width, height - 1);
        player_up[3] = sheet.crop((width * 7) + 8, (height * 4) + 4, width, height - 1);
        player_attack_up[0] = sheet.crop((width * 7) + 8, (height * 4) + 4, width, height - 1);
        player_left[0] = sheet.crop((width * 4) + 5, (height * 5) + 4, width, height - 1);
        player_left[1] = sheet.crop((width * 5) + 6, (height * 5) + 4, width, height - 1);
        player_left[2] = sheet.crop((width * 6) + 7, (height * 5) + 4, width, height - 1);
        textWASD = sheet.crop((width*6)+7,1,width*3,(height*2)-1);
        textArrows = sheet.crop((width*8)+9,(height*2)+3,width*4,(height*2)-1);
        player_left[3] = sheet.crop((width * 7) + 8, (height * 5) + 4, width, height - 1);
        font28 = FontLoader.loadFont("res/fonts/Early GameBoy.ttf", 28);
        gbFont13 = FontLoader.loadFont("res/fonts/Early Gameboy.ttf", 13);
        player_attack_left[0] = sheet.crop((width * 3) + 4, (height * 4) + 4, width, height - 1);
        // player_attack_left[1]=  sheet.crop((width*7)+8,(height*4)+4,width,height-1);
        player_right[0] = sheet.crop((width * 4) + 5, (height * 6) + 4, width, height - 1);
        player_right[1] = sheet.crop((width * 5) + 6, (height * 6) + 4, width, height - 1);
        player_right[2] = sheet.crop((width * 6) + 7, (height * 6) + 4, width, height - 1);
        player_right[3] = sheet.crop((width * 7) + 8, (height * 6) + 4, width, height - 1);
        pebble_path = sheet.crop((width*2)+3, height*2+3, width+1, height);
        player_attack_right[0] = sheet.crop((width * 3) + 4, (height * 5) + 4, width, height - 1);
        /*player_left[0] = sheet.crop((width*3)+4,(height)+2,width,height);
        player_right[0] = sheet.crop((width*2)+4,(height)+2,width-1,height);*/
        player_idle[0] = sheet.crop((width * 4) + 5, (height * 3) + 4, width, height - 1);
        /* btn_start[0] = sheet.crop((width*4)+5,(height*2)+4,width*2,height);
        btn_start[1] = sheet.crop((width*6)+5,(height*2)+4,width*2+2,height);  */
        btn_start[0] = startbtnsheet.crop(1, 1, btnwidth, btnheight);
        btn_start[1] = startbtnsheet.crop(btnwidth + 2, 1, btnwidth, btnheight);
        btn_start[2] = startbtnsheet.crop((btnwidth * 2) + 3, 1, btnwidth, btnheight);
        btn_start[3] = startbtnsheet.crop((btnwidth * 3) + 4, 1, btnwidth, btnheight);
        btn_start[4] = startbtnsheet.crop(1, btnheight + 1, btnwidth, btnheight);
        btn_start[5] = startbtnsheet.crop(btnwidth + 2, btnheight + 1, btnwidth, btnheight);
        btn_start[6] = startbtnsheet.crop((btnwidth * 2) + 3, btnheight + 1, btnwidth, btnheight);
        btn_start[7] = startbtnsheet.crop((btnwidth * 3) + 4, btnheight + 1, btnwidth, btnheight);
        btn_start[8] = startbtnsheet.crop((btnwidth * 4) + 5, btnheight + 1, btnwidth, btnheight);
        btn_start[9] = startbtnsheet.crop((btnwidth * 4) + 5, btnheight + 1, btnwidth, btnheight);
        btn_start[10] = startbtnsheet.crop((btnwidth * 4) + 5, btnheight + 1, btnwidth, btnheight);
        btn_start[11] = startbtnsheet.crop((btnwidth * 4) + 5, btnheight + 1, btnwidth, btnheight);
        wood = sheet.crop(1, 1, width, height);
        player = sheet.crop((width * 2) + 4, (height * 2) + 4, (width) - 1, (height) - 1);
        rock_item = sheet.crop((width * 3) + 5, (height) + 2, width - 1, height);
        stone = sheet.crop(width + 2, 1, width, height);
        rock = sheet.crop((width * 2) + 4, (height) + 2, width - 1, height);
        dummy = sheet.crop((width * 5) + 6, 1, width - 1, height);
        btn_attack[0] = sheet.crop((width * 4) + 6, (height * 2)+2, width * 2 +1, height);
        gate = sheet.crop((width*4)+5, height*2+3, width, height-1);
        btn_attack[1] = btn_attack[0];
        btn_defend[0] = sheet.crop((width*6)+7,(height*2)+3,width*2,height);
        btn_defend[1] = btn_defend[0];
        tree = sheet.crop(1, height + 2, width * 2, height * 3);
        bush = sheet.crop((width * 3) + 4, 1, width, height);
        grass = sheet.crop((width * 2) + 3, 2, width, height - 2);
        hitSound = "res/sounds/hit.wav";
        textInventory = sheet.crop((width*9)+11,1,width*3,height*2);

    }

}
