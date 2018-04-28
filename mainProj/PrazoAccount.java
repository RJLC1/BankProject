package mainProj;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrazoAccount extends Account {
	
	private ArrayList<String> P_movements = new ArrayList<String>();
	private LocalDate creation;
	private final int years;
	private int remaningYears;
	private final double p_Interests = 0.1;
	
	//Constructor
	
	public PrazoAccount(Client owner, double euros, int years) {
		
		super(owner, 'P', 0);
		this.years=years;
		setRemaningYears(years);
		this.creation = LocalDate.now();
		owner.getP_Accounts().add(this);
		this.deposit(owner.getO_account().getD_Cards().get(0), euros);
		
	}

	//Getters
	
	public ArrayList<String> getP_movements() {
		return P_movements;
	}
	
	public int getYears() {
		return years;
	}

	public double getP_Interests() {
		return p_Interests;
	}
	
	public LocalDate getCreation() {
		return creation;
	}
	
	public int getRemaningYears() {
		return remaningYears;
	}
	
	//Setters

	public void setP_movements(ArrayList<String> p_movements) {
		P_movements = p_movements;
	}
	
	public void setAccountType(char accountType) {
		
		if (accountType != 'P') {

			System.out
					.println("PRAZO ACCOUNT - Account type invalid.\nValid account types: P for prazo");
			return;
		}
		this.accountType = accountType;
		
	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}
	
	public void setRemaningYears(int remaningYears) {
		this.remaningYears = remaningYears;
	}

	
	//Deposit method
	
	public void deposit(Card myCard, double value) {

		//if initial deposit -OK else -NOT ALLOWED
		
		if(value<1) {
			
			System.out.println("PRAZO ACCOUNT - Invalid value parameter - value must be positive\n");
			return;
		}
		
		if(this.getEuros()==0 && this.getRemaningYears()==this.getYears()) {
			
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros()+value);
			this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros()-value);
			this.setEuros(value);
			LocalDate movDate = Period.getAdvancedDate();
			String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
					+ " ; Type: deposit\n";
			this.P_movements.add(message);
			return;
			
		}
		
		System.out.println("PRAZO ACCOUNT - Deposit unauthorized - you can't make movements on a Prazo account\n");

	}
	
	//Withdraw method
	
	public void withdraw(Card myCard, double value) {

		System.out.println("PRAZO ACCOUNT - Withdraw unauthorized - you can't make movemetns on a Prazo account ");

	}
	
	//Transfer method
	
	public void transfer(Account otherAccount, Card myCard, double value) {
		
		if (value < 1) {

			System.out.println("PRAZO ACCOUNT - Invalid value parameter - value must be positive");
			return;
		}
		
		if(otherAccount.equals(this)) {
			
			System.out.println("PRAZO ACCOUNT - Can't transfer to the same account");
			return;
			
		}
		
		if(this.getRemaningYears()==0) {
			//You can only transfer from prazo account (never to a prazo account) when remaining years = 0
			
			if (otherAccount.getAccountType() == 'O') {

				if (this.getEuros() >= value) {

					this.setEuros(this.getEuros() - value);
					this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() + value);
					this.getOwner().getO_account().setEuros(this.getOwner().getO_account().getEuros() - value);
					otherAccount.setEuros(otherAccount.getEuros() + value);
					LocalDate movDate = Period.getAdvancedDate();
					String message = "Date: " + movDate + " ; Card: " + myCard.getNumber() + " ; Value: " + value
							+ " ; Type: transfer\n";
					this.P_movements.add(message);
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
					this.P_movements.add(message);
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
					this.P_movements.add(message);
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
					this.P_movements.add(message);
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
		System.out.println("PRAZO ACCOUNT - Transfer unauthorized - you can't make transfers on a Prazo account until contractual time has ended");
		
	}




}
