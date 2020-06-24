/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gfx.Assets;

/**
 *
 * @author Pinapelz
 */
public class RockWall extends Tile{
    public RockWall(int id){
       super(Assets.stone,id);
    }
    
    @Override
    public boolean isSolid(){
        return true;
    }
    
}
