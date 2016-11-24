package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import fr.ul.acl.view.BBfactory;
import fr.ul.acl.view.TextureFactory;

public class Ship extends GameElement {
	private int direction;
	private boolean isMoving;
	private Vector2 position = getPosition();
	private float speed = getSpeed();

	public Ship(Vector2 position, float speed, World world) {
		super(position, speed, world);
		this.isMoving = false;
	}

	// recupere la texture d'un vaisseau
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureShip();
	}

	// maj de la position des elements dans la fenetre
	public void update(float delta) {
		float tmp = delta * speed;

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
	}

	// stop le mvt du gemelement dans la fenetre
	public void stop(boolean m) {
		
		this.isMoving = m;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	

	// permet le mvt selon la direction
	public void turnLeft(float tmp) {
		if (this.position.x - tmp <= 0) {
			isMoving = false;
			this.position.x = 0;
		} else {
			this.position.x = this.position.x - tmp;
		}
	}

	public void turnRight(float tmp) {
		if (this.position.x + 1 + tmp >= getWorld().getWorld_width()) {
			isMoving = false;
			this.position.x = getWorld().getWorld_width() - 1;
		} else {
			this.position.x = this.position.x + tmp;
		}
	}

	public void turnUp(float tmp) {
		if (this.position.y + 1 + tmp >= getWorld().getWorld_height()) {
			isMoving = false;
			this.position.y = getWorld().getWorld_height() - 1;
		} else {
			this.position.y = this.position.y + tmp;
		}
	}

	public void turnDown(float tmp) {
		if (this.position.y - tmp <= 0) {
			isMoving = false;
			this.position.y = 0;
		} else {
			this.position.y = this.position.y - tmp;
		}
	}

	public void Shoot() {
		getWorld().addBullet();
	}
	
	// Récupération de la boundingbox
	public Rectangle getBB() {
		return BBfactory.getInstance().getBBShip()
				.setPosition(position.x, position.y);
	}
}
