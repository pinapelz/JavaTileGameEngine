/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.states;


import java.awt.Graphics;
import jswinggame.Game;
import jswinggame.Handler;


/**
 *
 * @author donal
 */
public class GameState extends State {


 //   private Player player;
    
    public GameState(Handler handler) {
        super(handler);
    


       // player = new Player(handler, 100, 100);

    }

    @Override
    public void tick() {
     
     //   player.tick();
     

    }

    @Override
    public void render(Graphics g) {
       
        //player.render(g);

    }

}
