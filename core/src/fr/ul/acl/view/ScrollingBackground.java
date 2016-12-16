package fr.ul.acl.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {
	
	Texture texture;
	float y1, y2;
	int speed = 0;
	int goalSpeed = 200;
	int speed_acceleration = 100;
	
	public ScrollingBackground () {
		this.texture = TextureFactory.getInstance().getTextureBackground();
		y1 = 0;
		y2 = texture.getHeight()+420;
	}
	
	public void updateAndRender (float deltaTime, SpriteBatch batch) {
		// Pour avoir un effet d'acceleration du vaisseau au debut 
		if (speed < goalSpeed) {
			speed += speed_acceleration * deltaTime;
			if (speed > goalSpeed)
				speed = goalSpeed;
		} else if (speed > goalSpeed) {
			speed -= speed_acceleration * deltaTime;
			if (speed < goalSpeed)
				speed = goalSpeed;
		}
		
		y1 -= speed * deltaTime;
		y2 -= speed * deltaTime;
		
		//si la testure y1 est en bas on le place en haut
		if (y1 + texture.getHeight()+420 <= 0)
			y1 = y2 + texture.getHeight()+420;
		
		
		//si la testure y2 est en bas on le place en haut
		if (y2 + texture.getHeight()+420 <= 0)
			y2 = y1 + texture.getHeight()+420;

		batch.draw(texture, 0, y1, texture.getWidth(), texture.getHeight()+420);
		batch.draw(texture, 0, y2, texture.getWidth(), texture.getHeight()+420);
	}
	
}
