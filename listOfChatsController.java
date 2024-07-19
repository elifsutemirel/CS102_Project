import org.w3c.dom.Node;
import org.w3c.dom.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class listOfChatsController {
    @FXML
    private Button backButton;

    @FXML
    private ScrollPane chatScrollPane;

    @FXML
    private VBox chatVBox;

    // I didn't really unesrfstand the logic of this back button cause how do know whether we're on tutor or student team, 
        // probably an if statemet will do the job instead of trying to control two seperate methods 
    public void goStudentMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("studentMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goTutorMenuPage(MouseEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TutorMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
