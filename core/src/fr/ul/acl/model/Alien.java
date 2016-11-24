package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.BBfactory;
import fr.ul.acl.view.TextureFactory;

/**
 * Created by ghaniturismo on 20/11/16.
 */
public class Alien extends GameElement {
	private Vector2 position = getPosition();
	private float speed = getSpeed();


	public Alien(Vector2 position, float speed, World world) {
		super(position, speed, world);
	}

	// recupere la texture d'un alien
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureAlien();
	}
	
	// maj la position d'un Alien.
		public void updateAlien(float delta) {
			float tmp = delta * speed;
			position.y = position.y - tmp;
		}
		   //Récupération de la boundingbox
	    public Rectangle getBB() {
	        return BBfactory.getInstance().getBBAlien().setPosition(position.x, position.y);
	    }
		

}
