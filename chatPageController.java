import java.util.Stack;

import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.w3c.dom.events.MouseEvent;

public class chatPageController{
    @FXML
    private Button backButton;

    @FXML
    private ScrollPane chatScrollPane;

    @FXML
    private Circle generalProfileSign;

    @FXML
    private TextField messageTextField;

    @FXML
    private Ellipse profielBigCircle;

    @FXML
    private Circle profileLittleCircle;

    @FXML
    private Button sendMessageButton;

    @FXML
    private Text tutorNameText;
    
    private Stage stage;
    private Scene scene;


    public void goStudentMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("listOfChats.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}