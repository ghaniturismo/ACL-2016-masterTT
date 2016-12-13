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
	private Texture img, img2;
	private Music music;


	public GameScreen(SpaceInvaders jeux) {
		this.mygame = jeux;
		this.music=Gdx.audio.newMusic(Gdx.files.internal("sounds/tir_tir_generic.mp3"));
		batch = new SpriteBatch();
		this.w = new World();
		this.img = new Texture("images/background_star.jpg");
		this.img2 = new Texture("images/pause.png");
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
	}

	public void resize(int width, int height) {
		this.viewport.update(width, height);
	}

	public void render(float delta) {
		Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		
		if (w.isGameOver()) {
			batch.dispose();
			this.mygame.setEndScreen(w.getScore());
		}
		
		this.batch.begin();
		// affichage du score et nbre de vie
		this.font.getData().setScale(3, 3);
		this.font.draw(batch, "Score :" + this.w.getScore(), 2, this.world_height* ppuy);
		this.font.draw(batch, "Level : " + this.w.getLevel(), (this.world_width-4)*ppux, this.world_height* ppuy);
		this.font.draw(batch, "Vie :  " + this.w.getVie(), (this.world_width-4)*ppux, (this.world_height-1)* ppuy);
		
		//lance de music
        //music.setLooping(true);
        //music.play();
		
		if (!w.isPaused()) {
			//image de fond 
			this.batch.draw(img, 0, 0);
			
			Texture texture = TextureFactory.getInstance().getTextureShip();;
			// affichage du ship et de ses missiles
			batch.draw(texture, w.getShip().getPosition().x * ppux,w.getShip().getPosition().y * ppuy, ppux, ppuy);
			texture = TextureFactory.getInstance().getTextureBullet();
			for(GameElement element: w.getShip().getListeMissiles()){
				batch.draw(texture, element.getPosition().x * ppux,element.getPosition().y * ppuy, ppux, ppuy);
			}
				
			// affichage des elements
			for(Map.Entry<String, ArrayList<GameElement>> entry : w.getMapElements().entrySet()) {
				String key = entry.getKey();
				switch(key){
					case "Alien": texture = TextureFactory.getInstance().getTextureAlien();break;
					case "Bonus": texture = TextureFactory.getInstance().getTextureBonus();break;
					case "Missile": texture = TextureFactory.getInstance().getTextureBullet();break;
				}
				for(GameElement element: entry.getValue()){
					batch.draw(texture, element.getPosition().x * ppux,element.getPosition().y * ppuy, ppux, ppuy);
				}
			}	
			w.update(delta);
		}else {
			this.batch.draw(img2, 0, 0);
		}
		this.batch.end();
	}

}
