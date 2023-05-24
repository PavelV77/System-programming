package database;

import excpetions.InputException;

import java.sql.SQLException;

public class DeleteOneModel {
    public static void delete(String id, BaseClass base) throws InputException {
        try {
            Integer.parseInt(id);
            base.statement.addBatch("Delete From myrecords where id = "+id);
            base.statement.executeBatch();
        }
        catch(NumberFormatException e){throw new InputException();}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
