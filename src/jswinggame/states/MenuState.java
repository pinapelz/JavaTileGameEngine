/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.states;


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

    public MenuState(Handler handler) {
        super(handler);
        
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
      
    }

    @Override
    public void tick() {
      
 
        uiManager.tick();

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, handler.getGame().getWidth(), handler.getGame().getHeight());
        g.setColor(Color.WHITE);
   
        g.drawString("An Actually Generic", 110, 100);
        g.drawString("Adventure Game", 170, 140);
        g.setFont(new Font("Arial",Font.BOLD,25));
        g.drawString("A Java Game Engine Technical Test",150,230);
        uiManager.render(g);
 
        
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
