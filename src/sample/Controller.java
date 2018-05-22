package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Dictionary;
import java.util.ResourceBundle;


public class Controller implements Initializable  {

    @FXML
    TextArea primerTextArea;

    @FXML
    TextField resultTextField;

    @FXML
    Button calculateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initTextArea();
        initButton();
    }

    void initTextArea() {

    }

    void initButton(){
        calculateButton.setOnAction(event -> {
            String text = primerTextArea.getText();
            resultTextField.setText(text);
            primerTextArea.setText("");
        });
    }
}