import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class searchPageController {
    @FXML
    private Button backButton;

    @FXML
    private ComboBox<?> lessonComboBox;

    @FXML
    private ComboBox<?> priceComboBox;

    @FXML
    private TextField searchSubjectBar;

    @FXML
    private ScrollPane subjectsListedScrollPane;

    @FXML
    private VBox subjectsListedVBox;
}
