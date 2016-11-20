package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;

import fr.ul.acl.view.TextureFactory;

public class Ship extends GameMoveableElement {
	public Ship(float x, float y, World world) {
		super(x, y, world);
	}

	//recupere la texture de la fusee
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureShip();
	}

}
