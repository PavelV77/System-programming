package database;
import javafx.collections.ObservableList;
import recordspackage.OneRecord;

public class ReadBdFromText {
    public static void readFromTxt(ObservableList<Object> arr, BaseClass base){
        DeleteARModel.deleteAllRecords(base);
        BaseClass.arr = arr;
        for (Object o : arr) {
            OneRecord rec = (OneRecord) o;
            AddNewModel.addNewRecord(rec.getAddress(), rec.getPort(), rec.getProtocol(), base);
        }
    }
}
