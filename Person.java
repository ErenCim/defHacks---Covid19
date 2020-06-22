/**
 * @(#)Person.java
 * Class for each person in the game.
 * Eren Cimentepe
 * Start Date: 06/01/2019
 * End Date: 21/01/2019
 */

import java.util.Random;
import javax.swing.*;

public class Person 
{
	boolean status; 
	boolean preExistCon; 
	int age; 
	char gender; 
	String ethnicity;
	JButton avatar;
	boolean immune;
	
	public Person()
	{
		this.preExistCon = false;
		this.avatar = new JButton(); 
		this.age = 0; 
		this.immune = false; 
		this.status = false;
		this.gender = ' ';
		this.ethnicity = "";
	}

	public Person(boolean precon, int a, String e, char gender) 
	{
		this.preExistCon = precon;
		this.avatar = new JButton();
		this.status = false; 
		this.immune = false; 
		this.age = a;
		this.ethnicity = e;	
		this.gender= gender;
	}
	
	public String toString()
	{
		return "Pre-existing condition: " + this.preExistCon + "\n\nAge: " + this.age + "\n\nGender: "  + this.gender + "\n\nEthnicity: " + this.ethnicity; 
	}
	
	public static void main(String args[]) 
	{
		//Person p = new Person();
		//System.out.println(p);
	}
}
