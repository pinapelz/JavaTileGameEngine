/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jswinggame.entities.statics;

import jswinggame.Handler;
import jswinggame.entities.Entity;

/**
 *
 * @author Pinapelz
 */
public abstract class StaticEntity extends Entity{
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler,x,y,width,height);
        
    }
    
}
