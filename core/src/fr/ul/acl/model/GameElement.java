package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class  GameElement {
	
	private Rectangle bounds;
	private Vector2 position;
	private float speed;
	private TypeElement typeElement;
	private boolean remove;
	
	public enum TypeElement {
        SHIP,
        MISSILE,
        ALIEN,
        BONUS;
	}
	
	public GameElement(Vector2 position, float speed,TypeElement typeElement) {
		this.bounds = new Rectangle(position.x, position.y,1,1);
		this.position = position;
		this.speed = speed;
		this.typeElement = typeElement;
		this.remove = false;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public TypeElement getTypeElement() {
		return typeElement;
	}
	
	public Rectangle getBB() {
		return bounds;
	}
	
	public Boolean isRemove() {
		return this.remove;
	}

	public void setRemove() {
		this.remove = true;
	}
	
	public abstract Texture getTexture();
	public abstract void update(float delta);
    
}
