package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameElement {
	private float x;
	private float y;
	protected World world;
	private Texture texture;



public GameElement(float x,float y,World w){
	this.x = x;
	this.y = y;
	this.world = w;
}
	
    public World getWorld() {
		return world;
	}

    
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

    public abstract Texture getTexture();

}
