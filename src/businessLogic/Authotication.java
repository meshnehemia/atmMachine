package businessLogic;

import java.sql.Connection;

import databaseLayer.AtmBankDatabase;
import databaseLayer.GetInformation;
import databaseLayer.SendInfoToDatabase;

public class Authotication {
	 private  int pin ;
	 private int account;
	 private String fname;
	 private String lname;
	 private  double amount;
	 private  int id;
	 private AtmBankDatabase conn;
	 private Connection connection;
	 private SendInfoToDatabase send;
	 private GetInformation getinfo;
	public Authotication(String database,String username,String password) {
		try {
			conn =new AtmBankDatabase(database,username,password);
			connection = conn.connectToDatabase();
			send = new SendInfoToDatabase(connection);
			getinfo =new GetInformation(connection);
		}catch(Exception e) {
			System.out.println("failed to connect to database");
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
		 return send.updateUser(fname, lname,id, pin);
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

}
