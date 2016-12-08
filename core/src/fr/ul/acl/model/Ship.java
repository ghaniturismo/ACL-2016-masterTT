package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Ship extends GameElement {
	
	private int direction;
	private boolean isMoving;

	public Ship(Vector2 position, float speed,TypeElement typeElement) {
		super(position, speed, typeElement);
		this.isMoving = false;
	}
	
	@Override
	// recupere la texture d'un vaisseau.
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureShip();
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
