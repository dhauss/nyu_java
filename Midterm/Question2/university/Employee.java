package university;

import java.util.Objects;

public abstract class Employee extends Person {
	private double salary;

	public Employee() {
		super();
		setSalary(0);
	}

	public Employee(String name, int age, double salary) {
		super(name, age);
		setSalary(salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "Employee [salary=$" + String.format("%,.2f", salary) + "] which is a subclass of " + super.toString();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary >= 0) {
			this.salary = salary;
		}
		else {
			throw new PersonException("Salary must be non-negative");
		}
	}

}
