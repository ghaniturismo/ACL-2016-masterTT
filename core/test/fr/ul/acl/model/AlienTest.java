package fr.ul.acl.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.model.GameElement.TypeElement;

public class AlienTest {
	private float speed;
	private float delta = (float) 0.017519908;


	@Test
	//on verifie si le déplacement vers le bas se fait correctement
	public void AlienGoDown() {
		World world = new World();
		Alien a = new Alien(new Vector2(0,world.world_size[1]-1),10, TypeElement.ALIEN);
		ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
		gameElements.add(a);
		world.setGameElements(gameElements);
		speed = a.getSpeed();
		float tmp = speed * delta;
		float tmp1 = a.getPosition().y - tmp;
		a.update(delta);
		float y = a.getPosition().y;
		assertTrue( tmp1 == y );
	}
	
	@Test
	// on verifie si y'a bien la détection de la collision entre l'alien et bullet et la maj du score
	public void AlienCollisonBullet() {
		World world = new World();
		Alien a = new Alien(new Vector2(0,world.world_size[1]-1),10, TypeElement.ALIEN);
		Missile m = new Missile(new Vector2(0,world.world_size[1]-1), 30, TypeElement.MISSILE);
		ArrayList<GameElement> gameElements = new ArrayList<GameElement>();
		gameElements.add(a);
		gameElements.add(m);
		world.setGameElements(gameElements);
		int tmp = world.getScore();
		world.update(delta);
		assertTrue(world.getScore() == tmp+100);
	}
	
}
