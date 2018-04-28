package mainProj;

public abstract class Card {

	public static int id = 2000;

	// Fields

	private final int number=++id;
	private OrderAccount associatedO_Acc;
	protected char cardType; // 'D'- debit; 'C'- credit
	
	//Constructor
	
	public Card(OrderAccount associatedO_Acc, char cardType) {

		setCardType(cardType);
		setAssociatedO_Acc(associatedO_Acc);		

	}
	
	// Getters

	public char getCardType() {
		return cardType;
	}

	public int getNumber() {
		return number;
	}
	
	public OrderAccount getAssociatedO_Acc() {
		return associatedO_Acc;
	}
	
	// Setters

	public void setCardType(char cardType) {

		if (cardType != 'D' && cardType != 'C') {

			System.out.println("CARD - Card type invalid.\nValid account types: C for credit, D for debit");
			return;
		}

		this.cardType = cardType;
	}

	public void setAssociatedO_Acc(OrderAccount associatedO_acc) {
		this.associatedO_Acc = associatedO_acc;
	}

	//toString
	
	public String toString() {

		String message = "\nCARD INFO: \n" + "Associated account: " + this.getAssociatedO_Acc().getNumber()
				+ "\nType:               " + this.getCardType();
		return message;

	}


}
