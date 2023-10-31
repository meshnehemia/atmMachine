package databaseLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SendInfoToDatabase {
    private Statement stm;
    private PreparedStatement statement;
    private Connection conn;

    public SendInfoToDatabase(Connection connections) {
        conn = connections;
        try {
            stm = conn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"no connections");
        }
        statement = null;
    }

    public Boolean transactions(int account, double amount, double current_amount, String type, String td_id) {
        try {
            // Create a table if it doesn't exist
            String q1 = "CREATE TABLE IF NOT EXISTS transaction (" +
                    "Account_number varchar(20), " +
                    "Amount double, " +
                    "transaction_id varchar(20), " +
                    "current_amount double, " +
                    "transaction_type varchar(20)" +
                    ")";
            stm.execute(q1);

            String q2 = "INSERT INTO transaction (Account_number, Amount, transaction_id, current_amount, transaction_type) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(q2);
            statement.setInt(1, account);
            statement.setDouble(2, amount);
            statement.setString(3, td_id);
            statement.setDouble(4, current_amount);
            statement.setString(5, type);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean updateUser(String f_name, String s_name, int user_id,int password) {
        try {
            // Create a table if it doesn't exist
        	String q1 = "CREATE TABLE IF NOT EXISTS person (" +
                    "first_name varchar(20), " +
                    "second_name varchar(20), " +
                    "user_id int, " +
                    "Account_number int AUTO_INCREMENT," +
                    "password int," +
                    "primary key (Account_number)" +
                    ");";

            stm.execute(q1);

            String q2 = "INSERT INTO person (first_name, second_name, user_id, password) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(q2);
            statement.setString(1, f_name);
            statement.setString(2, s_name);
            statement.setInt(3, user_id);
            statement.setInt(4, password);
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean  transaction(int account, double amount) {
    	try {
    		String createTableQuery = "CREATE TABLE IF NOT EXISTS accountsBalance (" +
                    "account_id INT PRIMARY KEY," +
                    "Amount DOUBLE)";
    		stm.execute(createTableQuery);
    		String insertDataQuery = "INSERT INTO accountsBalance (account_id, Amount) VALUES (" + account + ", " + amount + ")";
    		statement.executeUpdate(insertDataQuery);
    		return true;
    		
    	}catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"something WentWrong");
            System.out.println(ex);
            return false;
        }
    }
    public Boolean updateTransaction(int account, double amount) {
    	
    	try {
    		String setInfo = "UPDATE accountsBalance SET Amount='" + amount + "' WHERE account_id='" + account + "'";
			stm.executeUpdate(setInfo);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Something went Wrong");
			return false;
		}
    	
    }
}
