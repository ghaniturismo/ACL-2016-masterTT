package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public class Bonus extends GameElement {

	public Bonus(Vector2 position, float speed) {
		super(position, speed);
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
