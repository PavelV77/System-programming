package models;

import cyclepackage.CheckClass;
import javafx.scene.control.Alert;
import mainpackage.AlertController;

public class CycleWhileModel implements CycleInterface{
    private boolean result;
    public boolean check(String whileString) {
        try {
            result = CheckClass.checkWhile(whileString);
        } catch (Exception e) {throw new RuntimeException(e);}
        if(result)
            AlertController.showAlert(Alert.AlertType.INFORMATION,"One or more iterations");
        else
            AlertController.showAlert(Alert.AlertType.INFORMATION,"No iterations");
        return result;
    }
}
