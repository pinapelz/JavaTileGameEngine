/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gfx.Assets;

import tiles.Tile;

/**
 *
 * @author Pinapelz
 */
public class GrassTile extends Tile{
    public GrassTile(int id){
        super(Assets.grass,id);
    }
    @Override
    public boolean isEncounter(){
        return true;
    }
}
