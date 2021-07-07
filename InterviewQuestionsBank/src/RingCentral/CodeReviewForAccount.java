package RingCentral;

public class CodeReviewForAccount {
	
	public static void main(String args[]) {
	}

}

class Account{
	
	private Integer id;		//make this UUId
	private AccountType type;
	private double balanceAmount; // make this BigDecimal to have set precision
	
	enum AccountType {		// Move this enum outside this class declaration
		REGULAR, VP
	}
	
	Account(int id, double balanceAmount){
		configure();		//if this line is used here, as the id and amount have yet not been done so, the calculation based on this wont work. So put it below line 25
		this.id = id;
		this.balanceAmount = balanceAmount;
	}

	protected void configure() {	//As this method is protected so can be overridden in the subclass, which can corrupt the logic of initialization, so make it private
		
		//this method uses the id and balanceAmount to decide the accountType
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getBalanceAmount() {
		return this.balanceAmount;
	}
	
	public AccountType getType() {
		return this.type;
	}
	
	public boolean equals(Account o) {  //if we add @Override on top of this method, then we need to have Object in param, 
										//and then we need to check for the instanceOf o, to verify if the type matches or not before going for ==
		if(o == null)
			return false;
		if(this == o)
			return true;
		
		return this.id.equals(o.getId());
	}
}


