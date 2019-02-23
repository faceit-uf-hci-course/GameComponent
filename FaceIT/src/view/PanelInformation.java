package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformation extends JPanel
{

	private MainFrame window;
	
	private JLabel lblEmotion;
	private JLabel lblScore;
	
	private int score;

	public  PanelInformation(MainFrame pWindow) 
	{
		// TODO Auto-generated constructor stub
		window = pWindow;
		score = 0;
		lblEmotion = new JLabel("");
		lblScore = new JLabel("Score: "+score+" pts");
		setLayout(new GridLayout(1, 2));
		add(lblEmotion);
		add(lblScore);
	}

	public void updateEmotion(String pText)
	{
		lblEmotion.setText(pText);
	}
	
	public void updateScore()
	{
		score++;
		lblScore.setText("Score: "+score+" pts");
	}

}
