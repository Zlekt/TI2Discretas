package model;

public class Person implements Comparable<Person>{
	private String name;
	private String surname;
	
	
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
