package mainpackage;

import excpetions.InputException;
import javafx.scene.control.Alert;
import models.FileModel;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    public static FileModel model;
    @FXML
    private Button addBut;
    @FXML
    private TextField addressField, portField, protocolField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addBut.setOnAction(event->{
            try {
                model.addRecord(addressField.getText(), portField.getText(), protocolField.getText());
            }
            catch(InputException e){AlertController.showAlert(Alert.AlertType.ERROR,"Input is null");}
            Stage stage = (Stage) addBut.getScene().getWindow();
            stage.close();
        });
    }
}
