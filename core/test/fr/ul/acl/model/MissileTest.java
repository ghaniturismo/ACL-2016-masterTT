package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class MissileTest {
	
	private float speed;
	private float delta = (float) 0.017519908;

	// Test le nbr de missile cree
	@Test
	public void missileNumber() {
		World w = new World();
		w.shoot();
		w.shoot();
		Ship s = w.getShip();
		assertTrue(s.getListeMissiles().size() == 2);
	}
	
	// Test le mvt vers le haut des tirs de la fusee
	@Test
	public void missileMove() {
		World w = new World();
		Ship ship = w.getShip();
		Missile bullet = new Missile(new Vector2(0,0),30, true,null);
		ArrayList<Missile> listeMissiles = new ArrayList<Missile>();
		listeMissiles.add(bullet);
		ship.setListeMissiles(listeMissiles);
		speed = bullet.getSpeed();
		float tmp = delta * speed;
		float tmp1 = bullet.getPosition().y + tmp;
		bullet.update(delta);
		assertTrue(tmp1 == bullet.getPosition().y);
	}


}
