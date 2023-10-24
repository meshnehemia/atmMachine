package businessLogic;

import databaseLayer.AtmBankDatabase;
import userInterface.AtmScreen;

public class Withdraw extends Transactions{
	public Withdraw(String user_account,AtmScreen atsc,AtmBankDatabase atmdb) {
		super(user_account,atsc,atmdb);
	}
}
