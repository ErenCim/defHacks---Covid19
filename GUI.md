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

	Random randomizer;
	
	public CovidGame()
	{
		//this.layout = new JLayeredPane();
		this.createGUI();
		this.randomizer = new Random();
		this.dayCount = 0; 
		this.timer = new Timer(); 
		this.victims = new Person[11][13];
		this.createVictims();
		this.createTimerTask();
	}
	
	public CovidGame(int number)
	{
		//this.layout = new JLayeredPane();
		this.createGUI();
		this.randomizer = new Random();
		this.dayCount = 0; 
		this.timer = new Timer();
		this.victims = new Person[number - 10][10];
		this.createVictims();
		this.createTimerTask();
	}
	
	public void createGUI()
	{
		this.gameBoard = new JFrame();
		
		this.gameBoard.setSize(1100, 800);
		this.gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameBoard.setLayout(null);
		this.gameBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.gameBoard.setVisible(false);
		
		//this.layout.setSize(1100, 800);
		//this.gameBoard.add(this.layout);
		
		this.start = new JButton("Start");
		this.start.setSize(150, 50);
		this.start.setLocation(900, 500);
		this.start.addActionListener(this);
		this.start.setBackground(Color.white);
		this.start.setBorder(BorderFactory.createLoweredBevelBorder());
		this.start.setOpaque(true);
		//this.start.setToolTipText("WORKING");
		this.gameBoard.add(this.start);
		
		this.pause = new JButton("Pause");
		this.pause.setSize(150, 50);
		this.pause.setLocation(900, 430);
		this.pause.addActionListener(this);
		this.pause.setBackground(Color.white);
		this.pause.setBorder(BorderFactory.createLoweredBevelBorder());
		this.pause.setOpaque(true);
		this.gameBoard.add(this.pause);
		
		this.day = new JLabel ("Day 0");
		
		this.day = new JLabel ("Day 0", SwingConstants.CENTER);
		this.day.setSize(150, 50);
		this.day.setLocation(900, 100);
		this.day.setBackground(Color.white);
		this.day.setOpaque(true);
		this.day.setBorder(BorderFactory.createLineBorder(Color.black));
		this.gameBoard.add(this.day);
		
		this.gameBoard.repaint();
		this.gameBoard.setVisible(true);
	}

	public void createVictims()
	{	
		int xlocation = 50; 
		int ylocation = 50;
		
		for (int i = 0; i <= this.victims.length-1; i++)
		{
			xlocation = 50; 
			
			for (int y = 0; y <= this.victims[i].length-1; y++)
			{
				this.victims[i][y] = new Person(this.preCondition(), this.age(), this.ethnicity(), this.gender()); 	
				this.victims[i][y].avatar.setLocation(xlocation, ylocation);
				this.victims[i][y].avatar.setSize(40, 40);
				this.victims[i][y].avatar.setBackground(Color.DARK_GRAY);
				this.victims[i][y].avatar.setOpaque(true);
				this.gameBoard.add(this.victims[i][y].avatar);
				this.victims[i][y].avatar.addMouseMotionListener(this);
				this.victims[i][y].avatar.addMouseListener(this);
				this.victims[i][y].avatar.setBorder(BorderFactory.createLoweredBevelBorder());
				this.victims[i][y].avatar.setToolTipText(this.victims[i][y].toString());
				xlocation += 55;
			}
			ylocation += 55;
		
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
public boolean preCondition() 
	{
		int rndNum = randomizer.nextInt(1);
		
		if (rndNum == 0)
			return true;
		else
			return false;	
	}

	public int age() 
	{
		int age = randomizer.nextInt(90);
		return age; 
	}

	public String ethnicity() 
	{
		String[] e = new String[] {"African Americam", "Caucasian", "Indigenous", "Asian", "Native Hawaiian", "Hispanic"};
		return e[randomizer.nextInt(5)];
	}

	public char gender() 
	{
		int rndNum = randomizer.nextInt(1);
		if (rndNum == 0)
			return 'M';
		else
			return 'F';
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
		if (e.getSource() instanceof JLabel)
		{
			this.searchArray((JLabel)e.getSource());
		}	
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
		//System.out.println("WORKING");
		if (e.getSource() instanceof JLabel)
		{
			//this.searchArray((JLabel)e.getSource());
		}		
	}
	
	public void searchArray(JLabel given)
	{
		for (int i = 0; i <= this.victims.length-1; i ++)
		{
			for (int y = 0; y <= this.victims[i].length-1; y++)
			{
				if (this.victims[i][y].avatar == given)
				{
					//System.out.println(this.victims[i][y]); 
					this.victims[i][y].avatar.setToolTipText("<html>Age: " + this.victims[i][y].age + "<br><br>Gender: "  + this.victims[i][y].gender + "<br><br>Ethnicity: " + this.victims[i][y].ethnicity + "<br><br>Pre-existing condition: " + this.victims[i][y].preExistCon + "<html>");
					//this.victims[i][y].avatar.setToolTipText(this.victims[i][y].toString());
					//this.gameBoard.repaint();
				}	
			}
		}
	}
}

