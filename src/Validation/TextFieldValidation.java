/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Ashika
 */
public class TextFieldValidation {
    
    public static boolean IsTextFieldNotEmpty(TextField tf){
        
        boolean b=false;
        if(tf.getText().length() !=0 || !tf.getText().isEmpty())
        b =true;
        return b;
    }
    
    public static boolean IsTextFieldNotEmpty(TextField tf ,Label lb,String errorMssage){
        
        boolean b=true;
        String msg=null;
        
        if(!IsTextFieldNotEmpty(tf)){
        b =false;
        msg=errorMssage;
        }
        lb.setText(msg);
        
        return b;
    }
    
    public static boolean TextFieldTypeNumber(TextField tf){
        boolean b=false;
        if(tf.getText().matches("([0-9]+(\\.[0-9]+)?)+"))
        
        b=true;
        return b;
    }
    
    
    public static boolean TextFieldTypeNumber(TextField tf,Label lb,String ErrorMessage){
        boolean b=true;
        String msg=null;
        
        if(!TextFieldTypeNumber(tf)){
        b =false;
        msg=ErrorMessage;
        }
        lb.setText(msg);
        
        return b;
    }
    
}
