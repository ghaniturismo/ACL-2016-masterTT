package fr.ul.acl.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fr.ul.acl.view.TextureFactory;

/**
 * Created by ghaniturismo on 20/11/16.
 */
public class Alien extends GameMoveableElement{

    public Alien(Vector2 position, World world) {
        super(position, world);
    }

    //recupere la texture d'un alien
    public Texture getTexture() {
        return TextureFactory.getInstance().getTextureAlien();
    }
}
