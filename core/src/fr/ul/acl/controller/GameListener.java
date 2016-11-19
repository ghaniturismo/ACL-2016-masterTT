package fr.ul.acl.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

import fr.ul.acl.model.Ship;

public class GameListener implements InputProcessor{
	private Ship ship;

    public GameListener( Ship ship2) {
        this.ship = ship2;
    }

    public boolean keyDown(int keycode) {
        switch (keycode) {
	        	case Input.Keys.UP:
	            this.ship.DirectionUP();
	           break;
	        	case Input.Keys.DOWN:
	           this.ship.DirectionDown();
	           break;
	            case Input.Keys.LEFT:
	                this.ship.DirectionLeft();
	                break;
	            case Input.Keys.RIGHT:
	                this.ship.DirectionRight();
	                break;
	            case Input.Keys.ESCAPE:
	                Gdx.app.exit();
	                break;
	        }
        return true;
    }

	@Override
	public boolean keyUp(int keycode) {
			ship.stop();
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
