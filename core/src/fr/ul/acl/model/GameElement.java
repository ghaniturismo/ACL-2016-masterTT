package fr.ul.acl.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class  GameElement {
	
	private Rectangle bounds;
	private Vector2 position;
	private float speed;
	private boolean remove;
	
	public GameElement(Vector2 position, float speed) {
		this.bounds = new Rectangle(position.x, position.y,1,1);
		this.position = position;
		this.speed = speed;
		this.remove = false;
	}
	
	//permet de recuper la position
	public Vector2 getPosition() {
		return position;
	}

	//maj la position
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	//permet de recuperer la vitesse
	public float getSpeed() {
		return speed;
	}

	//maj la vitesse
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	//permet de recuperer la boundingbox
	public Rectangle getBB() {
		return bounds;
	}
	
	public Boolean isRemove() {
		return this.remove;
	}

	public void setRemove() {
		this.remove = true;
	}
	
	//fct de maj des position...
	public abstract void update(float delta);
    
}
