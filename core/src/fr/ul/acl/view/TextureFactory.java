package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	private static TextureFactory instance = new TextureFactory();
	//image de vaisseau
	private Texture ship = new Texture(Gdx.files.internal("images/ship.png"));
	//image de l'alien
	//image du missile
	private Texture bullet = new Texture(Gdx.files.internal("images/bullet.png"));

	public static TextureFactory getInstance() {
		return instance;
	}

	public Texture getTextureShip() {
		return ship;
	}

	public Texture getTextureAlien(){
		return  ship;
	}

	public Texture getTextureBullet() {
		return bullet;
	}
	
}
