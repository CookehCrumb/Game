package com.cookeh.game;

import com.cookeh.engine.GameContainer;
import com.cookeh.engine.Renderer;

public class Player extends GameObject {

	public Player(float posX, float posY)
	{
		this.tag = "player";
		this.posX = posX * 16;
		this.posY = posY * 16;
		this.width = 16;
		this.height = 16;
		this.health = 20;
		this.energy = 20;
	}
	
	
	@Override
	public void update(GameContainer gc, float dt) 
	{
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) 
	{
		r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
	}

}
