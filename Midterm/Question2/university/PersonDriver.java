package university;

public class PersonDriver {

	public static void main(String[] args) {
		Affiliate j = new Affiliate();
		Affiliate o = new Affiliate();
		Affiliate jon = new Affiliate("jon", 25, "UC Davis");
		
		Undergraduate jake = new Undergraduate("jake", 98, "CS", true);
		GraduateStudent jonjay = new GraduateStudent();
		
		System.out.println(jonjay);

	}

}
