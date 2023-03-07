package university;

import java.util.Objects;

public class Faculty extends Staff {
	boolean isTenureTrack;
	//repetition here to preserve separate Faculty/Student branches and be able to inherit title from Staff. Felt like the lesser evil
	String department;

	public Faculty() {
		super();
		setTenureTrack(false);
		setDepartment("unknown");
	}

	public Faculty(String name, int age, double salary, String title, boolean isTenureTrack, String department) {
		super(name, age, salary, title);
		setTenureTrack(isTenureTrack);
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
		Faculty other = (Faculty) obj;
		return this.getDepartment().equalsIgnoreCase(other.getDepartment()) && isTenureTrack == other.isTenureTrack;
	}

	@Override
	public String toString() {
		return "Faculty [isTenureTrack=" + isTenureTrack + ", department=" + department +
				"] which is a subclass of " + super.toString();
	}

	public boolean isTenureTrack() {
		return isTenureTrack;
	}

	public void setTenureTrack(boolean isTenureTrack) {
		this.isTenureTrack = isTenureTrack;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
