package fr.ul.acl.model;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class BonusTest {
	private float speed;
	private float delta = (float) 0.017519908;
	
	@Test
	//on verifie si le deplacement vers le bas se fait correctement
	public void bonusGoDown() {
		World w = new World();
		Ship ship = w.getShip();
		Bonus bonus = new Bonus(ship.getPosition(),10);
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(bonus);
		mapElements.put("Bonus",listeElement);
		w.setMapElements(mapElements);
		speed = bonus.getSpeed();
		float tmp = speed * delta;
		float tmp1 = bonus.getPosition().y - tmp;
		bonus.update(delta);
		float y = bonus.getPosition().y;
		assertTrue( tmp1 == y );
	}

	@Test
	//ajout d’une vie si on obtient un bonus avec teste de collision entre vaisseau et le bonus.
	public void addLifeColl(){
		World w = new World();
		Ship ship = w.getShip();
		Bonus bonus = new Bonus(ship.getPosition(),10);
		HashMap<String,ArrayList<GameElement>> mapElements =  w.getMapElements();
		ArrayList<GameElement> listeElement = new ArrayList<GameElement>();
    	listeElement.add(bonus);
		mapElements.put("Bonus",listeElement);
		w.setMapElements(mapElements);
		int tmp = w.getVie()+1;
		w.update(delta);
		assertTrue(tmp==w.getVie());
	}
}
