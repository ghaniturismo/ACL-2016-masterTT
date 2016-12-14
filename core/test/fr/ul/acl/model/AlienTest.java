package fr.ul.acl.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.badlogic.gdx.math.Vector2;

public class AlienTest {
	private float speed;
	private float delta = (float) 0.017519908;


	@Test
	//on verifie si le déplacement vers le bas se fait correctement
	public void AlienGoDown() {
		World w = new World();
		Ship ship = w.getShip();
		Alien a = new Alien(ship.getPosition(),10);
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(a);
		mapElements.put("Alien",listeElement);
		w.setMapElements(mapElements);
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
		World w = new World();
		Ship ship = w.getShip();
		//creation d'un alien a la mm position que la fusee
		Alien a = new Alien(ship.getPosition(),10);
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(a);
		mapElements.put("Alien",listeElement);
		w.setMapElements(mapElements);
		//creation d'un missile
		Missile m = new Missile(ship.getPosition(),30,true,null);
		ArrayList<Missile> listeMissiles = new ArrayList<Missile>();
		listeMissiles.add(m);
		ship.setListeMissiles(listeMissiles);
		int tmp = w.getScore()+100;
		w.update(delta);
		assertTrue(w.getScore() == tmp);
	}
	
}
