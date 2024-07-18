import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class welcomePage extends Application {
    @FXML
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("welcomePage.fxml"));
            Scene scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        launch(args);

    }
    public static void showInvalidLoginError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Username or password is incorrect.");
        alert.showAndWait();
    }
    public static void showInvalidPasswordError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Password should at least be 8 characters long and should contain at least 1 number, 1 uppercase letter and 1 special character.");
        alert.showAndWait();
    }
    public static void showInvalidUsernameError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Username should at least be 3 characters long and cannot contain any spaces or any uppercase letters.");
        alert.showAndWait();
    }

    public static void showNotUniqueUsernameError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("This username is already taken.");
        alert.showAndWait();
    }
    public static void showInvalidEmailError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Invalid email. Please enter a correct email.");
        alert.showAndWait();
    }
}
