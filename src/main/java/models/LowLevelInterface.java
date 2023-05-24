package models;

import excpetions.InputException;

public interface LowLevelInterface {
    int calculate(String aStr, String bStr) throws InputException;
}
