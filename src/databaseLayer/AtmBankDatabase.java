package databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AtmBankDatabase {
    private String url;
    private String databaseUser;
    private String password;
    private Connection conn;
    private String databaseName;

    public AtmBankDatabase(String databaseName, String databaseUser, String databasePassword) {
        url = "jdbc:mysql://localhost:3306/" + databaseName;
        this.databaseUser = databaseUser;
        password = databasePassword;
        conn = null;
    }
    public Connection connectToDatabase() {
        try {
            conn = DriverManager.getConnection(url, databaseUser, password);
            return conn;
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(null,"no database " +databaseName);
            return null;
        }
    }

    public boolean closeDatabase(Connection connection) {
        if (connection == null) {
            return false; // Connection was never opened
        }
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

