package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlienTest {
	private float speed;
	private float delta = (float) 0.017519908;

	@Test
	public void AlienGoDown() {
		World world = new World();
		Alien alien = world.getAlien();
		speed = alien.getSpeed();
		float tmp = speed * delta;
		float tmp1 = alien.getPosition().y - tmp;
		alien.updateAlien(delta);
		float y = alien.getPosition().y;
		assertTrue( tmp1 == y );
	}

}
