package university;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Person {
	private static int nextID = 1;
	private int id;
	private int age;
	private String name;
	
	//0 is a default flag value for unknown age
	public Person() {
		this("unknown", 0);
	}

	public Person(String name, int age) {
		this.id = nextID++;
		setName(name);
		setAge(age);
	}
	
	public static void printPersons(ArrayList<? extends Person> persons) {
		for(Person p: persons) {
			System.out.println(p);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && this.getName().equalsIgnoreCase(other.getName());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		}
		else
			throw new PersonException("Age must be non-negative.");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
