package fr.ul.acl.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class AlienTest {
	private float speed;
	private Ship ship;
	private ArrayList<Alien>  aliens;
	private ArrayList<Missile>  missiles;
	private World w;
	private boolean res;


	@Test
	public void AlienGoDown() {
		/*World world = new World();
		Alien alien = world.getAliens();
		speed = alien.getSpeed();
		float tmp = speed * delta;
		float tmp1 = alien.getPosition().y - tmp;
		alien.updateAlien(delta);
		float y = alien.getPosition().y;
		assertTrue( tmp1 == y );*/
	}
	
	@Test
	public void AlienCollisonShip() {
		this.w = new World();
		this.ship = w.getSpace();
		this.w.addAlien(0.6f);
		
		this.aliens = w.getAliens();
		for(Alien alien : aliens){
			Vector2 tmp =  ship.getPosition();
			alien.setPosition(tmp);		
			this.res = ship.hasCollisions(alien);

		}
		assertFalse(res);
	}

	@Test
	public void AlienCollisonBullet() {
		this.w = new World();
		this.ship = w.getSpace();
		this.missiles = w.getMissiles();
		this.w.addAlien(0.6f);
		this.w.addBullet();
		
		this.aliens = w.getAliens();
		for(Alien alien : aliens){
			for(Missile missile : missiles){
			Vector2 tmp =  missile.getPosition();
			alien.setPosition(tmp);		
			this.res = missile.hasCollisions(alien);
			
		}
		assertFalse(res);
	}
	}
}
