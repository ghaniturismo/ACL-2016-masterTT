package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpaceInvadersTest {

	
		//Test le mvt a gauche
	@Test
	public void shipLeft(){
		World w = new World();
		SpaceInvaders ship = w.getSpace();
		float tmp = ship.getX()-1;
		ship.turnLeft();
		assertTrue(tmp == ship.getX());
	}
	
	//Test le mvt a droite
	@Test
	public void shipRight(){
		World w = new World();
		SpaceInvaders ship = w.getSpace();
		float tmp = ship.getX()+1;
		ship.turnRight();
		assertTrue(tmp == ship.getX());	
	}
	
	//Test le mvt a gauche dans le cas ou l'on est au debut de la fenetre (pas de mvt normalement)
		@Test
		public void shipLeft2(){
			World w = new World();
			SpaceInvaders ship = w.getSpace();
			ship.setX(0);
			float tmp = ship.getX();
			ship.turnLeft();
			assertTrue(tmp == ship.getX());	
		}
	
	//Test le mvt a droite dans le cas ou l'on est a la fin de la fenetre (pas de mvt normalement)
	@Test
	public void shipRight2(){
		World w = new World();
		float tmp_w = w.getWorld_width();
		SpaceInvaders ship = w.getSpace();
		ship.setX(tmp_w-1);
		float tmp = ship.getX();
		ship.turnRight();
		assertTrue(tmp == ship.getX());	
	}
	
}
