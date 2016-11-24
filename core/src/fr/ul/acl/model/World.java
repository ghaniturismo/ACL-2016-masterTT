package fr.ul.acl.model;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.controller.GameListener;

public class World {
	private Ship space;
	private float world_width, world_height;
	private ArrayList<Alien> aliens;
	private ArrayList<Alien> removeAlien;
	private ArrayList<Missile> missiles;
	private ArrayList<Missile> removeMissiles;
	private float compteurAddAlien;

	public World() {
		this.world_width = 30;
		this.world_height = 30;
		this.space = new Ship(new Vector2(15, 0), 20, this);
		this.missiles = new ArrayList<Missile>();
		this.removeMissiles = new ArrayList<Missile>();
		this.aliens = new ArrayList<Alien>();
		this.removeAlien = new ArrayList<Alien>();
		Gdx.input.setInputProcessor(new GameListener(this.space));
	}

	// recuperation du vaisseau
	public Ship getSpace() {
		return space;
	}

	// recuperation d'un alien.
	public ArrayList<Alien> getAliens() {
		return aliens;
	}

	// ajout d'un alien dans la liste
	public void addAlien(float delta) {
		compteurAddAlien += delta;
		if (compteurAddAlien > 0.5) {
			// alien descend d'une position aléatoire
			Random r = new Random();
			int valeur = r.nextInt((int) world_width);
			this.aliens.add(new Alien(new Vector2(valeur, world_height - 1),
					10, this));
			compteurAddAlien = 0;
		}

	}

	// ajouter dans la liste removeAlien les aliens a supprimer
	public void addRemoveAlien(Alien alien) {
		this.removeAlien.add(alien);
	}

	// supprimr un missile de la liste
	public void removeAliens(ArrayList<Alien> arrayList) {
		this.aliens.removeAll(this.removeAlien);
	}

	// maj du vaisseau
	public void setSpace(Ship space) {
		this.space = space;
	}

	// recup de la largeur du monde
	public float getWorld_width() {
		return world_width;
	}

	// recup de la hauteur du monde
	public float getWorld_height() {
		return world_height;
	}

	public ArrayList<Alien> getRemoveAlien() {
		return removeAlien;
	}

	public ArrayList<Missile> getMissiles() {
		return this.missiles;
	}

	// ajouter un missile dans la liste
	public void addBullet() {
		this.missiles.add(new Missile(new Vector2(space.getPosition().x, space
				.getPosition().y + 0.5f), 30, this));
	}

	// ajouter dans la liste removeMissiles les missiles a supprimer
	public void addRemoveBullet(Missile missile) {
		this.removeMissiles.add(missile);
	}

	// supprimr un missile de la liste
	public void removeBullet(ArrayList<Missile> arrayList) {
		this.missiles.removeAll(this.removeMissiles);
	}

	public ArrayList<Missile> getRemoveMissiles() {
		return removeMissiles;
	}

	// supprime tous les elements present dans la liste removeMissile
	public void removeRemoveMissiles() {
		this.removeMissiles.clear();
	}

	public void update(float delta) {
		this.space.update(delta);
		for (Alien alien : aliens) {
			alien.updateAlien(delta);
		}

		for (Missile bullet : missiles) {
			bullet.updateMissile(delta);
		}
	}

	public void collision() {
		for (Alien alien : aliens) {
			if (space.hasCollisions(alien))
				System.out.println("game over");
			for (Missile bullet : missiles) {
				if (bullet.hasCollisions(alien)) {
					addRemoveAlien(alien);
					addRemoveBullet(bullet);
				}
			}
		}
	}

	public Texture texturespace() {
		return space.getTexture();
	}

	public Vector2 positionShip() {
		return space.getPosition();
	}

}
