package university;

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
