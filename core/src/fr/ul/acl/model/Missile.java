package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.TextureFactory;

public class Missile extends GameElement {

	public Missile(Vector2 position, float speed,TypeElement typeElement) {
		super(position, speed, typeElement);
	}
	
	@Override
	// recupere la texture d'un vaisseau
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureBullet();
	}
	
	@Override
	public void update(float delta) {
		float tmp = delta * getSpeed();
		this.getPosition().y += tmp;
		this.getBB().y = this.getPosition().y;
		if (this.getPosition().y > World.world_size[0])
			this.setRemove();
	}
	
	
}
