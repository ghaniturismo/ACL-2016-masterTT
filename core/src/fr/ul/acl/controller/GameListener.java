package fr.ul.acl.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.ul.acl.model.Ship;

public class GameListener implements InputProcessor {
	private Ship ship;

	public GameListener(Ship ship2) {
		this.ship = ship2;
	}

	// permet de choisir la direction selon les fleches
	public boolean keyDown(int keycode) {
		
		switch (keycode) {
		case Input.Keys.UP:
			this.ship.setDirection(3);
			ship.stop(true);
			break;
		case Input.Keys.DOWN:
			this.ship.setDirection(4);
			ship.stop(true);
			break;
		case Input.Keys.LEFT:
			this.ship.setDirection(1);
			ship.stop(true);
			break;
		case Input.Keys.RIGHT:
			this.ship.setDirection(2);
			ship.stop(true);
			break;
		case Input.Keys.SPACE:
			this.ship.Shoot();
			break;
		case Input.Keys.ESCAPE:
			Gdx.app.exit();
			break;
		}
		return true;
	}

	// permet de stopper le mvt quand on arrete d'appuyer sur les touches
	@Override
	public boolean keyUp(int keycode) {
		if (keycode != Input.Keys.SPACE)
			ship.stop(false);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
