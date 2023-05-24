package database;


import excpetions.InputException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.FileInterface;
import java.sql.*;

public class BaseClass implements FileInterface {
    private static String url  = "jdbc:mysql://localhost:3306/bd_sp1";
    private static String root = "root";
    private static String pas = "12345";
    public Statement statement;
    public static ObservableList<Object> arr;
    @Override
    public ObservableList<Object> getArr() {return arr;}
    @Override
    public void setArr(ObservableList<Object> a) {}
    public  BaseClass(){
        arr = FXCollections.observableArrayList();
        Connection connection;
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url,root,pas);
            statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
