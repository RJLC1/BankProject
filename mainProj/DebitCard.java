package mainProj;

public class DebitCard extends Card {

	// Constructor

	public DebitCard(OrderAccount associatedO_Acc) {
		
		super(associatedO_Acc, 'D');
		this.getAssociatedO_Acc().getD_Cards().add(this);
		
	}
	
	//Setters
	
	public void setCardType(char cardType) {

		if (cardType != 'D') {

			System.out.println("DEBIT CARD - Card type invalid.\nValid account types: D for debit");
			return;
		}

		this.cardType = cardType;
	}
}	
