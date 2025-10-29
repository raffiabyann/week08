package week08.raffi.id.umn.ac;

public class CreditCardPayment extends Payment {
	
	private String cardNumber;
	
	public CreditCardPayment(Item amount, String cardNumber) {
		super(amount);
		this.cardNumber=cardNumber;
	}


	@Override
	public int pay() {
		// TODO Auto-generated method stub
		return 0;
	}
}
