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
	JButton next; 
	JButton isolation; 
	int dayCount; 
	Person[][] victims; 
	JLabel day; 
	//JLayeredPane layout;
	Timer timer; 
	TimerTask task; 
	JLabel hovered; 
	//MouseAdapter ma; 
	
	JButton handSanitizer;
	int sanitizerCount; 
	 
	ArrayList<Person> infected; 
	JLabel numInfected; 
	Random randomizer; 
	
	//int deathCount; 
	
	public CovidGame()
	{
		//this.layout = new JLayeredPane();
		this.createGUI();
		this.infected = new ArrayList<Person>();
		this.randomizer = new Random();
		this.dayCount = 0; 
		this.timer = new Timer(); 
		this.victims = new Person[14][20];
		this.createVictims();
		this.createTimerTask();
		this.infect();
	}
	
	public CovidGame(int number)
	{
		//this.layout = new JLayeredPane();
		this.createGUI();
		this.infected = new ArrayList<Person>();
		this.randomizer = new Random();
		this.dayCount = 0; 
		this.timer = new Timer();
		this.victims = new Person[number/10][10];
		this.createVictims();
		this.createTimerTask();
		this.infect();
	}
	
	public void createGUI()
	{
		this.gameBoard = new JFrame();
		
		this.gameBoard.setSize(1400, 850);
		this.gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameBoard.setLayout(null);
		this.gameBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.gameBoard.setVisible(false);
		
		//this.layout.setSize(1100, 800);
		//this.gameBoard.add(this.layout);
		
		this.next = new JButton("Next Day");
		this.next.setSize(150, 50);
		this.next.setLocation(1200, 500);
		this.next.addActionListener(this);
		this.next.setBackground(Color.white);
		this.next.setBorder(BorderFactory.createLoweredBevelBorder());
		this.next.setOpaque(true);
		//this.start.setToolTipText("WORKING");
		this.gameBoard.add(this.next);
		
		this.isolation = new JButton("Pause");
		this.isolation.setSize(150, 50);
		this.isolation.setLocation(1200, 430);
		this.isolation.addActionListener(this);
		this.isolation.setBackground(Color.white);
		this.isolation.setBorder(BorderFactory.createLoweredBevelBorder());
		this.isolation.setOpaque(true);
		this.gameBoard.add(this.isolation);
		
		this.day = new JLabel ("Day 0", SwingConstants.CENTER);
		this.day.setSize(150, 50);
		this.day.setLocation(1200, 100);
		this.day.setBackground(Color.white);
		this.day.setOpaque(true);
		this.day.setBorder(BorderFactory.createLineBorder(Color.black));
		this.gameBoard.add(this.day);
		
		this.numInfected = new JLabel ("Infected Number: 0", SwingConstants.CENTER);
		this.numInfected.setSize(150, 50);
		this.numInfected.setLocation(1200, 170);
		this.numInfected.setBackground(Color.white);
		this.numInfected.setOpaque(true);
		this.numInfected.setBorder(BorderFactory.createLineBorder(Color.black));
		this.gameBoard.add(this.numInfected);
		
		this.handSanitizer = new JButton ("Sanitizing");
		this.handSanitizer.setSize(150, 50);
		this.handSanitizer.setLocation(1200, 360);
		this.handSanitizer.addActionListener(this);
		this.handSanitizer.setBackground(Color.white);
		this.handSanitizer.setBorder(BorderFactory.createLoweredBevelBorder());
		this.handSanitizer.setOpaque(true);
		this.gameBoard.add(this.handSanitizer);
		
		this.gameBoard.repaint();
		this.gameBoard.setVisible(true);
		
	}

	public void createVictims()
	{
		int xlocation = 30; 
		int ylocation = 30;
		
		for (int i = 0; i <= this.victims.length-1; i++)
		{
			xlocation = 30; 
			
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
	}

	public void infect()
	{
		this.infected.add(this.victims[this.randomizer.nextInt(this.victims.length)][this.randomizer.nextInt(this.victims[0].length)]);
		this.infected.get(this.infected.size()-1).avatar.setBackground(Color.red);
		this.infected.get(this.infected.size()-1).status = true; 
		this.numInfected.setText("<html><div style='text-align: center;'>Infected count: 0<html>");
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
		if (e.getSource() instanceof JButton)
		{
			this.searchArray((JButton)e.getSource());
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
		if(e.getSource() == this.next)
		{
			
			for (int i = 0; i<= this.infected.size()-1; i++)
			{
				this.infectTwo(this.infected.get(i).avatar.getX(), this.infected.get(i).avatar.getY());
			}
			
			this.dayCount++; 
			this.day.setText("<html><div style='text-align: center;'> Day " + this.dayCount + "<html>");
			
			//System.out.println(dayCount);
			if(this.dayCount%3 == 0)
			{
				for(int i = 0; i <= this.infected.size()-1; i++)
				{
					int rndNum = this.randomizer.nextInt(100);
					//System.out.println(rndNum);
					int keepTrack = this.checkCondition(this.infected.get(i));
					if(keepTrack ==1 && rndNum <= 5)
					{
						//8 percent chance of dying 
						this.infected.get(i).avatar.setBackground(Color.black);	
						this.infected.get(i).avatar.setText("X");
						this.infected.get(i).avatar.setForeground(Color.black);
						this.infected.remove(i);
					}
					else if(keepTrack ==2 && rndNum <= 8)
					{
						//11% chance of dying
						this.infected.get(i).avatar.setBackground(Color.black);
						this.infected.get(i).avatar.setText("X");
						this.infected.get(i).avatar.setForeground(Color.black);
						this.infected.remove(i);
					}
					else if(keepTrack ==3 && rndNum <= 11)
					{
						//14% chance of dying
						this.infected.get(i).avatar.setBackground(Color.black);
						this.infected.get(i).avatar.setText("X");
						this.infected.get(i).avatar.setForeground(Color.black);
						this.infected.remove(i);
					}
					else if (keepTrack == 0 && rndNum <= 3)
					{
						//5% of dying
						this.infected.get(i).avatar.setBackground(Color.black);
						this.infected.get(i).avatar.setText("X");
						this.infected.get(i).avatar.setForeground(Color.black);
						this.infected.remove(i);
					}
				}
				
			}
			else if (this.dayCount % 7 == 0)
			{
				for (int i = 0; i<= this.infected.size()-1; i++)
				{
					int rndNum = this.randomizer.nextInt(100);
					if (rndNum <= 9 && !this.infected.get(i).avatar.getText().equals("X"))
					{
						this.infected.get(i).status = false; 
						this.infected.get(i).avatar.setBackground(Color.DARK_GRAY);
						this.infected.get(i).immune = true; 
						this.infected.remove(i);
					}
				}
			}
			
			for (int i = 0; i<= this.victims.length-1; i++)
			{
				for (int y = 0; y <= this.victims[i].length-1; y++)
				{
					if (this.victims[i][y].status == true && this.checkDupe(this.victims[i][y]) == false)
					{
						this.infected.add(this.victims[i][y]);
					}
				}
			}
		}
		
		this.numInfected.setText("Infected count: " + this.removeFromArray());
		this.removeFromArray();
	}
	
	public boolean checkDupe(Person dupe)
	{
		for (int i = 0; i <= this.infected.size()-1; i++)
		{
			if (this.infected.get(i) == dupe)
			{
				return true;
			}
		}
		
		return false; 
	}
	
	public int removeFromArray()
	{
		int count = 0; 
		for (int i = 0; i <= this.infected.size()-1; i++)
		{
			if(this.infected.get(i).status == true && !this.infected.get(i).avatar.getText().equals("X"))
			{
				count++;
			}
		}
		return count; 
	}
	
	public void infectTwo(int xlocation, int ylocation) 
	{
		for (int i = 0; i<= this.victims.length-1; i++)
		{
			for (int y = 0; y <= this.victims[i].length-1; y++)
			{
				if ((this.victims[i][y].status == false) && (this.victims[i][y].immune == false)&&
						(this.victims[i][y].avatar.getY() == ylocation + 55 || this.victims[i][y].avatar.getY() == ylocation - 55 || this.victims[i][y].avatar.getY() == ylocation) && 
								(this.victims[i][y].avatar.getX() ==xlocation || this.victims[i][y].avatar.getX() == xlocation + 55 || this.victims[i][y].avatar.getX() == xlocation -55))
				{
					int rndNum = this.randomizer.nextInt(100);
					if (rndNum<= 44)
					{
						//System.out.println("NOT");
						this.victims[i][y].avatar.setBackground(Color.red);
						this.victims[i][y].status = true; 
					}
				}
			}
		}
	}
	
	
	public int checkCondition(Person infected)
	{
		int keepTrack = 0; 
		if(infected.age >= 45)
		{
			keepTrack++;
		}
		else if (infected.preExistCon == true)
		{
			keepTrack++;
		}
		else if(infected.ethnicity.equals("African Americam") || infected.ethnicity.equals("Hispanic"))
		{
			keepTrack++;
		}
		
		return keepTrack; 
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
	}
	
	public void checkLost()
	{
		
	}
	
	public void searchArray(JButton given)
	{
		for (int i = 0; i <= this.victims.length-1; i ++)
		{
			for (int y = 0; y <= this.victims[i].length-1; y++)
			{
				if (this.victims[i][y].avatar == given)
				{
					this.victims[i][y].avatar.setToolTipText("<html>Age: " + this.victims[i][y].age + "<br><br>Gender: "  + this.victims[i][y].gender + "<br><br>Ethnicity: " + this.victims[i][y].ethnicity + "<br><br>Pre-existing condition: " + this.victims[i][y].preExistCon + "<html>");
				}	
			}
		}
	}
}

