package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	private Vector2 position;
	private World world;
	private float speed;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public GameElement(Vector2 position, float s, World w) {
		this.position = position;
		this.world = w;
		this.speed = s;
	}

	// recuperer le monde
	public World getWorld() {
		return world;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	 //test la collision
    public boolean hasCollisions(GameElement ge){
        Rectangle bbox = ge.getBB();
        return this.getBB().overlaps(bbox);
    }
    
    public abstract Rectangle getBB();
    
	public abstract Texture getTexture();

}
