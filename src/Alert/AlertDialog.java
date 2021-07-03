/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alert;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
sho * @author Danushi Pathirana
 */
public class AlertDialog {
    
    public static void display(String message, String Title){
        
        Stage window=new Stage();
        window.setTitle(Title);
        window.setMinWidth(200);
        window.setMaxHeight(350);
        
        Label label=new Label();
        label.setText(message);
        Button buttonOK = new Button("OK");
        buttonOK.setOnAction(e->window.close());
        
        VBox layout = new VBox();
        layout.getChildren().addAll(label,buttonOK);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        
    }
    
    
}
