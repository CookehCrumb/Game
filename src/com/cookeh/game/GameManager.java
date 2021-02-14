package com.cookeh.game;

import com.cookeh.engine.AbstractGame;
import com.cookeh.engine.GameContainer;
import com.cookeh.engine.Renderer;
import com.cookeh.engine.gfx.Image;

public class GameManager extends AbstractGame {
	
	private Image image;
	
	public GameManager() {
		
	}

	@Override
	public void update(GameContainer gc, float dt) {
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
		
	}
	
	public static void main(String [] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}

}
