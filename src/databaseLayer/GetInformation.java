package databaseLayer;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInformation {
    private Connection conn;
    private Statement stm;
    private ResultSet result;

    public GetInformation(Connection conn) {
        this.conn = conn;
        try {
            stm = this.conn.createStatement();
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null, "no connections");
            return;
        }
        result = null;
    }

    public String loginInfo(String id) {
        String query = "SELECT password FROM person WHERE user_id = '" + id + "'";
        try {
            result = stm.executeQuery(query);

            if (result.next()) {
            	String stms =result.getString("password");
            	result.close();
                return stms;
            }
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "no connections");
        } finally {
            closeResultSetAndStatement();
        }

        return null;
    }

    public double getBalance(int account) {
        String query = "SELECT Amount FROM accountsBalance WHERE account_id = '" + account + "'";
        try {
        	stm = this.conn.createStatement();
            result = stm.executeQuery(query);

            if (result.next()) {
            	double stms = result.getDouble("Amount");
            	result.close();
                return stms;
               
            }
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null,"something went Wrong");
        } finally {
            closeResultSetAndStatement();
        }

        return 0.0;
    }

    public String[] getUserInformation(int account) {
        String query = "SELECT * FROM person WHERE account_number = '" + account + "'";
        try {
        	stm = this.conn.createStatement();
            result = stm.executeQuery(query);

            if (result.next()) {
                String[] information = {
                    result.getString("first_name"),
                    result.getString("second_name"),
                    result.getString("account_number"),
                    result.getString("password"),
                    result.getString("user_id")
                };
               result.close();
                return information;
            }
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null,"something went wrong");
        } finally {
            closeResultSetAndStatement();
        }

        return null;
    }

    private void closeResultSetAndStatement() {
        try {
            if (result != null) {
                result.close();
            }
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
          
        }
    }
    public String[] getUser(int id ,int pin) {
        String query = "SELECT * FROM person WHERE user_id = '" + id + "' and password ='" + pin + "'";
        try {
        	stm = this.conn.createStatement();
            result = stm.executeQuery(query);

            if (result.next()) {
                String[] information = {
                    result.getString("first_name"),
                    result.getString("second_name"),
                    result.getString("account_number"),
                    result.getString("password"),
                    result.getString("user_id")
                };
               result.close();
                return information;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "no connections found");
        } finally {
            closeResultSetAndStatement();
        }

        return null;
    }
}
