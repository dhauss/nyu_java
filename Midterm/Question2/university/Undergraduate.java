package university;

import java.util.Objects;

public class Undergraduate extends Student {
	//assuming isMatriculated applies to grads as well
	private boolean isMatriculated;

	public Undergraduate() {
		super();
		setIsMatriculated(false);
	}

	public Undergraduate(String name, int age, String department, boolean isMatriculated) {
		super(name, age, department);
		setIsMatriculated(isMatriculated);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Undergraduate other = (Undergraduate) obj;
		return isMatriculated == other.isMatriculated;
	}

	@Override
	public String toString() {
		return "Undergraduate [isMatriculated=" + isMatriculated +
				"] which is a subclass of " + super.toString();
	}

	public boolean getIsMatriculated() {
		return isMatriculated;
	}

	public void setIsMatriculated(Boolean isMatriculated) {
		this.isMatriculated = isMatriculated;
	}

}
