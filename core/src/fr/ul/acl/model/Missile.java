package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Missile extends GameMoveableElement{
	
	private Rectangle bounds = new Rectangle();
	public static final float SIZE[] = {3,10}; // Demi unit�

    public Missile(Vector2 position, World world) {
        super(position, world);
        this.bounds.width = SIZE[0];
        this.bounds.height = SIZE[1];
    }
    
    public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return null;
	}


}
