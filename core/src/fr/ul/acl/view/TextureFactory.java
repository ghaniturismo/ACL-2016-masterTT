package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	private static TextureFactory instance = new TextureFactory();
    private Texture ship = new Texture(Gdx.files.internal("images/ship.png"));
    
    public static TextureFactory getInstance() {
        return instance;
    }

    public Texture getTextureShip() {
        return ship;
    }
}
