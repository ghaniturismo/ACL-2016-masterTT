package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by ghaniturismo on 20/11/16.
 */
public class Alien extends GameElement {

	public Alien(Vector2 position, float speed,TypeElement typeElement) {
		super(position, speed, typeElement);
	}
	
	@Override
	// recupere la texture d'un vaisseau
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureAlien();
	}
	
	@Override
	public void update(float delta) {
		float tmp = delta * this.getSpeed();
		this.getPosition().y -= tmp;
		this.getBB().y = getPosition().y;
		if (this.getPosition().y < 0)
			this.setRemove();
	}

}
