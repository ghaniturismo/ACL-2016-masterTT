package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.TextureFactory;

public class Missile extends GameMoveableElement{
	
	private float speedMissile = 15;
	private boolean remove = false;

    public Missile(Vector2 position, World world) {
        super(position, world);
    }

	@Override
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureBullet();
	}
	
	// maj la position du missile.
	public void updateMissile(float delta) {
		float tmp = delta * speedMissile ;
		this.getPosition().y= this.getPosition().y + tmp;
		if(this.getPosition().y > getWorld().getWorld_width())
			this.remove = true;
		
	}
	
	public boolean isRemove(){
		return this.remove;
	}

}
