/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.states;

import gfx.Animation;
import gfx.Assets;
import static gfx.Assets.font28;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import jswinggame.ui.ClickListener;
import jswinggame.Game;
import jswinggame.Handler;
import jswinggame.ui.UIImageButton;
import jswinggame.ui.UIManager;

/**
 *
 * @author donal
 */
public class MenuState extends State {

    private UIManager uiManager;
    private Animation buttonAnim;
    public MenuState(Handler handler) {
        super(handler);
        
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
       buttonAnim =  new Animation(150,Assets.btn_start);
        uiManager.addObject(new UIImageButton(285, 350, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
      
        buttonAnim.tick();
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        g.setColor(Color.WHITE);
        g.setFont(font28);
        g.drawString("An Actually Generic", 110, 100);
        g.drawString("Adventure Game", 170, 140);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("A Java Game Engine Technical Test",150,230);
        uiManager.render(g);
        g.drawImage(buttonAnim.getCurrentFrame(), 285, 350,128,64,null);
        
        //Stripped Down UI 
        /*   g.fillRect(196, 235, 300, 100);
        g.setFont(new Font("Arial",Font.BOLD,30));
        g.setColor(Color.black);
        g.drawString("Start Game", 265, 290);
        g.setColor(Color.white);
        g.fillRect(196, 375, 300, 100);
        g.setColor(Color.red);
        g.drawString("Settings", 280, 430);*/
 /*  g.setColor(Color.red);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
         */
    }

}
