package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import logic.Emotion;
import logic.Game;
import logic.EmotionType;

public class MainFrame extends JFrame implements KeyListener
{
	private PanelCanvas panelCanvas;
	private PanelInformation panelInfo;
	private Game game;

	public MainFrame(Game pGame)
	{
		game = pGame;
		setTitle("FaceIt - MVP1.0");
		setSize(new Dimension(PanelCanvas.CANVAS_WIDTH, PanelCanvas.CANVAS_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		panelInfo = new PanelInformation(this);
		panelCanvas = new PanelCanvas(this, panelInfo);
		updateEmoji();
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panelCanvas, BorderLayout.CENTER);
		add(panelInfo, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void updateEmoji()
	{
		Emotion emotion = game.getEmotion();
		Color color = null;
		int posX = (int)(Math.random()*PanelCanvas.CANVAS_WIDTH);
		switch (emotion.getType())
		{
		case ANGRY: 
			color = Color.RED; 	
			break;
		case SURPRISED: 
			color = Color.YELLOW;
			
			break;
		case SAD:
			color = Color.BLUE;
			break;
		case HAPPY:
			color = Color.GREEN;
			break;
		}

		if(posX>440) 
		{
			posX = posX-30; //Adjustment done visually
		}
		
		Emoji newEmoji = new Emoji(posX, color, emotion.getType().toString());
		System.out.println(newEmoji.getEmotion());
		
		panelCanvas.updateEmoji(newEmoji);
	}

	public void resetEmotion()
	{
		game.updateEmotion();
	}

	public void increaseScore()
	{

	}


	public static void main(String[] args) 
	{
		Game g = new Game();
		MainFrame window = new MainFrame(g);
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		System.out.println("Got to keyboard");
		int key = e.getKeyCode();
		System.out.println("Enters to recognize key events");
		panelCanvas.actionToPerform(key);
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("Got to keyboard");
		int key = e.getKeyCode();
		System.out.println("Enters to recognize key events");
		panelCanvas.actionToPerform(key);
	}

}
