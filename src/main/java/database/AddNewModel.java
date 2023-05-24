package database;

import java.sql.SQLException;

public class AddNewModel {
    public static void addNewRecord(String addres,String port,String proocol,BaseClass base){
        try {
            base.statement.addBatch("Insert into myrecords values ("+0+",'"+addres+"','"+port+"','"+proocol+"') ");
            base.statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
