package fr.ul.acl.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.Vector2;

public class World {
	public static float world_size[] = { 30, 30 };
	private HashMap<String,ArrayList<GameElement>> mapElements;
	private Ship ship;
	private float countShowAlien = 0;
	private float countShowBonus = 0;
	private int score = 0;
	private boolean gameover = false;
	private boolean paused = false;
	private int vie = 3;
	private int level = 1;
	private float alienSpeed = 10;
	private float bonusSpeed = 10;
	private Music music;

	public World() {
		mapElements = new HashMap<String,ArrayList<GameElement>>();
		this.ship = new Ship(new Vector2(world_size[1] / 2, 0), 20);
		this.music=Gdx.audio.newMusic(Gdx.files.internal("sounds/tir_tir_generic.mp3"));
	}

	/************************************************/
	/********************* WORLD ********************/
	/************************************************/

	public HashMap<String,ArrayList<GameElement>> getMapElements() {
		return this.mapElements;
	}

	public void update(float delta) {
		ship.update(delta);
		for(GameElement missileShip: ship.getListeMissiles()){
			missileShip.update(delta);
		}
		for(Map.Entry<String, ArrayList<GameElement>> entry : mapElements.entrySet()) {
			for(GameElement element: entry.getValue()){
				element.update(delta);
			}
		}
		countShowAlien += delta;
		if (countShowAlien > 0.8f) {
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
		System.out.println(vie);
	}

	private void addBonus(float delta) {
		Random r = new Random();
		int valeur = r.nextInt((int) world_size[0]);
		this.addElement("Bonus", new Alien(new Vector2(valeur, world_size[1] - 1),this.bonusSpeed));
	}

	private void collisionElement() {
		Boolean init = false;
		for(Map.Entry<String, ArrayList<GameElement>> entry : mapElements.entrySet()) {
			String key = entry.getKey();
			for(GameElement element: entry.getValue()){
				// determine s'il y a collision entre le vaisseau et un autre element
				if (element.getBB().overlaps(ship.getBB())){
					switch(key){
						case "Alien":{// s'il y a collision avec un alien on initiale la partie avec une vie en moins
							this.vie -= 1;
							this.isDead();
							init = true;
							ship.setPosition(new Vector2(world_size[1] / 2, 0));
							break;
						}
						case "Bonus":{// s'il y a collision avec un bonus on incremente le score 
							this.addScore();
							this.vie += 1;
							element.setRemove();
							break;
						}
					}
				}
				// determine si un tire du vaisseau touche un element
				for(GameElement missileShip: ship.getListeMissiles()){
					if (element.getBB().overlaps(missileShip.getBB())){
						switch(key){
							case "Alien":{// si le tire touche un alien on le supprime
								element.setRemove();
								missileShip.setRemove();
								this.addScore();
								break;
							}
							case "Bonus":{// si le tire touche un bonus on incremente sa vie 
								this.addScore();
								this.vie += 1;
								element.setRemove();
								missileShip.setRemove();
								break;
							}
						}
					}
				}
			}
		}
		this.removeGameElement(init);
	}
	
	// efface tous les element present dans mapElements si le vaiseau touche un alien sinon supprime les elements neccesaire du jeu
	private void removeGameElement(Boolean init){
		if(init){
			mapElements.clear();
		}else{
			Iterator<Entry<String, ArrayList<GameElement>>> iterator = this.mapElements.entrySet().iterator();
		    while (iterator.hasNext()) {
		        Iterator<GameElement> iteratorElement = iterator.next().getValue().iterator();
		        while (iteratorElement.hasNext()) {
		        	if(iteratorElement.next().isRemove()){
		        		iteratorElement.remove();
		        	}
		        }
		    }
		    Iterator<Missile> iteratorMissileShip = ship.getListeMissiles().iterator();
	        while (iteratorMissileShip.hasNext()) {
	        	if(iteratorMissileShip.next().isRemove()){
	        		iteratorMissileShip.remove();
	        	}
	        }
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
			this.alienSpeed += 2;
			this.bonusSpeed += 2;
			mapElements.clear();
			this.ship.setPosition(new Vector2(world_size[1] / 2, 0));
			this.level = leveltmp;
		}
	}

	public int getVie() {
		return this.vie;
	}
	
	private void addElement(String key, GameElement element){
		ArrayList<GameElement> listeElement = mapElements.get(key);
	    // si la liste n'existe pas on la creer sinon on ajoute notre element dans liste existante
	    if(listeElement == null) {
	    	listeElement = new ArrayList<GameElement>();
	    	listeElement.add(element);
	    	mapElements.put(key, listeElement);
	    } else {
	        // teste au prealable que notre element n'ai pas deja dans la liste 
	        if(!listeElement.contains(element)){
	        	listeElement.add(element);
	        }
	    }
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

	// ajout d'un alien en fonction du temps avec une position aléatoire
	private void addAlien(float delta) {
		Random r = new Random();
		int valeur = r.nextInt((int) world_size[0]);
		this.addElement("Alien", new Alien(new Vector2(valeur, world_size[1] - 1),this.alienSpeed));
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


