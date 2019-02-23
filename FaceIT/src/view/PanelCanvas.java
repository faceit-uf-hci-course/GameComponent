package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Emotion;

public class PanelCanvas extends JPanel
{
	public static final int CANVAS_WIDTH = 500;
	public static final int CANVAS_HEIGHT = 900;
	public static final int UPPER_LINE_Y = CANVAS_HEIGHT-100;
	public static final int LOWER_LINE_Y = CANVAS_HEIGHT-200;

	private MainFrame window;
	private PanelInformation information;
	
	private Emoji emoji;
	private int currentY;
	private boolean isOn;
	private boolean isVisible;
	private boolean actionsAreOn;
	private Thread mythread;

	public PanelCanvas(MainFrame pWindow, PanelInformation pInfo)
	{
		window = pWindow;
		information = pInfo;
		setSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		setBackground(Color.WHITE);
		currentY = 0;
		isOn = false;
		actionsAreOn = false;
		isVisible = true;
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
		g.setColor(Color.MAGENTA);
		g.drawRect(0, CANVAS_HEIGHT-250, CANVAS_WIDTH, 150);
		g.fillRect(0, CANVAS_HEIGHT-250, CANVAS_WIDTH, 150);
		//g.drawLine(0, CANVAS_HEIGHT-100, CANVAS_WIDTH, CANVAS_HEIGHT-100);
		//g.drawLine(0, CANVAS_HEIGHT-250, CANVAS_WIDTH, CANVAS_HEIGHT-250);
		g.setColor(emoji.getColor());
		g.fillOval(emoji.getX(), emoji.getY(), Emoji.RADIUS, Emoji.RADIUS);

		/*
		if(currentY>= CANVAS_HEIGHT && isOn == false)
		{
			currentY = 0;
			window.resetEmotion();
			window.updateEmoji();
			repaint();
			initializeThread();
			executeThread();

		}
		 */
	}

	public void initializeThread()
	{
		mythread = new Thread() 
		{
			public void run() 
			{
				isOn = true;

				while (true) 
				{
					actionsAreOn = false;
					emoji.setY(currentY+Emoji.RADIUS/20);
					currentY = currentY+Emoji.RADIUS/20;

					information.updateEmotion(emoji.getEmotion());
					if(isVisible == true)
					{
						repaint();
					}


					if(currentY > LOWER_LINE_Y && currentY < UPPER_LINE_Y)
					{
						actionsAreOn = true;
					}


					try 
					{
						Thread.sleep(10);

					} 
					catch (InterruptedException err) 
					{
						err.printStackTrace();
					}


					if(currentY>= CANVAS_HEIGHT)
					{
						currentY = 0;
						window.resetEmotion();
						window.updateEmoji();
						repaint();

					}

				}



				/*
				while (currentY<CANVAS_HEIGHT) 
				{
					emoji.setY(currentY+Emoji.RADIUS/20);
					currentY = currentY+Emoji.RADIUS/20;

					if(isVisible == true)
					{
						repaint();
					}


					if(currentY > LOWER_LINE_Y && currentY < UPPER_LINE_Y)
					{
						actionsAreOn = true;
					}


					try 
					{
						Thread.sleep(10);

					} 
					catch (InterruptedException err) 
					{
						err.printStackTrace();
					}

				}

				isVisible = true;
				changeStatus();
				repaint();
				interrupt();
				 */
			}
		};
	}

	public void interruptThread()
	{
		mythread.interrupt();
		mythread.stop();
		mythread.destroy();
		isVisible = true;
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

	public Emoji getEmoji()
	{
		return emoji;
	}

	public boolean getActionsAreOn()
	{
		return actionsAreOn;
	}

	public void switchIsVisible()
	{
		isVisible = !isVisible;
	}


	public void actionToPerform(int pKey)
	{
		// TODO Auto-generated method stub

		

		if(actionsAreOn == true)
		{
			System.out.println("Enters to recognize pKey events " + actionsAreOn);
			//UP
			if(pKey == KeyEvent.VK_UP) 
			{

				System.out.println("enter to UP");
				if(emoji.getColor() == Color.GREEN)
				{
					information.updateScore();
					currentY = 0;
					window.resetEmotion();
					window.updateEmoji();
				}

			}

			//LEFT
			else if(pKey == KeyEvent.VK_LEFT) 
			{
				//SURPRISED
				System.out.println("enter to LEFT");
				if(emoji.getColor() == Color.YELLOW)
				{
					information.updateScore();
					currentY = 0;
					window.resetEmotion();
					window.updateEmoji();
				}
			}

			//RIGHT
			else if(pKey == KeyEvent.VK_RIGHT)
			{
				//BORED
				System.out.println("enter to RIGHT");
				if(emoji.getColor() == Color.BLUE)
				{
					information.updateScore();
					currentY = 0;
					window.resetEmotion();
					window.updateEmoji();
				}
			}

			//DOWN
			else if(pKey == KeyEvent.VK_DOWN)
			{
				//ANGRY
				System.out.println("enter to DOWN");
				if(emoji.getColor() == Color.RED)
				{
					information.updateScore();
					currentY = 0;
					window.resetEmotion();
					window.updateEmoji();
				}
			}
		}


	}



}
