package university;

import java.util.Objects;

public abstract class Student extends Person {
	private String department;

	public Student() {
		super();
		setDepartment("unknown");
	}

	public Student(String name, int age, String department) {
		super(name, age);
		setDepartment(department);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return this.getDepartment().equalsIgnoreCase(other.getDepartment());
	}

	@Override
	public String toString() {
		return "Student [department=" + department + " which is a subclass of " + super.toString();
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
