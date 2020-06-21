/**
 * @(#)CovidGame.java
 * Class for the GUI.
 * It holds the GUI that the user will interact with and is also the test class. 
 * Eren Cimentepe & Rosa Li
 * Start Date: 20/06/2019
 * End Date: 21/06/2019
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.TimerTask;
import java.util.*; 
import java.util.Timer;
import javax.swing.*;

public class CovidGame implements ActionListener, KeyListener, MouseListener, MouseMotionListener
{
	//Test with mouse adapter

	JFrame gameBoard; 
	JButton start; 
	JButton pause; 
	int dayCount; 
	Person[] victims; 
	JLabel day; 
	JLayeredPane layout;
	Timer timer; 
	TimerTask task; 
	//MouseAdapter ma; 
	
	public CovidGame()
	{
		this.createGUI();
		this.dayCount = 0; 
		this.timer = new Timer(); 
		this.victims = new Person[50];
	}
	
	public CovidGame(int number)
	{
		this.createGUI();
		this.dayCount = 0; 
		this.timer = new Timer();
		this.victims = new Person[number];
	}
	
	public void createGUI()
	{
		this.gameBoard = new JFrame();
		this.gameBoard.setVisible(true);
		this.gameBoard.setSize(1100, 800);
		this.gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameBoard.setLayout(null);
		this.gameBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		this.layout = new JLayeredPane();
		this.layout.setSize(1100, 800);
		
		this.start = new JButton("Start");
		this.start.setSize(150, 50);
		this.start.setLocation(900, 500);
		this.start.addActionListener(this);
		this.start.setBackground(Color.white);
		this.start.setBorder(BorderFactory.createLoweredBevelBorder());
		this.start.setOpaque(true);
		this.layout.add(this.start);
		
		this.pause = new JButton("Pause");
		this.pause.setSize(150, 50);
		this.pause.setLocation(900, 430);
		this.pause.addActionListener(this);
		this.pause.setBackground(Color.white);
		this.pause.setBorder(BorderFactory.createLoweredBevelBorder());
		this.pause.setOpaque(true);
		this.layout.add(this.pause);
		
		this.day = new JLabel ("Day 0");
		
		this.gameBoard.add(this.layout);
		this.gameBoard.repaint();
	}

	public void createVictims()
	{
		for (int i = 0; i <= this.victims.length-1; i++)
		{
			this.victims[i] = new Person(); 	
		}
	}
	
	public void createTimerTask()
	{
		this.task = new TimerTask()
		{
			public void run() 
			{
				dayCount++;
				day.setText("Day " + dayCount);
			}
			
		};
	}
	
//	public void createMouseAdapter() 
//	{
//		this.ma = new MouseAdapter()
//		{
//			public void MouseMoved(MouseEvent e)
//			{
//				
//			}
//		};
//	}
	
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e)
	{
		
	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
	
	}

	public void keyPressed(KeyEvent e) 
	{
		
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	public static void main(String args[])
	{
		CovidGame cg = new CovidGame();
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	public void mouseMoved(MouseEvent e) 
	{
		if (e.getSource() instanceof JLabel)
		{
			
		}		
	}
	
}
