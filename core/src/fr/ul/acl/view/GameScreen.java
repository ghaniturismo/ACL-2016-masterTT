package fr.ul.acl.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.SpaceInvaders;
import fr.ul.acl.controller.GameListener;
import fr.ul.acl.model.Alien;
import fr.ul.acl.model.Missile;
import fr.ul.acl.model.Ship;
import fr.ul.acl.model.World;

public class GameScreen extends ScreenAdapter {

	private float ppux, ppuy, world_width, world_height;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private SpriteBatch batch;
	private Ship ship;
	private ArrayList<Alien>  aliens;
	private ArrayList<Missile>  missiles;
	private World w;
	
	public GameScreen(SpaceInvaders jeux) {
		batch = new SpriteBatch();
		this.w = new World();
		this.ship = w.getSpace();
		this.aliens = w.getAliens();
		this.missiles = w.getMissiles();
		this.ppux = 48;
		this.ppuy = 48;
		Gdx.input.setInputProcessor(new GameListener(this.ship));
		this.world_width = this.w.getWorld_width();
		this.world_height = this.w.getWorld_height();
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
		//affichage du vaisseau
		batch.draw(ship.getTexture(), ship.getPosition().x * ppux, ship.getPosition().y * ppuy, ppux, ppuy);

		//affichage des aliens
		for(Alien alien : aliens){
			alien.updateAlien(delta);
			//if(alien.isRemove()){
			//	w.addRemoveAlien(alien);
			//}else{
			batch.draw(alien.getTexture(), alien.getPosition().x * ppux, alien.getPosition().y * ppuy, ppux, ppuy);
			
			for(Missile missile : missiles){							
				if(alien.hasCollisions(missile))
				System.out.println("Colison bullet alien");
			}
				//detection collision ship alien
				if(ship.hasCollisions(alien))
					System.out.println("Collison ship - alien");			
				//}
		}
		this.w.addAlien(delta);
		//affichage des missiles
		for(Missile bullet : missiles){
			bullet.updateMissile(delta);
			if(bullet.isRemove()){
				w.addRemoveBullet(bullet);
			}else{
				batch.draw(bullet.getTexture(), bullet.getPosition().x * ppux, bullet.getPosition().y * ppuy, ppux, ppuy);
			}
		}
		w.removeBullet(w.getRemoveMissiles());
		w.removeRemoveMissiles();

		//maj de la position de la fusee
		ship.update(delta);
		

		this.batch.end();

	}

}
