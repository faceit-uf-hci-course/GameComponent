package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Emotion;

public class PanelCanvas extends JPanel
{
	public static final int CANVAS_WIDTH = 500;
	public static final int CANVAS_HEIGHT = 900;

	private MainFrame window;
	private Emoji emoji;
	private int currentY;
	private boolean isOn;
	private Thread mythread;

	public PanelCanvas(MainFrame pWindow)
	{
		window = pWindow;
		setSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		setBackground(Color.WHITE);
		currentY = 0;
		isOn = false;
		initializeThread();
		executeThread();
	}

	public void updateEmoji(Emoji pEmoji)
	{
		emoji = pEmoji;
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(emoji.getColor());
		g.fillOval(emoji.getX(), emoji.getY(), Emoji.RADIUS, Emoji.RADIUS);

		if(currentY>= CANVAS_HEIGHT && isOn == false)
		{
			currentY = 0;
			window.resetEmotion();
			window.updateEmoji();
			repaint();
			initializeThread();
			executeThread();

		}
	}

	public void initializeThread()
	{
		mythread = new Thread() 
		{
			public void run() 
			{
				isOn = true;
				while (currentY<CANVAS_HEIGHT) 
				{
					emoji.setY(currentY+Emoji.RADIUS/20);
					currentY = currentY+Emoji.RADIUS/20;
					repaint();

					try 
					{
						Thread.sleep(10);

					} 
					catch (InterruptedException err) 
					{
						err.printStackTrace();
					}

				}

				changeStatus();
				repaint();
				interrupt();

			}
		};
	}

	public void interruptThread()
	{
		mythread.interrupt();
		mythread.stop();
		mythread.destroy();
	}


	public void executeThread()
	{
		mythread.start();
	}

	public boolean isThreadOn()
	{
		return isOn;
	}

	public void changeStatus()
	{
		if(isOn == true)
		{
			isOn = false;
		}

		else
		{
			isOn = true;
		}
	}

}
