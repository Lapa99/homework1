package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    TextArea textArea;
    @FXML
    TextField mainTextField;

    public void addTextToArea() {
        textArea.appendText(mainTextField.getText() + System.lineSeparator());
        mainTextField.clear();
    }
}