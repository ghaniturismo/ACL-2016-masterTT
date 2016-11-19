package fr.ul.acl;

import com.badlogic.gdx.Game;


import fr.ul.acl.view.GameScreen;
import fr.ul.acl.view.SplashScreen;

public class SpaceInvaders extends Game {

	SplashScreen splashScreen;
	GameScreen gameScreen;

	@Override
	public void create () {
		splashScreen = new SplashScreen(this);
		gameScreen = new GameScreen(this);
		setSplashScreen();
	}

	public void setGameScreen(){
		setScreen(gameScreen);
	}

	public void setSplashScreen(){
		setScreen(splashScreen);
	}

}