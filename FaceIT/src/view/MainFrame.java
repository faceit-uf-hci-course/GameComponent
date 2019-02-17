package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import logic.Emotion;
import logic.Game;
import logic.EmotionType;

public class MainFrame extends JFrame
{
	private PanelCanvas panelCanvas;
	
	private Game game;
	
	public MainFrame(Game pGame)
	{
		game = pGame;
		setTitle("FaceIt - MVP1.0");
		setSize(new Dimension(PanelCanvas.CANVAS_WIDTH, PanelCanvas.CANVAS_HEIGHT));
		setResizable(false);
		setLocationRelativeTo(null);
		panelCanvas = new PanelCanvas(this);
		updateEmoji();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panelCanvas);
		
		setVisible(true);
	}
	
	public void updateEmoji()
	{
		Emotion emotion = game.getEmotion();
		Color color = null;
		switch (emotion.getType())
		{
			case ANGRY: color = Color.RED; 
						break;
			case SURPRISED: color = Color.YELLOW;
						break;
			case BORED: color = Color.BLUE;
						break;
			case HAPPY: color = Color.GREEN;
						break;
		}
		
		int posX = (int)(Math.random()*PanelCanvas.CANVAS_WIDTH);
		
		if(posX>440) 
		{
			posX = posX-30; //Adjustment done visually
		}
		
		Emoji newEmoji = new Emoji(posX, color);
		panelCanvas.updateEmoji(newEmoji);
	}
	
	public void resetEmotion()
	{
		game.updateEmotion();
	}
	
	public static void main(String[] args) 
	{
		Game g = new Game();
		MainFrame window = new MainFrame(g);
	}

}
