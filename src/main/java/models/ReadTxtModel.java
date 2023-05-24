package models;

import excpetions.PathException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import mainpackage.AlertController;
import recordspackage.OneRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTxtModel implements ReadInterface{
    @Override
    public ObservableList<Object> read(String path,FileInterface fm) throws PathException {
        FileReader fr = null;
        ObservableList<Object> arr = FXCollections.observableArrayList();;
        try {
            fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            String address, port, protocol;
            address = bf.readLine();
            while (address != null) {
                port = bf.readLine();
                protocol = bf.readLine();
                arr.add(new OneRecord(address, port, protocol));
                address = bf.readLine();
            }
            bf.close();
            fr.close();
            AlertController.showAlert(Alert.AlertType.INFORMATION, "Read successfully");
            fm.setArr(arr);
        }
        catch(FileNotFoundException e){throw new PathException();}
        catch(IOException e){AlertController.showAlert(Alert.AlertType.ERROR, "Error read");}
        return arr;
    }
}
