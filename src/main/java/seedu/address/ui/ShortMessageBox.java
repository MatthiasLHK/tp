package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.awt.*;

public class ShortMessageBox extends UiPart<VBox> {
    private static final String URL = "shortMessage.fxml";

    @FXML
    private Label shortMessage;

    public ShortMessageBox() {
        super(URL);
    }

    public void setResultMessage(String result) {
        shortMessage.setText(result);
    }
}
