package com.cookeh.engine;

import java.awt.image.DataBufferInt;

import com.cookeh.engine.gfx.Image;
import com.cookeh.engine.gfx.ImageTile;

public class Renderer 
{
	
	private int pW, pH;
	private int [] p;

	public Renderer(GameContainer gc) 
	{
		pW = gc.getWidth();
		pH = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear() 
	{	
		for(int i = 0; i < p.length; i++) 
		{
			p[i] = 0;
		}
	}
	
	public void setPixel(int x, int y, int value) {
		if((x < 0 || x >= pW || y < 0 || y >= pH) || value == 0xffff00ff) 
		{
			return;
		}
		
		p[x + y * pW] = value;
	}
	
	public void drawImage(Image image, int offX, int offY) 
	{	
		//Culling Render Optimizations
		if(offX < -image.getWidth()) return;
		if(offY < -image.getHeight()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
		
		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();
		
		//Clipping Render Optimizations
		if(offX < 0) { newX -= offX; }
		if(offY < 0) { newY -= offY; }
		if(newWidth + offX > pW) { newWidth -= newWidth + offX - pW; }		
		if(newHeight + offY > pH) { newHeight -= newHeight + offY - pH; }
		
		//Render Image
		for(int y = newY; y < newHeight; y++) 
		{
			for(int x = newX; x < newWidth; x++) 
			{
				setPixel(x + offX, y + offY, image.getP()[x + y * image.getWidth()]);
			}
		}
	}
	
	public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) 
	{
		//Culling Render Optimizations
		if(offX < -image.getTileW()) return;
		if(offY < -image.getTileH()) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
				
		int newX = 0;
		int newY = 0;
		int newWidth = image.getTileW();
		int newHeight = image.getTileH();
				
		//Clipping Render Optimizations
		if(offX < 0) { newX -= offX; }
		if(offY < 0) { newY -= offY; }
		if(newWidth + offX > pW) { newWidth -= newWidth + offX - pW; }		
		if(newHeight + offY > pH) { newHeight -= newHeight + offY - pH; }
				
		//Render Image
		for(int y = newY; y < newHeight; y++) 
		{
			for(int x = newX; x < newWidth; x++) 
			{
				//long-line-nitis. fix soon
				setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getWidth()]);
			}
		}
	}
	
	public void drawFillRect(int offX, int offY, int width, int height, int color)
	{
		//Culling Render Optimizations
		if(offX < -width) return;
		if(offY < -height) return;
		if(offX >= pW) return;
		if(offY >= pH) return;
						
		int newX = 0;
		int newY = 0;
		int newWidth = width;
		int newHeight = height;
						
		//Clipping Render Optimizations
		if(offX < 0) { newX -= offX; }
		if(offY < 0) { newY -= offY; }
		if(newWidth + offX > pW) { newWidth -= newWidth + offX - pW; }		
		if(newHeight + offY > pH) { newHeight -= newHeight + offY - pH; }
						
		
		for(int y = newY; y <= newHeight; y++) 
		{
			for(int x = newX; x <= newWidth; x++)
			{
				setPixel(x + offX, y + offY, color);
			}
		}
	}
}
