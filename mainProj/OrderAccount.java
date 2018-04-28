package mainProj;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderAccount extends Account {

	// Fields

	private ArrayList<DebitCard> d_Cards = new ArrayList<DebitCard>();
	private ArrayList<CreditCard> c_Cards = new ArrayList<CreditCard>();;
	private ArrayList<String> O_movements = new ArrayList<String>();

	// Constructor

	public OrderAccount(Client owner, double euros) {

		super(owner, 'O', 0);
		this.d_Cards.add(new DebitCard(this));
		this.deposit(this.d_Cards.get(0), euros);

	}

	// Getters

	public ArrayList<DebitCard> getD_Cards() {
		return d_Cards;
	}

	public ArrayList<CreditCard> getC_Cards() {
		return c_Cards;
	}

	public ArrayList<String> getO_movements() {
		return O_movements;
	}

	// Setters

	public void setD_Cards(ArrayList<DebitCard> d_Cards) {
		this.d_Cards = d_Cards;
	}

	public void setC_Cards(ArrayList<CreditCard> c_Cards) {
		this.c_Cards = c_Cards;
	}

	public void setAccountType(char accountType) {

		if (accountType != 'O') {

			System.out.println("ORDER ACCOUNT - Account type invalid.\nValid account types: O for ordem");
			return;
		}
		this.accountType = accountType;

	}

	public void setO_movements(ArrayList<String> o_movements) {
		O_movements = o_movements;
	}

	// Deposit method

	public void deposit(Card myCard, double value) {

		if(value<1) {
			
			System.out.println("ORDER ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}
		
		this.setEuros(this.getEuros() + value);
		LocalDate movDate = Period.getAdvancedDate();
		String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
				+ " ; Type: deposit\n";
		this.O_movements.add(message);

	}
	// Withdraw method

	public void withdraw(Card myCard, double value) {

		if(value<1) {
			
			System.out.println("ORDER ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}
		
		if (this.getEuros() >= value) {

			this.setEuros(this.getEuros() - value);
			LocalDate movDate = Period.getAdvancedDate();
			String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
					+ " ; Type: withdraw\n";
			this.O_movements.add(message);
			return;

		} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

			((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - this.getEuros()));
			this.setEuros(0);
			LocalDate movDate = Period.getAdvancedDate();
			String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
					+ " ; Type: withdraw\n";
			this.O_movements.add(message);
			return;

		} else {

			System.out.println("ORDER ACCOUNT- Withdraw unauthorized - not enough money");
			return;

		}
	}

	// Transfer method

	// DECISION - ONLY ONE MOVEMENT RESGISTRY FOR EACH TRANSFER, SAVED ON THE ORIGIN
	// ACCOUNT OBJECT

	public void transfer(Account otherAccount, Card myCard, double value) {

		if(value<1) {
			
			System.out.println("ORDER ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}
		
		if(otherAccount.equals(this)) {
			
			System.out.println("ORDER ACCOUNT - Can't transfer to the same account");
			return;
			
		}
		
		if (otherAccount.getAccountType() == 'O') {

			if (this.getEuros() >= value) {

				this.setEuros(this.getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.O_movements.add(message);
				return;

			} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

				double j = this.getEuros();
				this.setEuros(0);
				((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - j));
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.O_movements.add(message);
				return;

			} else {

				System.out.println("ORDER ACCOUNT1 - Transfer unauthorized - not enough money");
				return;
			}

		}

		if (otherAccount.getAccountType() == 'S') {

			if (this.getEuros() >= value) {

				this.setEuros(this.getEuros() - value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() + value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.O_movements.add(message);
				return;

			} else if (myCard.getCardType() == 'C' && (this.getEuros() + ((CreditCard) myCard).getPlafond()) >= value) {

				double j = this.getEuros();
				this.setEuros(0);
				((CreditCard) myCard).setPlafond(((CreditCard) myCard).getPlafond() - (value - j));
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() + value);
				otherAccount.getOwner().getO_account()
						.setEuros(otherAccount.getOwner().getO_account().getEuros() - value);
				otherAccount.setEuros(otherAccount.getEuros() + value);
				LocalDate movDate = Period.getAdvancedDate();
				String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
						+ " ; Type: transfer\n";
				this.O_movements.add(message);
				return;

			} else {

				System.out.println("ORDER ACCOUNT2 - Transfer unauthorized - not enough money");
				return;
			}

		}

		if (otherAccount.getAccountType() == 'P') {

			System.out.println("ORDER ACCOUNT3 - You can't transfer from or to a Prazo account");
			return;

		}

	}

}