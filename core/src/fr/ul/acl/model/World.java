package fr.ul.acl.model;

import com.badlogic.gdx.math.Vector2;

public class World {
	private Ship space;
	private Alien alien;
	private float World_width, World_height;

	public World() {
		this.World_width = 30;
		this.World_height = 30;
		this.space = new Ship(new Vector2(15, 0), this);
		this.alien = new Alien(new Vector2(15, 29), this);
	}

	//recuperation du vaisseau
	public Ship getSpace() {
		return space;
	}

	//recuperation d'un alien.
	public Alien getAlien() {
		return alien;
	}

	//maj de la fusee
	public void setSpace(Ship space) {
		this.space = space;
	}

	//recup de la largeur du monde
	public float getWorld_width() {
		return World_width;
	}

	//maj de la la largeur du monde
	public void setWorld_width(float world_width) {
		World_width = world_width;
	}

	//recup de la hauteur du monde
	public float getWorld_height() {
		return World_height;
	}

	//maj de la hauteur du monde
	public void setWorld_height(float world_height) {
		World_height = world_height;
	}

}
