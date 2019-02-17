package view;

import java.awt.Color;

public class Emoji
{
	public final static int RADIUS = 50;
	private int x,y;
	private Color color;
	
	public Emoji(int pX, Color pColor)
	{
		x = pX;
		y = 0;
		color = pColor;
	}
	
	public Color getColor()
	{
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
