package models;

import excpetions.PathException;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface ReadInterface {
    ObservableList<Object> read(String path, FileInterface fm) throws PathException;
}
