package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PeopleBase {

	public PeopleBase() {
		// TODO Auto-generated constructor stub
	}
	
	public void importData() {
		ArrayList<String> nameArrayList= new ArrayList();
		ArrayList<String> surnameArrayList= new ArrayList();
		
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
		
		Random random = new Random();
		
		
		
		ArrayList<Person> people = new ArrayList();
		
		for (int i=0; i<1000000;i++) {
			int nameNum=random.nextInt(nameArrayList.size());
			int surNameNum=random.nextInt(surnameArrayList.size());
			people.add(new Person(nameArrayList.get(nameNum), surnameArrayList.get(surNameNum)));	
		}
		
	}
}
