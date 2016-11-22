package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.TextureFactory;

public class Missile extends GameMoveableElement{
	

    public Missile(Vector2 position, World world) {
        super(position, world);
    }

	@Override
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureBullet();
	}


}
