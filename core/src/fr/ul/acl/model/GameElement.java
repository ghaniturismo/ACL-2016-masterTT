package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	private Vector2 position;
	private World world;

	public GameElement(Vector2 position, World w) {
		this.position = position;
		this.world = w;
	}

	// recuperer le monde
	public World getWorld() {
		return world;
	}

	public Vector2 getPosition(){
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public abstract Texture getTexture();

}
