package mainProj;

public abstract class Account {

	public static int id = 1000;

	// Fields

	private final int number = ++id;
	private Client owner;
	protected char accountType; // 'P' - prazo; 'O' - ordem; 'S' - savings
	private double euros;
	
	public Account(Client owner, char accountType, double euros) {

		setOwner(owner);
		setAccountType(accountType);
		setEuros(euros);

	}
	
	// Getters

	public Client getOwner() {
		return owner;
	}

	public char getAccountType() {
		return accountType;
	}

	public int getNumber() {
		return number;
	}

	
	public double getEuros() {
		return euros;
	}

	
	//Setters
	
	public void setOwner(Client owner) {

		this.owner = owner;
	}

	public void setAccountType(char accountType) {

		if (accountType != 'P' && accountType != 'O' && accountType != 'S') {

			System.out
					.println("ACCOUNT - Account type invalid.\nValid account types: P for prazo, O for ordem and S for savings");
			return;
		}
		this.accountType = accountType;
	}

	public void setEuros(double euros) {
		
		if(euros<0) System.out.println("ACCOUNT - Invalid euros - Must be 0 or positive");
		this.euros = euros;
	}

	//toString
	
	public String toString() {

		String message = "\nACCOUNT INFO: \n" + "Owner:              " + this.getOwner().getName()
				+ "\nType:               " + this.getAccountType() + "\nEuros:              "
				+ this.getEuros();
		return message;

	}
}
