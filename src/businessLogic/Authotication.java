package businessLogic;

import java.sql.Connection;

import databaseLayer.AtmBankDatabase;
import databaseLayer.GetInformation;
import databaseLayer.SendInfoToDatabase;
import userInterface.AtmScreen;

public class Authotication {
	 private  int pin ;
	 private int account;
	 private String fname;
	 private String lname;
	 private  double amount;
	 private  int id;
	 private AtmBankDatabase conn;
	 private Transactions transact;
	 private Connection connection;
	 private SendInfoToDatabase send;
	 private Withdraw with;
	 private GetInformation getinfo;
	public Authotication(String database,String username,String password) {
		try {
			
			conn =new AtmBankDatabase(database,username,password);
			connection = conn.connectToDatabase();
			send = new SendInfoToDatabase(connection);
			transact = new Transactions(connection);
			getinfo =new GetInformation(connection);
			with =new Withdraw(0,null,null,0,connection);
		}catch(Exception e) {
			return;
		}
	}
	public void setPin(int pin) {
		this.pin =pin;
	}
	public void setaccount(int account) {
		this.account =account;
	}
	public void setAmount(int pin) {
		this.pin =pin;
	}
	public void setfname(String name) {
		this.fname =name;
	}
	public void setlname(String name) {
		this.lname =name;
	}
	public void setid(int id) {
		this.id =id;
	}
	public boolean savepersonalinformation () {
			if(send.updateUser(fname, lname,id, pin)){
				update();
				return send.transaction(account, 0.00);
			};
			return false;
	}
	private boolean authoticate() {
		String[]info =getinfo.getUserInformation(this.account);
		if(info==null){
			return false;
		}
		if(pin==Integer.parseInt(info[3])) {
			return true;
		}
		return false;
	}
	public boolean login() {
		return authoticate();
	}
	public int account() {
		return this.account;
	}
	public int update() {
		String [] info =getinfo.getUser(id ,pin);
		setfname(info[0]);
		setaccount(Integer.parseInt(info[2]));
		setlname(info[1]);
		return Integer.parseInt(info[2]);
		
	}
	public boolean pinValidation(int pin) {
		if(this.pin == pin) {
			return true;
		}
		return false;
	}
	public boolean deposit(double amount) {
		return transact.deposit(account, amount);
	}
	public double checkBalance() {
		return transact.checkbalance(account);
	}
	public boolean withdraw(double amount) {
		return with.withdraw(this.account,amount);
		
	}

}
