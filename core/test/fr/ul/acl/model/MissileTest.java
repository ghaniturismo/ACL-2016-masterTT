package fr.ul.acl.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	//test collision des missiles de l'alien avec ceux de la fusee
	@Test
	public void missileCollision() {
		World w = new World();
		Ship ship = w.getShip();
		Missile bullet = new Missile(new Vector2(0,0),30, true,null);
		Missile missile = new Missile(new Vector2(0,0),30,false,ship.getPosition());
		ArrayList<Missile> listeMissiles = new ArrayList<Missile>();
		listeMissiles.add(bullet);
		ship.setListeMissiles(listeMissiles);
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(missile);
		mapElements.put("Missile",listeElement);
		w.setMapElements(mapElements);
		//on recupere la taille de la liste avant le test de collision et on soustrait 1 car il devrait y avoir
		//une collision est suprimer l'element
		int tmp = ship.getListeMissiles().size() - 1;
		//maj,test de collision
		w.update(delta);
		//on test avec la taille de la liste apres la maj
		assertTrue(tmp == ship.getListeMissiles().size());
	}
	
	//test collision des missiles de l'alien avec ceux de la fusee
	@Test
	public void missileCollisionShip() {
		World w = new World();
		Ship ship = w.getShip();
		Missile missile = new Missile(ship.getPosition(),30,false,ship.getPosition());
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(missile);
		mapElements.put("Missile",listeElement);
		w.setMapElements(mapElements);
		int tmp = w.getVie() - 1;
		w.update(delta);
		//on test avec la taille de la liste apres la maj
		assertTrue(tmp == w.getVie());
	}

}
