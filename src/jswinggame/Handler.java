package jswinggame;


import Input.KeyManager;
import Input.MouseManager;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pinapelz
 */
public class Handler {
    private Game game;

    
    
    
    public Handler(Game game){
        this.game = game;
    }


    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public Game getGame() {
        return game;
    }
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public void setGame(Game game) {
        this.game = game;
    }


    
}
