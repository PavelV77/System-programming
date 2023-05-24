package database;

import java.sql.SQLException;

public class DeleteARModel {
    public static void deleteAllRecords(BaseClass base)  {
        try {
            base.statement.addBatch("Delete From myrecords");
            base.statement.executeBatch();
            BaseClass.arr.clear();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
