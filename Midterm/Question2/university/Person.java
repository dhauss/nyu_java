package university;

import java.util.ArrayList;

public abstract class Person {
	private static int nextID = 1;
	private int id;
	private int age;
	
	public Person() {
		
	}
	
	public Person(int age) {
		
	}
	
	public static void printPersons(ArrayList<? extends Person> persons) {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

}
