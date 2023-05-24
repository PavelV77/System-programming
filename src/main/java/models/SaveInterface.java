package models;

import excpetions.PathException;

public interface SaveInterface {
    void save(String path, FileInterface fm) throws PathException;
}
