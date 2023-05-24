package mainpackage;

import javafx.scene.control.Alert;

public class AlertController {
    public static void showAlert(Alert.AlertType al, String mes){
        Alert alert = new Alert(al);
        alert.setHeaderText(mes);
        alert.showAndWait();
    }
}
