import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Teacher extends User {

    public Teacher(int id, String username, String password, String email, String biography) {
        super(id, username, password, email, biography);
    }

    @Override
    public String getAccountType() {
        return "Teacher";
    }

    public static Teacher getById(int tutorid) throws SQLException {
        Connection connection = Main.connect();
        String query = "SELECT * FROM tutor WHERE tutorid = ?";
        PreparedStatement stat = connection.prepareStatement(query);
        stat.setInt(1, tutorid);
        ResultSet r = stat.executeQuery();
        if (r.next()) {
            String username = r.getString("name");
            String password = r.getString("password");
            String email = r.getString("email");
            String biography = r.getString("biography");
            stat.close();
            connection.close();
            return new Teacher(tutorid, username, password, email, biography);
        }
        stat.close();
        connection.close();
        return null;
    }

    public static Teacher signUp(String username, String password, String email, String biography) throws SQLException {
        Connection connection = DriverManager.getConnection(Main.getMySqlUrl(), Main.getMySqlUsername(), Main.getMySqlPassword());
        Statement idStatement = connection.createStatement();
        ResultSet r = idStatement.executeQuery("SELECT tutorid FROM tutor ORDER BY tutorid DESC");
        r.next();
        int id = r.getInt(1) + 1;
        idStatement.close();
        connection.close();

        if (!isValidUsername(username)) {
            welcomePage.showInvalidUsernameError();
            return null;
        }
        if (!isUsernameUnique(username, "tutor", "tutorid")) {
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

        return addTeacher(id, username, password, email, biography);
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

    public static Teacher addTeacher(int tutorid, String username, String password, String email, String biography) throws SQLException {
        Connection connection = DriverManager.getConnection(Main.getMySqlUrl(), Main.getMySqlUsername(), Main.getMySqlPassword());
        Teacher teacher = new Teacher(tutorid, username, password, email, biography);
        String query = "INSERT INTO tutor VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, teacher.getId());
        statement.setString(2, teacher.getUsername());
        statement.setString(3, teacher.getPassword());
        statement.setString(4, teacher.getEmail());
        statement.setString(5, teacher.getBiography());
        statement.executeUpdate();
        statement.close();
        connection.close();
        return teacher;
    }
}