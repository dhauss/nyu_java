package university;

import java.util.ArrayList;

public class PersonDriver {

	public static void main(String[] args) {
		Affiliate j = new Affiliate();
		Affiliate o = new Affiliate("jon", 25, "UC Davis");
		Affiliate jon = new Affiliate("jon", 25, "uC Davis");
		
		Undergraduate jake = new Undergraduate("JAKE", 98, "cs", true);
		Undergraduate jake2 = new Undergraduate("jake", 98, "CS", true);
		
		Undergraduate jonjayGrad = new Undergraduate("jonjay", 98, "baskets", false);
		GraduateStudent jonjay = new GraduateStudent("jonjay", 98, "baskets", false, true);
		GraduateStudent jonjay2 = new GraduateStudent("jonjay", 98, "baskets", false, false);

		Staff bro = new Staff("bro", 987, 12.344, "bro king");
		Staff bro2 = bro;

		Faculty broPro = new Faculty("bro pro", 987, 12344, "bro pro king", true, "Anthro");
		Faculty broPro2 = new Faculty("bro pro", 987, 12344, "bro pro king", true, "AntHro");

		
		//System.out.println(jonjayGrad.equals(jonjay));
		
		ArrayList<Employee> al = new ArrayList<>();
		/*
		al.add(jake2);
		al.add(jonjay);
		*/
		al.add(bro);
		al.add(broPro);
		
		
		Person.printPersons(al);

	}

}
