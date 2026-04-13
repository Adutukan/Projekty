
public class Bank {
public static void moneyTransfer(HasBankAccount from, HasBankAccount to, double amount) throws TransferException{
	if(Math.random()<0.3) throw new TransferException("Lack of account funds!"); 
	System.out.println("P³acê od" + from.getBankAccount() + "do" + to.getBankAccount());
}
}
