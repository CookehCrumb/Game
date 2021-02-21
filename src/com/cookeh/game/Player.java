package com.cookeh.game;

import java.awt.event.KeyEvent;

import com.cookeh.engine.GameContainer;
import com.cookeh.engine.Renderer;

public class Player extends GameObject {

	private float speed = 80;
	
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
		if(gc.getInput().isKey(KeyEvent.VK_W))
		{
			posY -= dt * speed;
		}
		
		if(gc.getInput().isKey(KeyEvent.VK_A))
		{
			posX -= dt * speed;
		}
		
		if(gc.getInput().isKey(KeyEvent.VK_S))
		{
			posY += dt * speed;
		}
		
		if(gc.getInput().isKey(KeyEvent.VK_D))
		{
			posX += dt * speed;
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) 
	{
		r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
	}

}
