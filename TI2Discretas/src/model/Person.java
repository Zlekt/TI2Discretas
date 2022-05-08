package model;

<<<<<<< HEAD
public class Person implements Comparable<Person>{
	private String name;
	private String surname;
	
	public Person(String name, String surname)
	{
		this.surname=surname;
		this.name=name;
=======
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Random;

public class Person implements Comparable<Person>,Serializable{
	private static final int MALE = 0;
	private static final int FEMALE= 1;
	private String name;
	private String surname;
	private int gender;
	private GregorianCalendar bDay;
	private String country;
	
	public Person(String name, String surname,String country)
	{
		this.surname=surname;
		this.name=name;
		Random random = new Random();
		int genderNum=random.nextInt(2);
		switch (genderNum) {
			case 0:gender=MALE;
				break;
			case 1:gender=FEMALE;
				break;
		}
		
		bDay = new GregorianCalendar();

        int year = random.ints(1900, 2010).findFirst().getAsInt();

        bDay.set(bDay.YEAR, year);

        int dayOfYear = random.ints(1, bDay.getActualMaximum(bDay.DAY_OF_YEAR)).findFirst().getAsInt();

        bDay.set(bDay.DAY_OF_YEAR, dayOfYear);

        this.country=country;
		

	}
	
	public Person(String name, String surname,String country, GregorianCalendar dob, int gender)
	{
		this.name=name;
		this.surname=surname;
		this.country=country;
		this.bDay=dob;
		this.gender=gender;
>>>>>>> DevJuan
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public int compareTo(Person o) {
		int result=this.surname.compareTo(o.surname);
		if(result==0)
		{
			result=this.name.compareTo(o.name);
		}
		return result;
	}
	
	public String toString()
	{
		String out=name+" "+surname;
		return out;
	}
}
