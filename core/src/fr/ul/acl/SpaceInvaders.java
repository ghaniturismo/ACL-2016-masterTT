package fr.ul.acl;

import com.badlogic.gdx.Game;
import fr.ul.acl.view.GameScreen;
import fr.ul.acl.view.SplashScreen;

public class SpaceInvaders extends Game {

	SplashScreen splashScreen;
	GameScreen gameScreen;

	// creation de la fenetre de depart et de jeux
	@Override
	public void create() {
		splashScreen = new SplashScreen(this);
		gameScreen = new GameScreen(this);
		setSplashScreen();
	}

	// permet de passer a la fenetre de jeux
	public void setGameScreen() {
		setScreen(gameScreen);
	}

	// permet de passer a la fenetre de depart
	public void setSplashScreen() {
		setScreen(splashScreen);
	}

}