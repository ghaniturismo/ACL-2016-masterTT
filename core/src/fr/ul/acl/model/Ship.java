package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;

import fr.ul.acl.view.TextureFactory;

public class Ship extends GameMoveableElement{
	public Ship(float x, float y, World world) {
		super(x,y,world);	
	}
	
	public Texture getTexture(){
        return TextureFactory.getInstance().getTextureShip();
    }
	
}


