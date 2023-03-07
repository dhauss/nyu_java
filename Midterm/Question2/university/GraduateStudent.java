package university;


//extends Undergraduate instead of Student assuming isMatriculated also applies to grad students
public class GraduateStudent extends Undergraduate {
	private boolean isPhD;

	public GraduateStudent() {
		super();
		setPhD(false);
	}

	public GraduateStudent(String name, int age, String department, boolean isMatriculated, boolean isPhD) {
		super(name, age, department, isMatriculated);
		setPhD(isPhD);
	}

	@Override
	public String toString() {
		return "GraduateStudent [isPhD=" + isPhD + "] which is a subclass of " + super.toString();
	}

	public boolean isPhD() {
		return isPhD;
	}

	public void setPhD(boolean isPhD) {
		this.isPhD = isPhD;
	}

}
