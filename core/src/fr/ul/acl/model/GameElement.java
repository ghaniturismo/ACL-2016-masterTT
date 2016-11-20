package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;

public abstract class GameElement {
	private float x;
	private float y;
	private World world;

	public GameElement(float x, float y, World w) {
		this.x = x;
		this.y = y;
		this.world = w;
	}

	// recuperer le monde
	public World getWorld() {
		return world;
	}

	// recuperer la valeur de x
	public float getX() {
		return x;
	}

	// maj la valeur de x
	public void setX(float x) {
		this.x = x;
	}

	// recuperer la valeur de y
	public float getY() {
		return y;
	}

	// maj la valeur de y
	public void setY(float y) {
		this.y = y;
	}

	public abstract Texture getTexture();

}
