package mainProj;

import java.time.LocalDate;
import java.util.ArrayList;

public class SavingsAccount extends Account {

	// Fields

	private ArrayList<String> S_movements = new ArrayList<String>();
	private LocalDate creation;
	private final double s_Interests = 0.05;

	// Constructor

	public SavingsAccount(Client owner, double euros) {

		super(owner, 'S', 0);
		this.creation = LocalDate.now();
		owner.getS_Accounts().add(this);
		this.deposit(owner.getO_account().getD_Cards().get(0), euros);

	}

	// Getters
	
	public ArrayList<String> getS_movements() {
		return S_movements;
	}
	
	public LocalDate getCreation() {
		return creation;
	}

	public double getS_Interests() {
		return s_Interests;
	}
	
	// Setters

	public void setS_movements(ArrayList<String> s_movements) {
		S_movements = s_movements;
	}
	
	public void setAccountType(char accountType) {

		if (accountType != 'S') {

			System.out.println("SAVINGS ACCOUNT - Account type invalid.\nValid account types: S for savings");
			return;
		}
		this.accountType = accountType;

	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}

	// Deposit method

	public void deposit(Card myCard, double value) {

		if (value < 1) {

			System.out.println("SAVINGS ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}

		this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
		this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
		this.setEuros(this.getEuros() + value);
		LocalDate movDate = Period.getAdvancedDate();
		String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
				+ " ; Type: deposit\n";
		this.S_movements.add(message);

	}

	// Withdraw method

	public void withdraw(Card myCard, double value) {

		if (value < 1) {

			System.out.println("SAVINGS ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}

		if (this.getEuros() >= value) {

			this.setEuros(this.getEuros() - value);
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
			LocalDate movDate = Period.getAdvancedDate();
			String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
					+ " ; Type: withdraw\n";
			this.S_movements.add(message);
			return;

		} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

			((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - this.getEuros()));
			this.setEuros(0);
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
			LocalDate movDate = Period.getAdvancedDate();
			String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
					+ " ; Type: withdraw\n";
			this.S_movements.add(message);
			return;

		} else {

			System.out.println("SAVINGS ACCOUNT- Withdraw unauthorized - not enough money");
			return;

		}

	}

	// Transfer method

	public void transfer(Account otherAccount, Card myCard, double value) {

		if (value < 1) {

			System.out.println("SAVINGS ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}
		
		if(otherAccount.equals(this)) {
			
			System.out.println("SAVINGS ACCOUNT - Can't transfer to the same account");
			return;
			
		}

		if (otherAccount.getAccountType() == 'O') {

			if (this.getEuros() >= value) {

				this.setEuros(this.getEuros() - value);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.S_movements.add(message);
				return;

			} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

				double j = this.getEuros();
				this.setEuros(0);
				((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - j));
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.S_movements.add(message);
				return;

			} else {

				System.out.println("SAVINGS ACCOUNT1 - Transfer unauthorized - not enough money");
				return;
			}

		}

		if (otherAccount.getAccountType() == 'S') {

			if (this.getEuros() >= value) {

				this.setEuros(this.getEuros() - value);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() + value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.S_movements.add(message);
				return;

			} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

				double j = this.getEuros();
				this.setEuros(0);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + j);
				this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - j);
				((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - j));
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() + value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.S_movements.add(message);
				return;

			} else {

				System.out.println("SAVINGS ACCOUNT2 - Transfer unauthorized - not enough money");
				return;
			}

		}

		if (otherAccount.getAccountType() == 'P') {

			System.out.println("SAVINGS ACCOUNT3 - You can't transfer to a Prazo account");
			return;

		}

	}

	
}	
