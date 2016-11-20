package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import fr.ul.acl.view.TextureFactory;

public class Ship extends GameMoveableElement {
	public Ship(Vector2 position, World world) {
		super(position, world);
	}

	//recupere la texture du vaisseau
	public Texture getTexture() {
		return TextureFactory.getInstance().getTextureShip();
	}

}
