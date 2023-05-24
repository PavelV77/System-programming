package database;

import javafx.collections.ObservableList;
import recordspackage.OneRecord;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAllRecordsModel {

    public static ObservableList<Object> getAllRecords(BaseClass base){
        ObservableList<Object> arr = base.getArr();
        try {
            ResultSet resultSet = base.statement.executeQuery("Select * From myrecords");
            BaseClass.arr.clear();
            while (resultSet.next()){
                OneRecord rec = new OneRecord();
                rec.setId(resultSet.getInt(1));
                rec.setAddress(resultSet.getString(2));
                rec.setPort(resultSet.getString(3));
                rec.setProtocol(resultSet.getString(4));
                BaseClass.arr.add(rec);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }
}
