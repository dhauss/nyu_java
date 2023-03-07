package university;

import java.util.Objects;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj)) {
			System.out.println("Gotcha");
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Affiliate other = (Affiliate) obj;
		return this.getInstitution().equalsIgnoreCase(other.getInstitution());
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
