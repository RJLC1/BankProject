package mainProj;

public class CreditCard extends Card {

	// Fields

	private double plafond;

	// Constructor

	public CreditCard(OrderAccount associatedO_Acc, double plafond) {
		
		super(associatedO_Acc, 'C');
		setPlafond(plafond);
		this.getAssociatedO_Acc().getC_Cards().add(this);

	}

	// Getters

	public double getPlafond() {
		return plafond;
	}

	// Setters

	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	public void setCardType(char cardType) {

		if (cardType != 'C') {

			System.out.println("CREDIT CARD - Card type invalid.\nValid account types: C for credit");
			return;
		}

		this.cardType = cardType;
	}
	
	//toString override
	
	public String toString() {

		String message = "\nCARD INFO: \n" + "Associated account: " + this.getAssociatedO_Acc().getNumber()
				+ "\nType:               " + this.getCardType() + "\nPlafond:            " + this.getPlafond();
		return message;

	}
	
	
	
}
