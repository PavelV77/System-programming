package mainpackage;




import database.*;
import excpetions.InputException;
import excpetions.PathException;
import hibernatepackage.HibClass;
import models.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import recordspackage.OneRecord;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController  implements Initializable  {

    @FXML
    private TextField pathField,textFieldA,textFieldB,textFieldResAsm,addFieldBD,portFieldBD,protFieldBD,idFieldBD;
    @FXML
    private TextArea textFieldWhile;
    @FXML
    private Button readBut,addBut,saveBut,checkBut,butAsm,addBd,deleteBD,openBD;
    @FXML
    private TableView<Object> readTable,readTableBD;
    @FXML
    private TableColumn<OneRecord, String> addressColumn,portColumn,protocolColumn,addressColumnBD,portColumnBD,protocolColumnBD;
    @FXML
    private TableColumn<OneRecord,Integer> idColumnBD1;
    ReadInterface readI;
    SaveInterface saveI;
    LowLevelInterface lowI;
    CycleInterface cycleI;
    FileModel fModel = new FileModel();
    BaseClass base;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addressColumn.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("address"));
        portColumn.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("port"));
        protocolColumn.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("protocol"));
        idColumnBD1.setCellValueFactory(new PropertyValueFactory<OneRecord, Integer>("id"));
        addressColumnBD.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("address"));
        portColumnBD.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("port"));
        protocolColumnBD.setCellValueFactory(new PropertyValueFactory<OneRecord, String>("protocol"));
        base = new BaseClass();
        readBut.setOnAction(event -> {
            readI = new ReadTxtModel();
            try {
                readTable.setItems(readI.read(pathField.getText(), fModel));
            }
            catch (PathException e){AlertController.showAlert(Alert.AlertType.ERROR, "Error path");}
        });

        addBut.setOnAction(event -> {
            Stage stage = new Stage();
            AddController.model = this.fModel;
            FXMLLoader fxmlLoader = new FXMLLoader(AddController.class.getResource("addwin.fxml"));
            Scene scene = null;
            try {scene = new Scene(fxmlLoader.load(), 250, 110);}
            catch (IOException e) {throw new RuntimeException(e);}
            stage.setTitle("Add Record");
            stage.setScene(scene);
            stage.show();
            stage.setOnHidden(windowEvent -> readTable.setItems(fModel.getArr()));
        });
        saveBut.setOnAction(event -> {
            try {
                saveI = new SaveTxtModel();
                saveI.save(pathField.getText(), fModel);
            }
            catch (PathException e){AlertController.showAlert(Alert.AlertType.ERROR, "Error path");}
        });
        checkBut.setOnAction(event -> {
            cycleI = new CycleWhileModel();
            cycleI.check(textFieldWhile.getText());
        });
        butAsm.setOnAction(event -> {
            lowI = new XorModel();
            try {
                textFieldResAsm.setText("" + lowI.calculate(textFieldA.getText(), textFieldB.getText()));
            }
            catch (InputException e){AlertController.showAlert(Alert.AlertType.ERROR, "Error input");}
        });
        addBd.setOnAction(event->{
           HibClass.createRecord(addFieldBD.getText(),portFieldBD.getText(),protFieldBD.getText());
            readTableBD.setItems(HibClass.getAllRec());
        });
       deleteBD.setOnAction(actionEvent -> {
           HibClass.deleteRecord(Integer.parseInt(idFieldBD.getText()));
           readTableBD.setItems(HibClass.getAllRec());
       });
        openBD.setOnAction(event->{
            readTableBD.setItems(HibClass.getAllRec());
        });
    }
}