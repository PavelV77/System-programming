package models;

import excpetions.InputException;
import javafx.scene.control.Alert;
import mainpackage.AlertController;
import xorasm.XorClass;

public class XorModel implements LowLevelInterface{
    private int result;
    @Override
    public int calculate(String aStr, String bStr) throws InputException {
        try {
            int a = Integer.parseInt(aStr);
            int b = Integer.parseInt(bStr);
            if(a<0 || b<0)
                throw new InputException();
            result =  XorClass.getResult(a, b);
        }
        catch(NumberFormatException e){throw new InputException();}
        catch(Exception e){AlertController.showAlert(Alert.AlertType.ERROR, "Error input");}
        return result;
    }
}
