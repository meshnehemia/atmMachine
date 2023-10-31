package businessLogic;

import java.sql.Connection;

import databaseLayer.AtmBankDatabase;
import databaseLayer.GetInformation;
import databaseLayer.SendInfoToDatabase;
import userInterface.AtmScreen;

public class Withdraw extends Transactions{
	private GetInformation getInfo;
	private SendInfoToDatabase send ;
	private double amount;
	private int user_account;
	public Withdraw(int user_account,AtmScreen atsc,AtmBankDatabase atmdb,int pin,Connection conn) {
		super(conn);
		getInfo =new GetInformation(conn);
		send =new SendInfoToDatabase(conn);
		this.user_account =user_account;
		
	}

	public boolean withdraw(int account, double amount) {
		this.amount =getInfo.getBalance(account);
		if(this.amount>amount) {
			double sum = this.amount-amount;
			return send.updateTransaction(account,sum);
		}
		return false;
	}
}
