package models;

import excpetions.InputException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import mainpackage.AlertController;
import recordspackage.OneRecord;


public class FileModel implements FileInterface{
    private static ObservableList<Object> arr = FXCollections.observableArrayList();

    public ObservableList<Object> getArr(){
        return arr;
    }
    public void setArr(ObservableList<Object> a){ arr = a;}
    public void addRecord(String address, String protocol, String port) throws InputException {
        if(address.equals("")||protocol.equals("")||port.equals(""))
            throw new InputException();
        arr.add(new OneRecord(address,protocol,port));
    }

}
