package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.model.GameElement.TypeElement;

public class MissileTest {
	
	private float speed;
	private float delta = (float) 0.017519908;

	// Test le nbr de missile crée
	@Test
	public void missileNumber() {
		World w = new World();
		w.shoot();
		w.shoot();
		System.out.println(w.getGameElements().size());
		//il y a la fusee dedans + nbre de missile creer
		assertTrue(w.getGameElements().size() == 3);
	}
	
	// Test le mvt vers le haut
	@Test
	public void missileMove() {
		World w = new World();
		World world = new World();
		Missile bullet = new Missile(new Vector2(0,0),30, TypeElement.ALIEN);
		ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
		gameElements.add(bullet);
		world.setGameElements(gameElements);
		speed = bullet.getSpeed();
		float tmp = delta * speed;
		float tmp1 = bullet.getPosition().y + tmp;
		bullet.update(delta);
		assertTrue(tmp1 == bullet.getPosition().y);
	}


}
