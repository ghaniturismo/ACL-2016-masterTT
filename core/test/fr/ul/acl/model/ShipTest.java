package fr.ul.acl.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class ShipTest {
	private float speed = 20;
	private float delta = (float) 0.017519908;

	// Test le mvt a gauche
	@Test
	public void shipLeft() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		float tmp = ship.getPosition().x - tmp1;
		if (tmp < 0)
			tmp = 0;
		ship.turnLeft(tmp1);
		assertTrue(tmp == ship.getPosition().x);
	}

	// Test le mvt a droite
	@Test
	public void shipRight() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		float tmp = ship.getPosition().x + tmp1;
		if (tmp > w.getWorld_width() - 1)
			tmp = w.getWorld_width() - 1;
		ship.turnRight(tmp1);
		assertTrue(tmp == ship.getPosition().x);
	}

	// Test le mvt a gauche dans le cas ou l'on est au debut de la fenetre (pas
	// de mvt normalement)
	@Test
	public void shipLeft2() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		ship.setPosition(new Vector2(0, ship.getPosition().y));
		ship.turnLeft(tmp1);
		assertTrue(0 == ship.getPosition().x);
	}

	// Test le mvt a droite dans le cas ou l'on est a la fin de la fenetre (pas
	// de mvt normalement)
	@Test
	public void shipRight2() {
		float tmp1 = delta * speed;
		World w = new World();
		float tmp_w = w.getWorld_width();
		Ship ship = w.getSpace();
		ship.setPosition(new Vector2(tmp_w - 1, ship.getPosition().y));
		ship.turnRight(tmp1);
		assertTrue(tmp_w - 1 == ship.getPosition().x);
	}

	// Test le mvt vers le haut
	@Test
	public void shipUp() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		float tmp = ship.getPosition().y + tmp1;
		if (tmp > w.getWorld_height() - 1)
			tmp = w.getWorld_height() - 1;
		ship.turnUp(tmp1);
		assertTrue(tmp == ship.getPosition().y);

	}

	// Test le mvt vers le bas
	@Test
	public void shipDown() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		float tmp = ship.getPosition().y - tmp1;
		if (tmp < 0)
			tmp = 0;
		ship.turnDown(tmp1);
		assertTrue(tmp == ship.getPosition().y);
	}

	// Test le mvt vers le bas dans le cas ou l'on est tous en bas (pas de mvt
	// normalement)
	@Test
	public void shipDown2() {
		float tmp1 = delta * speed;
		World w = new World();
		Ship ship = w.getSpace();
		ship.setPosition(new Vector2(ship.getPosition().x, 0));
		ship.turnDown(tmp1);
		assertTrue(0 == ship.getPosition().y);
	}

	// Test le mvt vers le haut dans le cas ou l'on est tous en haut (pas de mvt
	// normalement)
	@Test
	public void shipUp2() {
		float tmp1 = delta * speed;
		World w = new World();
		float tmp_h = w.getWorld_height();
		Ship ship = w.getSpace();
		ship.setPosition(new Vector2(ship.getPosition().x, tmp_h - 1));
		ship.turnUp(tmp1);
		assertTrue(tmp_h - 1 == ship.getPosition().y);
	}
}
