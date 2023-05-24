package models;

import excpetions.PathException;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import mainpackage.AlertController;
import recordspackage.OneRecord;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveTxtModel implements  SaveInterface{
    @Override
    public void save(String path,FileInterface fm) throws PathException {
        FileWriter fw = null;
        try {
            ObservableList<Object> arr = fm.getArr();
            fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < arr.size(); i++) {
                OneRecord rec = (OneRecord) arr.get(i);
                pw.println(rec.getAddress());
                pw.println(rec.getPort());
                pw.println(rec.getProtocol());
            }
            fw.close();
            pw.close();
            AlertController.showAlert(Alert.AlertType.INFORMATION, "Save successfully");
        }
        catch(FileNotFoundException e){throw new PathException();}
        catch (IOException e) { AlertController.showAlert(Alert.AlertType.ERROR, "Error save"); }
    }


}
