package logic;

import java.util.ArrayList;

import view.PanelCanvas;

public class Game 
{
	public final static int MAX_LIVES = 3;
	public final static int NUM_EMOTIONS = 4;
	public final static int NUM_ON_CANVAS = 10;

	private int score;
	private int livesLeft;

	private Emotion emotion;
	private EmotionType lastType;

	public Game()
	{
		int numEmotion = (int)(Math.random()*(NUM_EMOTIONS));
		lastType = EmotionType.ANGRY;
		EmotionType pType= null;

		while(pType != lastType)
		{
			System.out.println(numEmotion);
			switch (numEmotion)
			{
			case 1: pType = EmotionType.ANGRY;
			break;
			case 2: pType = EmotionType.SAD;
			break;
			case 3: pType = EmotionType.HAPPY;
			break;
			case 4: pType = EmotionType.SURPRISED;
			break;
			default: pType = EmotionType.HAPPY;
			break;
			}

			lastType = pType;
		}

		emotion = new Emotion(pType);

	}

	public Emotion getEmotion()
	{
		return emotion;
	}

	public void updateEmotion()
	{
		EmotionType pType= null;


		while(pType != lastType || lastType == null)
		{
			int numEmotion = (int)(Math.random()*(NUM_EMOTIONS));
			switch (numEmotion)
			{
				case 1: pType = EmotionType.ANGRY;
				break;
				case 2: pType = EmotionType.SAD;
				break;
				case 3: pType = EmotionType.HAPPY;
				break;
				case 4: pType = EmotionType.SURPRISED;
				break;
			}

			lastType = pType;
		}

		emotion = new Emotion(pType);
		System.out.println("Got here");
		lastType = pType;
	}

}
