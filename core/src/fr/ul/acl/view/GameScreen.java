package fr.ul.acl.view;

import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import fr.ul.acl.SpaceInvaders;
import fr.ul.acl.controller.GameListener;
import fr.ul.acl.model.GameElement;
import fr.ul.acl.model.World;

public class GameScreen extends ScreenAdapter {

	private float ppux, ppuy, world_width, world_height;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private SpriteBatch batch;
	private World w;
	private SpaceInvaders mygame;
	private BitmapFont font;
	private Texture img;
	private Music music;
	private ScrollingBackground scrollingBackground;

	public GameScreen(SpaceInvaders jeux) {
		this.mygame = jeux;
		this.music=Gdx.audio.newMusic(Gdx.files.internal("sounds/generic2.mp3"));
		batch = new SpriteBatch();
		this.w = new World();
		//this.img_fond = new Texture("images/galaxie.jpg");
		this.img = new Texture("images/pause.png");
		Gdx.input.setInputProcessor(new GameListener(w));
		this.ppux = 48;
		this.ppuy = 48;
		this.world_width = World.world_size[0];
		this.world_height = World.world_size[1];
		this.camera = new OrthographicCamera();
		this.font = new BitmapFont();
		this.font.setColor(1.0f, 0.1f, 0.1f, 1.0f);
		this.viewport = new FitViewport(this.world_width * ppux,this.world_height * ppuy, camera);
		this.camera.position.set(this.world_width * ppux / 2.0f,this.world_height * ppuy / 2.0f, 0);
		this.camera.update();
		this.scrollingBackground = new ScrollingBackground();
	}

	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	public void render(float delta) {
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		
		//test si le jeu est fini,si oui on passe a la fenetre de fin
		if (w.isGameOver()) {
			batch.dispose();
			this.mygame.setEndScreen(w.getScore());
		}
		
		this.batch.begin();
		//this.batch.draw(img_fond,0,0,1500,1500);
		this.scrollingBackground .updateAndRender(delta, this.batch);
	
		//lance de music
        music.setLooping(true);
        music.play();
		
		//si on est pas sur pause
		if (!w.isPaused()) {
			
			// affichage du ship et de ses missiles
			Texture texture = TextureFactory.getInstance().getTextureShip();;
			batch.draw(texture, w.getShip().getPosition().x * ppux,w.getShip().getPosition().y * ppuy, ppux, ppuy);
			Texture texture_bullet = TextureFactory.getInstance().getTextureBullet();
			for(GameElement element: w.getShip().getListeMissiles()){
				batch.draw(texture_bullet, element.getPosition().x * ppux,element.getPosition().y * ppuy, ppux, ppuy);
			}
				
			// affichage des elements
			for(Map.Entry<String, ArrayList<GameElement>> entry : w.getMapElements().entrySet()) {
				String key = entry.getKey();
				switch(key){
					case "Alien": texture = TextureFactory.getInstance().getTextureAlien();break;
					case "Bonus": texture = TextureFactory.getInstance().getTextureBonus();break;
					case "Missile": texture = TextureFactory.getInstance().getTextureBullet();break;
					case "MissileA": texture = TextureFactory.getInstance().getTextureBulletA();break;

				}
				for(GameElement element: entry.getValue()){
					batch.draw(texture, element.getPosition().x * ppux,element.getPosition().y * ppuy, ppux, ppuy);
				}
			}	
			
			//maj
			w.update(delta);
			
			//on est sur pause, on affiche seulemnt une image et plus les sprites
		}else {
			this.batch.draw(img,0,0,1500,1500);
			music.pause();
		}
		
		// affichage du score,level et nbre de vie
		this.font.getData().setScale(3, 3);
		this.font.draw(batch, "Score :" + this.w.getScore(), 2, this.world_height* ppuy);
		this.font.draw(batch, "Level : " + this.w.getLevel(), (this.world_width-4)*ppux, this.world_height* ppuy);
		this.font.draw(batch, "Vie :  " + this.w.getVie(), (this.world_width-4)*ppux, (this.world_height-1)* ppuy);
		
		this.batch.end();
	}

}
