package fr.ul.acl.model;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Ship extends GameElement {
	
	private int direction;
	private boolean isMoving;
	private float shootSpeed = 30;
	private int vie = 3;
	private ArrayList<Missile> listeMissiles;

	public Ship(Vector2 position, float speed) {
		super(position, speed);
		this.isMoving = false;
		this.listeMissiles = new ArrayList<Missile>();
	}
	
	//maj de la liste de missile
	public void setListeMissiles(ArrayList<Missile> listeMissiles) {
		this.listeMissiles = listeMissiles;
	}

	//recuperation de la liste de missile
	public ArrayList<Missile> getListeMissiles() {
		return listeMissiles;
	}
	
	//recuperation le nbre de vie
	public int getVie(){
		return this.vie;
	}
	
	//incrementer la vie de 1
	public void upLife(){
		this.vie += 1;
	}
	
	//decrementer la vie de 1
	public void downLife(){
		if(this.vie>0)
			this.vie -= 1;
	}
	
	//maj nbre de vie
	public void setLife(int res){
		this.vie = res;
	}
	
	//creation de missile
	public void shoot(){
		this.listeMissiles.add(new Missile(new Vector2(this.getPosition().x, this.getPosition().y + 1), shootSpeed, true,null));
	}

	// MAJ de la position des elements dans la fenetre.
	public void update(float delta) {
		float tmp = delta * this.getSpeed();
		if (isMoving) {
			switch (direction) {
			case 1:
				turnLeft(tmp);
				break;
			case 2:
				turnRight(tmp);
				break;
			case 3:
				turnUp(tmp);
				break;
			case 4:
				turnDown(tmp);
				break;
			}
		}
		this.getBB().x = this.getPosition().x;
		this.getBB().y = this.getPosition().y;
	}
	
	// stop le mvt du gemelement dans la fenetre
	public void stop(boolean m) {
		this.isMoving = m;
	}

	//maj de la direction
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
/*
 * se deplacer a gauche
 */
	public void turnLeft(float tmp) {
		if (this.getPosition().x - tmp <= 0) {
			isMoving = false;
			this.getPosition().x = 0;
		} else {
			this.getPosition().x -= tmp;
		}
	}
/*
 * se deplacer a droite
 */
	
	public void turnRight(float tmp) {
		if (this.getPosition().x + 1 + tmp >= World.world_size[0]) {
			isMoving = false;
			this.getPosition().x = World.world_size[0] - 1;
		} else {
			this.getPosition().x += tmp;
		}
	}
	
/*
 * se deplacer en haut
 */
	public void turnUp(float tmp) {
		if (this.getPosition().y + 1 + tmp >= World.world_size[1]) {
			isMoving = false;
			this.getPosition().y = World.world_size[1] - 1;
		} else {
			this.getPosition().y += tmp;
		}
	}
	
/*
 * se deplacer en bas
 */
	public void turnDown(float tmp) {
		if (this.getPosition().y - tmp <= 0) {
			isMoving = false;
			this.getPosition().y = 0;
		} else {
			this.getPosition().y -= tmp;
		}
	}

}
