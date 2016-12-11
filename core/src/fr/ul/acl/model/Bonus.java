package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.TextureFactory;

public class Bonus extends GameElement {

	public Bonus(Vector2 position, float speed) {
		super(position, speed);
	}
	
	@Override
	// recupere la texture d'un alien.
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureBonus();
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
