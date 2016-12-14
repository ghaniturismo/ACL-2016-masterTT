package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	private static TextureFactory instance = new TextureFactory();
	//image de vaisseau
	private Texture ship = new Texture(Gdx.files.internal("images/ship.png"));
	//image de l'alien
	private Texture alien = new Texture(Gdx.files.internal("images/alien.png"));
	//image du bonus
	private Texture bonus = new Texture(Gdx.files.internal("images/alien2.png"));
	//image du missile
	private Texture bullet = new Texture(Gdx.files.internal("images/bullet.png"));

	public static TextureFactory getInstance() {
		return instance;
	}

	public Texture getTextureShip() {
		return ship;
	}

	public Texture getTextureAlien(){
		return alien;
	}

	public Texture getTextureBonus(){
		return bonus;
	}
	public Texture getTextureBullet() {
		return bullet;
	}
	
}
