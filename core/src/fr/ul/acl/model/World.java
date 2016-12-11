package fr.ul.acl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.lang.model.element.TypeElement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;

public class World {
	public static float world_size[] = { 30, 30 };
	private HashMap<String,GameElement> mapElements;
	private Ship ship;
	private float countShowAlien = 0;
	private float countShowBonus = 0;
	private int score = 0;
	private boolean gameover = false;
	private boolean paused = false;
	private int vie = 6;
	private int level = 1;
	private float alienspeed = 10;
	private float bonusspeed = 10;
	private Music music;


	public World() {
		mapElements = new HashMap<String,GameElement>();
		this.ship = new Ship(new Vector2(world_size[1] / 2, 0), 20);
		this.music=Gdx.audio.newMusic(Gdx.files.internal("sounds/tir_tir_generic.mp3"));
	}

	/************************************************/
	/********************* WORLD ********************/
	/************************************************/

	public HashMap<String,GameElement> getMapElements() {
		return this.mapElements;
	}

	public void update(float delta) {
		for (GameElement element : this.gameElements)
			element.update(delta);
		countShowAlien += delta;
		if (countShowAlien > 0.5f) {
			this.addAlien(delta);
			this.countShowAlien = 0;
		}
		countShowBonus += delta;
		if (countShowBonus > 10f) {
			this.addBonus(delta);
			this.countShowBonus = 0;
		}
		this.collisionElement();
		level();
	}

	private void addBonus(float delta) {
		Random r = new Random();
		int valeur = r.nextInt((int) world_size[0]);
		this.mapElements.put("Bonus",new Bonus(new Vector2(valeur, world_size[1] - 1),this.bonusspeed));
	}

	private void collisionElement() {
		// determine s'il y a collision entre 2 elements
		for (GameElement element : this.gameElements) {
			for (GameElement elementCompare : this.gameElements) {
				// on test s'il y a collision entre 2 elements differents
				if (element.getBB().overlaps(elementCompare.getBB())
						&& element.getTypeElement() != elementCompare
								.getTypeElement()) {
					if (element.getTypeElement() == TypeElement.SHIP
							|| elementCompare.getTypeElement() == TypeElement.SHIP) {
						if (elementCompare.getTypeElement() != TypeElement.BONUS
								&& element.getTypeElement() != TypeElement.BONUS) {
							this.vie = vie - 1;
							this.isDead();
							gameElements = new ArrayList<GameElement>();
							this.ship.setPosition(new Vector2(
									world_size[1] / 2, 0));
							gameElements.add(this.ship);
						} else {
							this.addScore();
							this.vie += 1;
							if (elementCompare.getTypeElement() == TypeElement.BONUS)
								elementCompare.setRemove();
							else
								element.setRemove();
						}
					} else {
						if (elementCompare.getTypeElement() != TypeElement.BONUS
								&& element.getTypeElement() != TypeElement.BONUS) {
							// on supprime le misile et l'alien
							element.setRemove();
							elementCompare.setRemove();
							this.addScore();
						} else {
							this.addScore();
							this.vie += 1;
							element.setRemove();
							elementCompare.setRemove();
						}
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

	public int getLevel() {
		return level;
	}

	public void level() {
		int tmp = score / 1000;
		int leveltmp = tmp + 1;
		if (this.level < leveltmp) {
			this.alienspeed += 2;
			this.bonusspeed += 2;
			mapElements = new HashMap<String,GameElement>();
			this.ship.setPosition(new Vector2(world_size[1] / 2, 0));
			this.level = leveltmp;
		}
	}

	public int getVie() {
		return vie / 2;
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
		if(this.paused==false){
			this.ship.shoot();
			music.setLooping(false);
		    music.play();	
		}
	}

	/************************************************/
	/******************** ALIEN *********************/
	/************************************************/

	// ajout d'un alien en fonction du temps
	private void addAlien(float delta) {
		// alien descend d'une position aléatoire
		Random r = new Random();
		int valeur = r.nextInt((int) world_size[0]);
		this.mapElements.put("Alien",new Alien(new Vector2(valeur, world_size[1] - 1),alienspeed));
	}

	/************************************************/
	/******************** SCORE *********************/
	/************************************************/

	public void addScore() {
		this.score += 50;
	}

	// renvoie le score du jeu.
	public int getScore() {
		return this.score;
	}

	// decremente la vie lorsque le vaisseau est mort.
	public void isDead() {
		if (vie == 0) {
			this.gameover = true;
		}
	}

	public void pause(boolean res) {
		paused = res;
	}

	public boolean isPaused() {
		return this.paused;
	}
}


