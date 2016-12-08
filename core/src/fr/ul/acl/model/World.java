package fr.ul.acl.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.SourceTree;

import fr.ul.acl.model.GameElement.TypeElement;

public class World {
	public static float world_size[] = { 30, 30 };
	private ArrayList<GameElement> gameElements;
	private Ship ship;
	private float countShowAlien = 0;
	private int score = 0;
	private boolean gameover = false;
	private int vie = 6;

	public World() {
		gameElements = new ArrayList<GameElement>();
		this.ship = new Ship(new Vector2(world_size[1]/2, 0), 20, TypeElement.SHIP);
		gameElements.add(this.ship);
	}

	/************************************************/
	/********************* WORLD ********************/
	/************************************************/

	public ArrayList<GameElement> getGameElements() {
		return this.gameElements;
	}
	
	public void setGameElements(ArrayList<GameElement> gameElements) {
		this.gameElements = gameElements;
	}

	public void update(float delta) {
		for (GameElement element : this.gameElements)
			element.update(delta);
		countShowAlien += delta;
		if (countShowAlien > 0.5f) {
			this.addAlien(delta);
			this.countShowAlien = 0;
		}
		this.collisionElement();
	}

	private void collisionElement() {
		// determine s'il y a collision entre 2 elements
		for (GameElement element : this.gameElements) {
			for (GameElement elementCompare : this.gameElements) {
				// on test s'il y a collision entre 2 elements differents
				if (element.getBB().overlaps(elementCompare.getBB())
					&& element.getTypeElement() != elementCompare.getTypeElement()) {
					if (element.getTypeElement() == TypeElement.SHIP
						|| elementCompare.getTypeElement() == TypeElement.SHIP) {
						this.vie = vie-1;
						this.isDead();
						gameElements = new ArrayList<GameElement>();
						this.ship.setPosition(new Vector2(world_size[1]/2,0));
						gameElements.add(this.ship);

						
					} else {
						// on supprime le misile et l'alien
						element.setRemove();
						elementCompare.setRemove();
						this.addScore();
					}
				}
			}
		}
		// supprime les elements du jeu
		Iterator<GameElement> iterator = this.gameElements.iterator();
		while (iterator.hasNext()) {
			GameElement element = iterator.next();
			if (element.isRemove())
				iterator.remove();
		}
	}

	// fonction qui renvoie l'etat du jeu
	public boolean isGameover() {
		
		return gameover;
		
	}

	/************************************************/
	/********************* SHIP *********************/
	/************************************************/

	// recuperation du vaisseau
	public Ship getShip() {
		return ship;
	}

	// maj du vaisseau
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	/************************************************/
	/******************* MISSILE ********************/
	/************************************************/

	// ajouter un missile dans la liste
	public void shoot() {
		this.gameElements.add(new Missile(new Vector2(ship.getPosition().x,
				ship.getPosition().y + 1), 30, TypeElement.MISSILE));
	}

	/************************************************/
	/******************** ALIEN *********************/
	/************************************************/

	// ajout d'un alien en fonction du temps
	private void addAlien(float delta) {
		// alien descend d'une position aléatoire
		Random r = new Random();
		int valeur = r.nextInt((int) world_size[0]);
		this.gameElements.add(new Alien(new Vector2(valeur, world_size[1] - 1),10, TypeElement.ALIEN));
	}

	/************************************************/
	/******************** SCORE *********************/
	/************************************************/

	public void addScore() {
		this.score += 50;
	}

	//renvoie le score du jeu.
	public int getScore() {
		return this.score;
	}

	//decremente la vie lorsque le vaisseau est mort.
	public void isDead(){
		if(vie==0){
			this.gameover=true;
		}
	}
	
}
