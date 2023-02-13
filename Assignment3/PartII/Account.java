 
public class Account {
	private static int count = 0;
	private double balance;
	private int id;
	
	public Account() {
		setBalance(0);
		this.id = count++;
	}
	
	public Account(double startingBalance) {
		setBalance(startingBalance);
		this.id = count++;
	}

	public boolean withdraw(double amount) {
		if(amount > getBalance()) {
			return false;
		}
		
		setBalance(getBalance() - amount);
		return true;
	}
	
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	
	public static void main(String[] args) {
		Account a1 = new Account();
		Account a2 = new Account(100);
		Account a3 = new Account(1000.55);
		
		System.out.println("a1 balance: " + a1.getBalance() + " id: " + a1.getId());
		System.out.println("a2 balance: " + a2.getBalance() + " id: " + a2.getId());
		System.out.println("a3 balance: " + a3.getBalance() + " id: " + a3.getId());
		
		a1.setBalance(500);
		System.out.println(a2.withdraw(50.43));
		a3.deposit(1234);
		System.out.println(a1.withdraw(500.01));


		System.out.println("a1 balance: " + a1.getBalance() + " id: " + a1.getId());
		System.out.println("a2 balance: " + a2.getBalance() + " id: " + a2.getId());
		System.out.println("a3 balance: " + a3.getBalance() + " id: " + a3.getId());

		
	}
	
}
