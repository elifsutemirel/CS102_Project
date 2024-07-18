import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	private static String mySqlUrl = "jdbc:mysql://localhost:3306/findTdatabase";
	private static String mySqlUsername = "root";
	private static String mySqlPassword = "Merhaba123*";
	
	private static User currentUser;
	
	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		Main.currentUser = currentUser;
	}
	
	public static String getMySqlUrl() {
		return mySqlUrl;
	}

	public static void setMySqlUrl(String mySqlUrl) {
		Main.mySqlUrl = mySqlUrl;
	}

	public static String getMySqlUsername() {
		return mySqlUsername;
	}

	public static void setMySqlUsername(String mySqlUsername) {
		Main.mySqlUsername = mySqlUsername;
	}

	public static String getMySqlPassword() {
		return mySqlPassword;
	}

	public static void setMySqlPassword(String mySqlPassword) {
		Main.mySqlPassword = mySqlPassword;
	}

	public static void main(String[] args) throws Exception {
			
	}
	
	public static Connection connect() throws SQLException {
		
		 return DriverManager.getConnection(getMySqlUrl(), getMySqlUsername(), getMySqlPassword());
		
	}
}
