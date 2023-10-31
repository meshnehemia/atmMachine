package businessLogic;

import java.sql.Connection;

import databaseLayer.AtmBankDatabase;
import databaseLayer.GetInformation;
import databaseLayer.SendInfoToDatabase;
import userInterface.AtmScreen;

public class Transactions {
	private GetInformation getInfo;
	private SendInfoToDatabase send ;
	private double amount;
	public Transactions(Connection conn) {
		getInfo =new GetInformation(conn);
		send =new SendInfoToDatabase(conn);
	}
	public boolean deposit(int account, double amount) {
			this.amount =getInfo.getBalance(account);
			double sum = amount+this.amount;
			if(this.amount<0) {
			return false;
		 }
		 return send.updateTransaction(account,sum);
		
	}
	public double checkbalance(int account) {
		return getInfo.getBalance(account);
	}
}
