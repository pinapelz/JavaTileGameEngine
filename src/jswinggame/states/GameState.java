/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.states;

import gfx.Assets;
import java.awt.Graphics;
import jswinggame.Game;
import jswinggame.Handler;
import jswinggame.entities.creatures.Player;
import jswinggame.entities.statics.Tree;
import tiles.Tile; 
import worlds.TutorialWorld;
import worlds.World;

/**
 *
 * @author donal
 */
public class GameState extends State {

    private World world;
    private Player player;

    public GameState(Handler handler) {
        super(handler);
        world = new TutorialWorld(handler, "res/worlds/tutorial.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100);

    }

    @Override
    public void tick() {
        player.tick();
        world.tick();

    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        //player.render(g);

    }

}
