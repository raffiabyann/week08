package week08.raffi.id.umn.ac;

public class BankTransferPayment extends Payment{
	private String bankAccount;
	public BankTransferPayment(Item amount, String bankAccount) {
		super(amount);
		this.bankAccount=bankAccount;

	}
	@Override
	public int pay() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
