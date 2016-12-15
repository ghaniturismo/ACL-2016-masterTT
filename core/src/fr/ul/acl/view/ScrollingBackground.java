package fr.ul.acl.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ScrollingBackground {
	
	Texture texture;
	float y1, y2;
	int speed = 0;
	int goalSpeed = 1000;
	int speed_acceleration = 200;
	float[] world_size = {1500 , 1000};
	float imageScale;
	
	public ScrollingBackground () {
		this.texture = TextureFactory.getInstance().getTextureBackground();
		y1 = 0;
		y2 = texture.getHeight();
		imageScale = world_size[0] / world_size[1];
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
		
		//si la testure y1 est en bas on le place le haut
		if (y1 + texture.getHeight() * imageScale <= 0)
			y1 = y2 + texture.getHeight() * imageScale;
		
		//si la testure y2 est en bas on le place le haut
		if (y2 + texture.getHeight() * imageScale <= 0)
			y2 = y1 + texture.getHeight() * imageScale;

		batch.draw(texture, 0, y1, world_size[0], texture.getHeight() * imageScale);
		batch.draw(texture, 0, y2, world_size[0], texture.getHeight() * imageScale);
	}
	
}
