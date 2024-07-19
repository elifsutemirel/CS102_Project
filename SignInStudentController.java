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

public class SignInStudentController {
    @FXML
    private Button BackToLogInStudent;

    @FXML
    private ComboBox<?> ParentsAge;

    @FXML
    private ComboBox<?> StudentBirthyear;

    @FXML
    private Text StudentCreateProfile;

    @FXML
    private Circle StudentCreateProfileCL;

    @FXML
    private Circle StudentCreateProfileCR;

    @FXML
    private Rectangle StudentCreateProfileRect;

    @FXML
    private TextField StudentMail;

    @FXML
    private TextField StudentPasswordSıgnIn;

    @FXML
    private TextField StudentUsernameSıgnIn;
    
    private Stage stage;
    private Scene scene;

    public void goStudentMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("studentMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
