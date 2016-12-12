package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public class Missile extends GameElement {

	public Missile(Vector2 position, float speed) {
		super(position, speed);
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
