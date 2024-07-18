import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
public class Student extends User {

    public Student(int id, String username, String password, String email, String biography) {
        super(id, username, password, email, biography);
    }

    @Override
    public String getAccountType() {
        return "Student";
    }

    public static Student getById(int studentid) throws SQLException {
        Connection connection = Main.connect();
        String query = "SELECT * FROM student WHERE studentid = ?";
        PreparedStatement stat = connection.prepareStatement(query);
        stat.setInt(1, studentid);
        ResultSet r = stat.executeQuery();
        if (r.next()) {
            String username = r.getString("username");
            String password = r.getString("password");
            String email = r.getString("email");
            String biography = r.getString("biography");
            stat.close();
            connection.close();
            return new Student(studentid, username, password, email, biography);
        }
        stat.close();
        connection.close();
        return null;
    }

    public static Student signUp(String username, String password, String email, String biography) throws SQLException {
        Connection connection = DriverManager.getConnection(Main.getMySqlUrl(), Main.getMySqlUsername(), Main.getMySqlPassword());
        Statement idStatement = connection.createStatement();
        ResultSet r = idStatement.executeQuery("SELECT studentid FROM student ORDER BY studentid DESC");
        r.next();
        int id = r.getInt(1) + 1;
        idStatement.close();
        connection.close();

        if (!isValidUsername(username)) {
            welcomePage.showInvalidUsernameError();
            return null;
        }
        if (!isUsernameUnique(username, "student", "studentid")) {
            welcomePage.showNotUniqueUsernameError();
            return null;
        }
        if (!isValidPassword(password)) {
            welcomePage.showInvalidPasswordError();
            return null;
        }
        if (!isValidEmail(email)) {
            welcomePage.showInvalidEmailError();
            return null;
        }

        return addStudent(id, username, password, email, biography);
    }

    public static boolean isUsernameUnique(String username, String table, String column) throws SQLException {
        Connection connection = Main.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " WHERE name='" + username + "';");
        if (resultSet.next()) {
            return false;
        }
        statement.close();
        connection.close();
        return true;
    }

    public static Student addStudent(int studentid, String username, String password, String email, String biography) throws SQLException {
        Connection connection = DriverManager.getConnection(Main.getMySqlUrl(), Main.getMySqlUsername(), Main.getMySqlPassword());
        Student student = new Student(studentid, username, password, email, biography);
        String query = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, student.getId());
        statement.setString(2, student.getUsername());
        statement.setString(3, student.getPassword());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getBiography());
        statement.executeUpdate();
        statement.close();
        connection.close();
        return student;
    }
}
