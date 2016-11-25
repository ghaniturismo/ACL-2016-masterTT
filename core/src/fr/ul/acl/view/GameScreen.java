package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.SpaceInvaders;
import fr.ul.acl.model.GameElement;
import fr.ul.acl.model.World;

public class GameScreen extends ScreenAdapter {

	private float ppux, ppuy, world_width, world_height;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private SpriteBatch batch;
	private World w;
	
	public GameScreen(SpaceInvaders jeux) {
		batch = new SpriteBatch();
		this.w = new World();
		this.ppux = 48;
		this.ppuy = 48;
		this.world_width = World.world_size[0];
		this.world_height = World.world_size[1];
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(this.world_width * ppux, this.world_height * ppuy, camera);
		this.camera.position.set(this.world_width * ppux / 2.0f, this.world_height * ppuy / 2.0f, 0);
		this.camera.update();
	}

	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	public void render(float delta) {
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		//affichage des elements 
		for(GameElement element : w.getGameElements())
			batch.draw(element.getTexture(), element.getPosition().x * ppux, element.getPosition().y * ppuy, ppux, ppuy);
		w.update(delta);
		this.batch.end();

	}

}
