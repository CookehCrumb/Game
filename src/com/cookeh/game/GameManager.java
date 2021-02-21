package com.cookeh.game;

import java.util.ArrayList;

import com.cookeh.engine.AbstractGame;
import com.cookeh.engine.GameContainer;
import com.cookeh.engine.Renderer;
import com.cookeh.engine.gfx.Image;

public class GameManager extends AbstractGame {
	
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public GameManager() 
	{
		objects.add(new Player(2,2));
	}

	@Override
	public void update(GameContainer gc, float dt) 
	{
		for(int i = 0; i < objects.size(); i++) 
		{
			objects.get(i).update(gc, dt);
			
			if(objects.get(i).getHealth() == 0 || objects.get(i).getEnergy() == 0) 
			{
				objects.remove(i);
				i--;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Renderer r) 
	{
		for(GameObject obj : objects) 
		{
			obj.render(gc, r);
		}
	}
	
	public static void main(String [] args) {
		GameContainer gc = new GameContainer(new GameManager());
		gc.setWidth(320);
		gc.setHeight(240);
		gc.getRenderer();
		gc.start();
	}

}
