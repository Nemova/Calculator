package sample;

import calculate.Operation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable  {

    @FXML
    TextField TextField1;

    @FXML
    TextField TextFieldres;

    @FXML
    TextField TextField2;

    @FXML
    TextField TextFieldz;

    @FXML
    Button calculateButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initButton();
    }

    void initButton(){
        calculateButton.setOnAction(event -> {
            String operationSign = TextFieldz.getText();
            Operation operation = Operation.findBySign(operationSign);
            if (operation == null) {
                TextFieldres.setText("Некорректная операция!!");
            }
            /// FIXME: 22.05.2018 Параметер 
        });
    }
}