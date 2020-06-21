
import java.util.Random;

public class Person {
	
	
	public static void main(String args[]) {
		
		
		
	}
	
	public genPerson() {
		for (int i=0; i <= 50; i++)
			Person i = new Person;
	}
	
	public void preCondition() {
		
		Random r = new Random();
		r.nextInt(1);
		
		if (r == 0)
			preExistCon = true;
		else if(r == 1)
			preExistCon = false;
			
	}
	
	public age() {
		Random r = new Random();
		r.nextInt(90);
		
		age = r;
		
	}
	
	public ethnicity() {
		String[] e;
		e = new String[] {"African Americam", "Caucasian", "Indigenous", "Asian", "Native Hawaiian", "Hispanic"};
		
		Random r = new Random();
		r.nextInt(5);
		
		ethnicity = e[r];
		
	}
	
	public gender() {
		Random r = new Random();
		r.nextInt(1);
		
		if (r == 0)
			gender = "M";
		else if (r == 1)
			gender = "F";
	}
	
	
	boolean preExistCon; 
	int age; 
	String ethnicity;
	char gender;
	
	public Person(boolean precon, int a, String e) {
		
		preExistCon = precon;
		age = a;
		ethnicity = e;
		
	}
	
	
	public Person()
	{
		this.preExistCon = "";
		this.age = 0; 
		this.gender = ""
		this.ethnicity = "";
	}

	public Person(boolean precon, int a, String e, char gender) 
	{
		this.preExistCon = precon;
		this.age = a;
		this.ethnicity = e;	
		this.gender= gender;
		
	}

}
