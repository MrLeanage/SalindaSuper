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
public class TextFieldValidations {
    
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
    
    
     public static boolean isTextFieldTypePhoneNumber(TextField tf){
        
        boolean b=false;
        if(tf.getText().matches("^[0-9]{10}$"))
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
     
     public static boolean isTextFieldTypeEmail(TextField tf){
        
        boolean b=false;
        if(tf.getText().matches("[A-Z,a-z,0-9,.,_,]+[@]+[A-Z,a-z]+[.]+[A-Z,a-z]{3}$"))
              b=true;
        
        return b;
    }
     
     public static boolean isTextFieldTypeEmail (TextField tf,Label lb,String errorMessage){
        
        boolean b=true;
        String msg=null;
        tf.getStyleClass().remove("error"); 
       
        if(!isTextFieldTypeEmail(tf)){
        b=false;
        msg=errorMessage;
         tf.getStyleClass().add("error");
        
        }
        lb.setText(msg);
        
        return b;
    }
     
      public static boolean isTextFieldTypeNIC(TextField tf){
        
        boolean b1=false;
        if(tf.getText().matches("^[0-9]{9}+[V,v]{1}$"))
              b1=true;
        
        return b1;
    }
      
       public static boolean isTextFieldTypeNIC (TextField tf,Label lb,String errorMessage){
        
        boolean b1=true;
        String msg=null;
        tf.getStyleClass().remove("error"); 
       
        if(!isTextFieldTypeNIC(tf)){
        b1=false;
        msg=errorMessage;
         tf.getStyleClass().add("error");
        
        }
        lb.setText(msg);
        
        return b1;
    }
    
}
