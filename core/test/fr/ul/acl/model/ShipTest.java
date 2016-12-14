package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;


public class ShipTest {
	private float speed;
	private float delta = (float) 0.017519908;

	// Test le mvt a gauche
	// On fait le mvt en dure et avec la fonction et on test si on a le meme resultats a la fin
	@Test
	public void shipLeft() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp = ship.getPosition().x - tmp1;
		if (tmp < 0)
			tmp = 0;
		ship.turnLeft(tmp1);
		assertTrue(tmp == ship.getPosition().x);
	}

	// Test le mvt a droite
	// On fait le mvt en dure et avec la fonction et on test si on a le meme resultats a la fin
	@Test
	public void shipRight() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp = ship.getPosition().x + tmp1;
		if (tmp > w.world_size[0] - 1)
			tmp = w.world_size[0] - 1;
		ship.turnRight(tmp1);
		assertTrue(tmp == ship.getPosition().x);
	}

	// Test le mvt a gauche dans le cas ou l'on est au debut de la fenetre
	// pas de mvt normalement , il doit rester à sa position
	@Test
	public void shipLeft2() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		ship.setPosition(new Vector2(0, ship.getPosition().y));
		ship.turnLeft(tmp1);
		assertTrue(0 == ship.getPosition().x);
	}

	// Test le mvt a droite dans le cas ou l'on est a la fin de la fenetre
	// pas de mvt normalement , il doit rester à sa position
	@Test
	public void shipRight2() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp_w = w.world_size[0];
		ship.setPosition(new Vector2(tmp_w - 1, ship.getPosition().y));
		ship.turnRight(tmp1);
		assertTrue(tmp_w - 1 == ship.getPosition().x);
	}

	// Test le mvt vers le haut
	// On fait le mvt en dure et avec la fonction et on test si on a le meme resultats a la fin
	@Test
	public void shipUp() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp = ship.getPosition().y + tmp1;
		if (tmp > w.world_size[1] - 1)
			tmp = w.world_size[1] - 1;
		ship.turnUp(tmp1);
		assertTrue(tmp == ship.getPosition().y);

	}

	// Test le mvt vers le bas
	// On fait le mvt en dure et avec la fonction et on test si on a le meme resultats a la fin
	@Test
	public void shipDown() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp = ship.getPosition().y - tmp1;
		if (tmp < 0)
			tmp = 0;
		ship.turnDown(tmp1);
		assertTrue(tmp == ship.getPosition().y);
	}

	// Test le mvt vers le bas dans le cas ou l'on est tous en bas
	// pas de mvt normalement , il doit rester à sa position
	@Test
	public void shipDown2() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		ship.setPosition(new Vector2(ship.getPosition().x, 0));
		ship.turnDown(tmp1);
		assertTrue(0 == ship.getPosition().y);
	}

	// Test le mvt vers le haut dans le cas ou l'on est tous en haut 	
	// pas de mvt normalement , il doit rester à sa position
	@Test
	public void shipUp2() {
		World w = new World();
		Ship ship = w.getShip();
		this.speed = ship.getSpeed();
		float tmp1 = delta * speed;
		float tmp_h = w.world_size[1];
		ship.setPosition(new Vector2(ship.getPosition().x, tmp_h - 1));
		ship.turnUp(tmp1);
		assertTrue(tmp_h - 1 == ship.getPosition().y);
	}
	
	// on verifie si y'a bien la détection de la collision entre l'alien et la fusee  et la maj du nbre de vie
	//on recupere la vie avant collision on soustrait 1 et on teste si c'est la meme que celle apres la collison
		@Test
		public void AlienCollisonShip() {
			World w = new World();
			Ship ship = w.getShip();
			Alien a = new Alien(ship.getPosition(),10);
			HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
			ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
	    	listeElement.add(a);
			mapElements.put("Alien",listeElement);
			w.setMapElements(mapElements);
			int tmp = w.getVie()-1;
			w.update(delta);
			assertTrue(tmp==w.getVie());
		}
		
		//on verifie qu on passe a gameover quand le nbre de vie est égale a zero
		@Test
		public void gameOver() {
			World w = new World();
			w.setLife(0);
			assertTrue(w.isGameOver());		
		}
		
		//on verifie qu on met bien à jour le level quand on atteint 1000 points
		public void addScore() {
			World w = new World();
			int tmp = w.getLevel()+1;
			w.setScore(1000);
			w.update(delta);
			assertTrue(tmp==w.getLevel());
		}
		
		
		
}
