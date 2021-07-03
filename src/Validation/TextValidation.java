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
 * @author Danushi Pathirana
 */
public class TextValidation {
    
    public static boolean IsTextFieldNotEmpty(TextField tf){
        
        boolean b=false;
        if(tf.getText().length() !=0 || !tf.getText().isEmpty())
            b=true;
        
        return b;
    }
    
    public static boolean IsTextFieldNotEmpty(TextField tf,Label lb, String errorMessage){
        
        boolean b=true;
        String msg=null;
        tf.getStyleClass().remove("error");
        if(!IsTextFieldNotEmpty(tf)){
            b=false;
            msg=errorMessage;
             tf.getStyleClass().add("error");
            
        }
        lb.setText(msg);
        
        return b;
    }
    
    public static boolean isTextFieldTypeNumber(TextField tf){
        
        boolean b=false;
        if(tf.getText().matches("([0-9]+(\\.[0-9]+)?)+"))
        b=true;
        
        return b;
    }
   
     public static boolean isTextFieldTypePhoneNumber(TextField tf){
        
        boolean b=false;
        if(tf.getText().matches("^[0-9]{9}$"))
              b=true;
        
        return b;
    }
     public static boolean isTextFieldTypePhoneNumber(TextField tf,Label lb,String errorMessage){
        
        boolean b=true;
        String msg=null;
        tf.getStyleClass().remove("error"); 
       
        if(!isTextFieldTypePhoneNumber(tf)){
        b=false;
        msg=errorMessage;
         tf.getStyleClass().add("error");
        
        }
        lb.setText(msg);
        
        return b;
    }
   
     public static boolean isTextFieldTypeNumber(TextField tf,Label lb,String errorMessage){
        
        boolean b=true;
        String msg=null;
        tf.getStyleClass().remove("error"); 
       
        if(!isTextFieldTypeNumber(tf)){
        b=false;
        msg=errorMessage;
         tf.getStyleClass().add("error");
        
        }
        lb.setText(msg);
        
        return b;
    }
     
     public static boolean isTextFieldTypeName(TextField tf){
        
        boolean b=false;
        if(tf.getText().matches("[a-zA-Z]+"))
              b=true;
        
        return b;
    }
    
     public static boolean isTextFieldTypeName(TextField tf,Label lb,String errorMessage){
        
        boolean b=true;
        String msg=null;
        tf.getStyleClass().remove("error"); 
       
        if(!isTextFieldTypeName(tf)){
        b=false;
        msg=errorMessage;
         tf.getStyleClass().add("error");
        
        }
        lb.setText(msg);
        
        return b;
    }
     
     
     
}
