import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;

public class WelcomePageController {
    @FXML
    private Rectangle studentLogIn;

    @FXML
    private TextField studentPassword;

    @FXML
    private Text studentSıgnIn;

    @FXML
    private TextField studentUsername;

    @FXML
    private Rectangle tutorLogIn;

    @FXML
    private TextField tutorPassword;

    @FXML
    private TextField tutorUsername;
    
    private Stage stage;
    private Scene scene;

    public void goTutorMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TutorMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goStudentMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("studentMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goTutorSignInPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SıgnIn(Tutor).fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goStudentSıgnInPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn(Student).fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
