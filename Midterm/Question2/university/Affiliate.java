package university;

public class Affiliate extends Person {
	//institution to which the affiliate actually belongs
	private String institution;
	
	public Affiliate() {
		super();
		setInstitution("unknown");
	}
	
	public Affiliate(String name, int age, String institution) {
		super(name, age);
		setInstitution(institution);
	}
	
	@Override
	public String toString() {
		return "Affiliate [institution=" + institution + "] which is a subclass of "
				+ super.toString();
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	

}
