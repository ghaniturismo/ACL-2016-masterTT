package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.SpaceInvaders;

public class EndScreen extends ScreenAdapter {
	private SpriteBatch batch;
	private Texture img;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private int score;
	private BitmapFont font;

	// creation de la premiere page
	public EndScreen(int score) {
		this.batch = new SpriteBatch();
		this.score = score;
		this.font = new BitmapFont();
		this.font.setColor(1.0f, .1f, .1f, 1.0f);
        this.img = new Texture("images/gameover.png");
		this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(img.getWidth(),img.getHeight(),camera);
        this.camera.position.set(img.getWidth() / 2.0f, img.getHeight() / 2.0f, 0);
        this.camera.update();
	}

	public void render(float delta) {
		   Gdx.gl.glClearColor(0, 0, 0, 0);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        this.camera.update();
	        this.batch.setProjectionMatrix(camera.combined);
	        this.batch.begin();       
	        //on affiche l'image gameover
	        this.batch.draw(img, 0, 0);
	        this.font.getData().setScale(2,2);
	        //on affiche le score
	        this.font.draw(batch,"Vous avez obtenu " + this.score + " points", 100, img.getHeight());            
	        this.batch.end();
	}

	// maj de la camera
	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	// liberation
	public void dispose() {
		batch.dispose();
	}

}
