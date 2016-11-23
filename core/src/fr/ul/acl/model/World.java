package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Random;

public class World {
	private Ship space;
	private Alien alien;
	private float world_width, world_height;
	private ArrayList<Missile> missiles;
	private ArrayList<Missile> removeMissiles;

	public World() {
		this.world_width = 30;
		this.world_height = 30;
		//alien descend d'une position aléatoire
		Random r = new Random();
		int valeur = r.nextInt((int) world_width);
		this.space = new Ship(new Vector2(15, 0),20, this);
		this.alien = new Alien(new Vector2(valeur,world_height-1),10, this);
		this.missiles = new ArrayList<Missile>();
		this.removeMissiles = new ArrayList<Missile>();
	}

	//recuperation du vaisseau
	public Ship getSpace() {
		return space;
	}

	//recuperation d'un alien.
	public Alien getAlien() {
		return alien;
	}

	//maj du vaisseau
	public void setSpace(Ship space) {
		this.space = space;
	}

	//recup de la largeur du monde
	public float getWorld_width() {
		return world_width;
	}

	//maj de la la largeur du monde
	public void setWorld_width(float world_width) {
		this.world_width = world_width;
	}

	//recup de la hauteur du monde
	public float getWorld_height() {
		return world_height;
	}

	//maj de la hauteur du monde
	public void setWorld_height(float world_height) {
		this.world_height = world_height;
	}
	
	public ArrayList<Missile> getMissiles(){
		return this.missiles;
	}
	
	//ajouter un missile dans la liste
	public void addBullet(){
		this.missiles.add(new Missile(new Vector2(space.getPosition().x, space.getPosition().y+0.5f),30, this));
	}
	
	//ajouter dans la liste removeMissiles les missiles a supprimer 
	public void addRemoveBullet(Missile missile){
		this.removeMissiles.add(missile);
	}
	
	//supprimr un missile de la liste
	public void removeBullet(ArrayList<Missile> arrayList){
		this.missiles.removeAll(this.removeMissiles);
	}

	public ArrayList<Missile> getRemoveMissiles() {
		return removeMissiles;
	}
	
	//supprime tous les elements present dans la liste removeMissile
	public void removeRemoveMissiles() {
		this.removeMissiles.clear();
	}

}
