package university;

import java.util.Objects;

public class Staff extends Employee {
	String title;

	public Staff() {
		super();
		setTitle("unknown");
	}

	public Staff(String name, int age, double salary, String title) {
		super(name, age, salary);
		setTitle(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return this.getTitle().equalsIgnoreCase(other.getTitle());
	}

	@Override
	public String toString() {
		return "Staff [title=" + title + "] which is a subclass of " + super.toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
