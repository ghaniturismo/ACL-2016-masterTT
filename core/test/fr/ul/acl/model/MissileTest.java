package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MissileTest {
	
	private float speed;
	private float delta = (float) 0.017519908;

	// Test le nbr de missile crée
	@Test
	public void missileNumber() {
		World w = new World();
		w.addBullet();
		w.addBullet();
		assertTrue(w.getMissiles().size() == 2);
	}
	
	// Test le mvt vers le haut
	@Test
	public void missileMove() {
		World w = new World();
		w.addBullet();
		Missile bullet = w.getMissiles().get(0);
		speed = bullet.getSpeed();
		float tmp = delta * speed;
		float tmp1 = bullet.getPosition().y + tmp;
		bullet.updateMissile(delta);
		assertTrue(tmp1 == bullet.getPosition().y);
	}


}
