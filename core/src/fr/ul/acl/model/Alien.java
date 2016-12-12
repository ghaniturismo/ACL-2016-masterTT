package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public class Alien extends GameElement {
	
	private float countShootAlien = 0;
	private boolean shootAlien = false;

	public Alien(Vector2 position, float speed) {
		super(position, speed);
	}
	
	public boolean isShootAlien(){
		return this.shootAlien;
	}
	
	public void setShootAlien(){
		this.shootAlien = false;
	}
	
	@Override
	public void update(float delta) {
		float tmp = delta * this.getSpeed();
		this.getPosition().y -= tmp;
		this.getBB().y = getPosition().y;
		if (this.getPosition().y < 0){
			this.setRemove();
		}
		countShootAlien += delta;
		if (countShootAlien > 1f) {
			this.shootAlien = true;
			this.countShootAlien = 0;
		}
	}

}
