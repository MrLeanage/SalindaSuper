/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.sql.SQLException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author dulshan
 */
public class DataValidation {
    public static boolean TextFieldNotEmpty(TextField i){
        boolean r = false;
        if(i.getText() != null  && !i.getText().isEmpty()){
            r = true;
        }
        return r;
    }
    public static boolean TextFieldNotEmpty(TextField i,Label l,String sValidationText){
        boolean r = true;
        String c = null;
        if(!TextFieldNotEmpty(i)){
            r = false;
            c = sValidationText;
            //System.out.println(c);
        }
        try{
           l.setText(c); 
            
        }catch(NullPointerException e){
            //System.out.println(e);
        }
        
        return r;
    }
    public static boolean TextAreaNotEmpty(TextArea i){
        boolean r = false;
        if(i.getText() != null  && !i.getText().isEmpty()){
            r = true;
        }
        return r;
    }
    public static boolean TextAreaNotEmpty(TextArea i,Label l,String sValidationText){
        boolean r = true;
        String c = null;
        if(!TextAreaNotEmpty(i)){
            r = false;
            c = sValidationText;
        }
        l.setText(c);
        return r;
    }
    
    


}
