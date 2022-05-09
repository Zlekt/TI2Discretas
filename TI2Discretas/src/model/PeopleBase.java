package model;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class PeopleBase {
	AVL_Tree tree;
	ArrayList<Person> peopleArrayList;
	
	public PeopleBase() {
		tree = new AVL_Tree();
		peopleArrayList=new ArrayList<Person>();
	}
	
	public void importData() {
		ArrayList<String> nameArrayList= new ArrayList<String>();
		ArrayList<String> surnameArrayList= new ArrayList<String>();
		ArrayList<String> countryArrayList=new ArrayList<String>();
		String file = ".\\data\\babynames-clean.csv";
		BufferedReader reader = null;
		String line ="";
		
		try {
			reader=new BufferedReader(new FileReader(file));
			reader.readLine();	
			while((line=reader.readLine()) !=null) {
				
				String[] row = line.split(",");
				nameArrayList.add(row[0].toUpperCase());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File surnameFile= new File(".\\data\\Names_2010Census.csv");
			FileReader surNameReader=new FileReader(surnameFile);
			reader = new BufferedReader(surNameReader);
			reader.readLine();	
			while((line=reader.readLine()) !=null) {
				
				String[] row = line.split(",");
				surnameArrayList.add(row[0]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			File countryFile= new File(".\\data\\population_by_country_2020.csv");
			FileReader countryReader=new FileReader(countryFile);
			reader = new BufferedReader(countryReader);
			reader.readLine();	
			while((line=reader.readLine()) !=null) {
				
				String[] row = line.split(",");
				countryArrayList.add(row[0]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random random = new Random();
		
		
		
		ArrayList<Person> people = new ArrayList();
		
		for (int i=0; i<1000000;i++) {
			int nameNum=random.nextInt(nameArrayList.size());
			int surNameNum=random.nextInt(surnameArrayList.size());
			int countryNum=random.nextInt(countryArrayList.size());
			
			people.add(new Person(nameArrayList.get(nameNum), surnameArrayList.get(surNameNum),countryArrayList.get(countryNum)));	
		}
		
		for(int i=0; i<people.size(); i++)
		{
			tree.insert(people.get(i));
		}
		peopleArrayList.addAll(people);
		
	}
	
	public void addPerson(String n, String sn,String country, GregorianCalendar dob, int gender) {
		Person personobj=new Person(n, n, country, dob, gender);
		peopleArrayList.add(personobj);
		tree.insert(personobj);
	}
	
	public void inputData() {
		try {
			FileInputStream fileIn = new FileInputStream(".\\data\\PeopleDB.csv");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Person> p;
			
			while(true) {
				
				p = (ArrayList<Person>)in.readObject();
				peopleArrayList.addAll(p);
				
			}
			
		}catch(EOFException e) {
		}catch(IOException e2) {
		}catch(ClassNotFoundException e3) {
		}
		
		for(int i=0; i<peopleArrayList.size(); i++)
		{
			tree.insert(peopleArrayList.get(i));
		}
	}
	
	public void outputData() {
		try {
			FileOutputStream fileOut = new FileOutputStream(".\\data\\PeopleDB.csv");
			ObjectOutputStream out;
			out = new ObjectOutputStream(fileOut);
			out.reset();
			
			out.writeObject(peopleArrayList);
			
			
			out.close();
			fileOut.close();	
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
