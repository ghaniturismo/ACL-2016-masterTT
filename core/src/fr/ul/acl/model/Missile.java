package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public class Missile extends GameElement {
	
	private boolean parent; // false = alien shoot | true = ship shoot
	private double angle;

	public Missile(Vector2 position, float speed, boolean parent, Vector2 positionShip) {
		super(position, speed);
		this.parent = parent;
		if(!parent)
			angle = Math.atan2(position.y - positionShip.y, position.x - positionShip.x);
	}
	
	//maj des missiles
	@Override
	public void update(float delta) {
		float tmp = delta * getSpeed();
		if(parent){ // si le missile provient du vaisseau
			this.getPosition().y += tmp;
			if (this.getPosition().y > World.world_size[0])
				this.setRemove();
		}else{ // sinon il provient d'un alien
			this.getPosition().x -= (float) getSpeed() * delta * Math.cos(angle);
			this.getPosition().y -= (float) getSpeed() * delta * Math.sin(angle);
			this.getBB().x = getPosition().x;
			if (this.getPosition().y < 0)
				this.setRemove();
		}
		this.getBB().y = this.getPosition().y;
	}
	
	
}
