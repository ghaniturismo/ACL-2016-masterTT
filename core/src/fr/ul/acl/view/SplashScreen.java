package fr.ul.acl.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.SpaceInvaders;

public class SplashScreen extends ScreenAdapter {
	private SpaceInvaders mygame;
	private SpriteBatch batch;
	private Texture img;
	private long duree, duree2;
	private OrthographicCamera camera;
	private FitViewport viewport;

	// creation de la premiere page
	public SplashScreen(SpaceInvaders mygame) {
		this.mygame = mygame;
		this.batch = new SpriteBatch();
		this.img = new Texture("ul.jpg");
		this.camera = new OrthographicCamera();
		this.viewport = new FitViewport(img.getWidth(), img.getHeight(), camera);
		this.camera.position.set(img.getWidth() / 2.0f, img.getHeight() / 2.0f,
				0);
		this.camera.update();
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		// affiche de l'image
		this.batch.draw(img, 0, 0);
		this.batch.end();
		this.duree2 = System.currentTimeMillis();
		// on passe a l'ecran de jeu si on touche l'ecran sinon au bout de 4 sec
		if (Gdx.input.justTouched() || ((this.duree2 - this.duree) / 1000) >= 4) {
			this.batch.dispose();
			this.mygame.setGameScreen();
		}
	}

	// intialisation du tps
	public void show() {
		this.duree = System.currentTimeMillis();
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
