package logic;

public class Emotion 
{
	private EmotionType type;

	public Emotion(EmotionType pType)
	{
		type = pType;
	}

	public EmotionType getType() 
	{
		return type;
	}

	public void setType(EmotionType type) 
	{
		this.type = type;
	}
}
