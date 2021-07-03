/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillingAndIncome;

import Alert.AlertDialog;
import DBConnect.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Danushi Pathirana
 */
public class First_WindowController implements Initializable {
    
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    private Connection conn=null;
    private PreparedStatement pst=null; 
    ResultSet rs=null;
    private DBConnection dbcon;
    float a;
    float b;
    float total;
    float sum;
   int Document_no=0;
   float totalsum;
   String totsum;
   
    @FXML
    private TextField Item_Name;
    @FXML
    private TextField Quantity;
    @FXML
    private TextField Unit_Price;
   
    @FXML
    private Button submit;
    private TextField Total_Amount;
    
    String TotalAmount;
    
    //Table define
    
    @FXML
    private TableView<ItemTable> mytable;
    @FXML
    private TableColumn<ItemTable, String> Item_NameT;
    @FXML
    private TableColumn<ItemTable, Float> Unit_PriceT;
    @FXML
    private TableColumn<ItemTable, Float> QuantityT;
    @FXML
    private TableColumn<ItemTable, Float> Total_amountT;
    
    //create table data
    private ObservableList<ItemTable>data;
    @FXML
    private TableView<databaseloadtable> DatabaseTable;
    @FXML
    private TableColumn<databaseloadtable, String> PName;
    @FXML
    private TableColumn<databaseloadtable, Integer> PID;
    @FXML
    private TableColumn<databaseloadtable, Float> PBuyingPricePerUnit;
    
    ObservableList<databaseloadtable> ol=FXCollections.observableArrayList();
    @FXML
    private Label Unit_PriceError;
    @FXML
    private Label Error_Quantity;
    @FXML
    private Label Item_NameError;
    
    private int No;
    @FXML
    private Button Update;
    @FXML
     Label total1;
    @FXML
    private TextField Document;
    @FXML
    private Label Document_Noerror;
    @FXML
    private TableColumn<ItemTable,Integer> DocmentT;
    
    @FXML
    private TextField Cus_num;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
//        total1.setVisible(false);
      //  conn=DBConnection.Connect();
        dbcon = new DBConnection();
        //DBConnection dbconn = new DBConnection();
        data=FXCollections.observableArrayList();
        setCellTable();
        setCellValuesFromTabletoTextField();
        handleSearchEvent1();
        mytable.getItems().clear();
        
        
        Item_NameT.setCellValueFactory(new PropertyValueFactory<>("Item_NameT"));
        Unit_PriceT.setCellValueFactory(new PropertyValueFactory<>("Unit_PriceT"));
        QuantityT.setCellValueFactory(new PropertyValueFactory<>("QuantityT"));
        Total_amountT.setCellValueFactory(new PropertyValueFactory<>("Total_amountT"));
        DocmentT.setCellValueFactory(new PropertyValueFactory<>("DocumentT"));
        
        
        try {
            Connection conn = dbcon.Connect();
            rs=conn.createStatement().executeQuery("select PName,PID,PBuyingPricePerUnit from product");
            
            while(rs.next()){
                ol.add(new databaseloadtable(rs.getString("PName"), rs.getInt("PID"),rs.getFloat("PBuyingPricePerUnit")));
            }
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
       
       PName.setCellValueFactory(new PropertyValueFactory<databaseloadtable,String>("PName"));
       PID.setCellValueFactory(new PropertyValueFactory<databaseloadtable,Integer>("PID"));
       PBuyingPricePerUnit.setCellValueFactory(new PropertyValueFactory<databaseloadtable,Float>("PBuyingPricePerUnit"));
       
       DatabaseTable.setItems(ol);
    }
       @FXML
    private void handleLogoutEvent(ActionEvent event) throws Exception  {
        
        
             AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/UserAndEmployee/login.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
}
@FXML
    private void handleUserAddEvent(ActionEvent event) throws Exception  {
        
        
             AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/Third_Window_1.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
}
    @FXML
    private void handleAddEvent(ActionEvent event) throws Exception  {
        
        try{
            /*
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/BillingAndIncome/Third_Window.fxml"));
             Parent root =(Parent)loader.load();
             String Document_no1=Document.getText();
             Third_WindowController s2=loader.getController();
             s2.getTo(sum,Document_no1);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
             */
             AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/BillingAndIncome/Third_Window.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
        
}
catch(IOException e){
 e.printStackTrace();
}
        
 
    }

    @FXML
    void handleCustomerinterface(ActionEvent event) throws IOException {
        
//        String cus=Cus_num.getText();
//           try {
//            pst=conn.prepareStatement("select CNo from customer where CPhone1='"+cus+"'");
//            rs=pst.executeQuery();
//            
//            while(rs.next()){
//                
//                data.add(new ItemTable(rs.getInt(2),rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));
//
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
   
//        AnchorPane home_page_parent=(AnchorPane)FXMLLoader.load(getClass().getResource("/javafxapplication5/Second_Window.fxml"));
//        Scene home_page_scene=new Scene(home_page_parent);
//        Stage app_stage=(Stage)((Node) event.getSource()).getScene().getWindow();
//        app_stage.setScene(home_page_scene);
//        app_stage.show();
   
try{        
        ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/BillingAndIncome/Second_Window.fxml"));
             AnchorPane root =(AnchorPane)loader.load();
             String Document_no1=Document.getText();
             Second_WindowController s2=loader.getController();
             s2.getTot(Float.valueOf(totsum),Document_no1);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
        
}
        catch(IOException e){
            e.printStackTrace();
}
    }
    
 @FXML
    void handleUserCustomerinterface(ActionEvent event) throws IOException {
              
        ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader(getClass().getResource("/BillingAndIncome/Second_Window_1.fxml"));
             AnchorPane root =(AnchorPane)loader.load();
             String Document_no1=Document.getText();
             Second_WindowController s2=loader.getController();
             s2.getTot(Float.valueOf(totsum),Document_no1);
             Stage stage=new Stage();
             stage.setScene(new Scene(root));
             stage.show();
        
}
    
     
  //   public  void setTotal(TotalModel tb){
    //     this.tb = tb;
    // }
   

    @FXML
    private void handleSubmitTable(ActionEvent event) throws SQLException {
         if( Validation.TextValidation.isTextFieldTypeNumber(Document, Document_Noerror, "Document No is Required") 
                && Validation.TextValidation.IsTextFieldNotEmpty(Item_Name, Item_NameError, "Item Name Is Required") 
                &&Validation.TextValidation.isTextFieldTypeNumber(Quantity, Error_Quantity, "Quantity Is a Number")
                && Validation.TextValidation.isTextFieldTypeNumber(Unit_Price, Unit_PriceError, "Unit price Is a Number")
                &&Validation.TextValidation.isTextFieldTypeName(Item_Name, Item_NameError,"Item name Invalid")){
        
        a=Float.parseFloat(Quantity.getText());
        b=Float.parseFloat(Unit_Price.getText());
        total=a*b;
        sum=(sum+(a*b));
        
        TotalModel tb = new TotalModel();
         tb.setTotal(sum);

        
          Document_no=Integer.valueOf(Document.getText());
        String ItemName=Item_Name.getText();
        float UnitPrice=Float.valueOf(Unit_Price.getText());
        float Quantity1=Float.valueOf(Quantity.getText());
        float TotalAmount=total;
        float Alltotal=sum;
        
        ItemTable itemtable=new ItemTable(Document_no, ItemName, UnitPrice, Quantity1, TotalAmount);
        mytable.getItems().add(itemtable);
         String tot=Float.toString(sum);
       total1.setText(tot);
        

        cleartext();
       
        
//         String Item_NameT=Item_Name.getText();
//         float Unit_PriceT=Float.parseFloat(Unit_Price.getText());
//         float QuantityT=Float.parseFloat(Quantity.getText());
//         float 
         
        
            
    try{
        
String sql="Insert into billitems(Document_no,ItemName,UnitPrice,Quantity,TotalAmount,Alltotal)values(?,?,?,?,?,?)";  
             
       Connection conn = dbcon.Connect();
        pst=conn.prepareStatement(sql);
        
        
        pst.setInt(1, Document_no);
        pst.setString(2, ItemName);
        pst.setFloat(3, UnitPrice);
        pst.setFloat(4, Quantity1);
        pst.setFloat(5, TotalAmount);
        pst.setFloat(6, Alltotal);
  
    
         int x=pst.executeUpdate();
        if(x==1){
            System.out.println("data entered Successfully");
 
           
        }
        
       } catch (SQLException ex) {
            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     finally{
            pst.close();
        }



        
        
        }
    }
  
    private void setCellTable(){
        
       Item_NameT.setCellValueFactory(new PropertyValueFactory<>("Item_NameT"));
       Unit_PriceT.setCellValueFactory(new PropertyValueFactory<>("Unit_PriceT"));
       QuantityT.setCellValueFactory(new PropertyValueFactory<>("QuantityT"));
       Total_amountT.setCellValueFactory(new PropertyValueFactory<>("Total_amountT"));
       DocmentT.setCellValueFactory(new PropertyValueFactory<>("DocumentT"));
       String tot=Float.toString(sum);
       total1.setText(tot);
        
    }
    
//  public float totalpass(){
//     
//      String tot=Float.toString(sum);
//       total1.setText(tot);
//      return sum;
//  }
    
    
    private void loaddatabaseTable(){
       
        mytable.getItems().clear();
         Document_no=Integer.valueOf(Document.getText());
        try {
            Connection conn = dbcon.Connect();
            pst=conn.prepareStatement("select * from billitems where Document_no="+Document_no+"");
            rs=pst.executeQuery();
            
            while(rs.next()){
                
                data.add(new ItemTable(rs.getInt(2),rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6)));

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mytable.setItems(data);
    }
    
    private void loaddatabaseTabledatabaseloadedatable(){
        
        try {
            Connection conn = dbcon.Connect();
            pst=conn.prepareStatement("select PID,PName,PBuyingPricePerUnit from product");
            rs=pst.executeQuery();
            
            while(rs.next()){
                
                ol.add(new databaseloadtable(rs.getString(1),rs.getInt(2),rs.getFloat(7)));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    private void handleSearchEvent(KeyEvent event) {
   
        try{
            Connection conn = dbcon.Connect();
            rs=conn.createStatement().executeQuery("select PName,PBuyingPricePerUnit from product where PName=?");
        
            while(rs.next()){
                ol.add(new databaseloadtable(rs.getString(1), rs.getInt(2),rs.getFloat(3)));
            }
        
        }catch(Exception e){
            
            
            
        }
             
    }
    
    private void setCellValuesFromTabletoTextField(){
        
         DatabaseTable.setOnMouseClicked(e->{
            
             databaseloadtable d1=DatabaseTable.getItems().get(DatabaseTable.getSelectionModel().getSelectedIndex());
             Item_Name.setText(d1.getPName());
             Unit_Price.setText(String.valueOf(d1.getPBuyingPricePerUnit()));
             
         });
         
        mytable.setOnMouseClicked(e->{
           
            ItemTable I1=mytable.getItems().get(mytable.getSelectionModel().getFocusedIndex());
            Item_Name.setText(I1.getItem_NameT());
            Unit_Price.setText(String.valueOf(I1.getUnit_PriceT()));
            Quantity.setText(String.valueOf(I1.getQuantityT()));
            
        });
        
    }

    @FXML
    private void handleUpdateevent(ActionEvent event) throws SQLException {
       
        a=Float.parseFloat(Quantity.getText());
        b=Float.parseFloat(Unit_Price.getText());
        total=a*b;
        sum=(sum+(a*b));
       
        
           TotalModel tb = new TotalModel();
    //    float prevTot=Float.parseFloat();
           tb.setTotal(sum);
                
          Document_no=Integer.valueOf(Document.getText());
        String ItemName=Item_Name.getText();
        float UnitPrice=Float.valueOf(Unit_Price.getText());
        float Quantity1=Float.valueOf(Quantity.getText());
        float TotalAmount=total;
        float Alltotal=sum;

       if( Validation.TextValidation.isTextFieldTypeNumber(Document, Document_Noerror, "Document No is Required") 
                && Validation.TextValidation.IsTextFieldNotEmpty(Item_Name, Item_NameError, "Item Name Is Required") 
                &&Validation.TextValidation.isTextFieldTypeNumber(Quantity, Error_Quantity, "Quantity Is a Number")
                && Validation.TextValidation.isTextFieldTypeNumber(Unit_Price, Unit_PriceError, "Unit price Is a Number")
                &&Validation.TextValidation.isTextFieldTypeName(Item_Name, Item_NameError,"Item name Invalid")){
           
        try{
           
        String sql="Update billitems set UnitPrice=?, Quantity=?,TotalAmount=?,Document_no=? Where ItemName=?";
   
       String itemname=Item_Name.getText();
       float UnitPrice1=UnitPrice;
       float Quantity2=Quantity1;
       float tot=UnitPrice1*Quantity2;
       String dcNo=String.valueOf(Document_no);
       
       Connection conn = dbcon.Connect();       
       pst=conn.prepareStatement(sql);
         
       
       pst.setFloat(1, UnitPrice1);
       pst.setFloat(2, Quantity2);
       pst.setFloat(3, tot);
       pst.setString(4, dcNo);
       pst.setString(5, itemname);
        
       
        pst.executeUpdate();
       
       try {
           
            pst=conn.prepareStatement("select Sum(TotalAmount) from billitems where Document_no= "+dcNo+" group by Document_no ");
            rs=pst.executeQuery();
            
            while(rs.next()){
                
               totsum=rs.getString(1);

            }
            
            
             total1.setText(totsum);
            
        } catch (SQLException ex) {
            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            AlertDialog.display("data update succesfully added", "Alert");
//            setCellTable();
           loaddatabaseTable();
            cleartext();
            
       
       } catch (Exception ex) {
           Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    
    }
   
    @FXML
    private void handleDeleteEvent(ActionEvent event) {
         a=Float.parseFloat(Quantity.getText());
        b=Float.parseFloat(Unit_Price.getText());
        total=a*b;
        sum=(sum+(a*b));
          Document_no=Integer.valueOf(Document.getText());
        String ItemName=Item_Name.getText();
        float UnitPrice=Float.valueOf(Unit_Price.getText());
        float Quantity1=Float.valueOf(Quantity.getText());
        float TotalAmount=total;
        float Alltotal=sum;
        
        
         String dcNo=String.valueOf(Document_no);
        TotalModel tb = new TotalModel();
         tb.setTotal(sum);
        String itemname=Item_Name.getText();
       float UnitPrice1=UnitPrice;
       float Quantity2=Quantity1;
       float tot=UnitPrice1*Quantity2;
         
         if( Validation.TextValidation.isTextFieldTypeNumber(Document, Document_Noerror, "Document No is Required") 
                && Validation.TextValidation.IsTextFieldNotEmpty(Item_Name, Item_NameError, "Item Name Is Required") 
                &&Validation.TextValidation.isTextFieldTypeNumber(Quantity, Error_Quantity, "Quantity Is a Number")
                && Validation.TextValidation.isTextFieldTypeNumber(Unit_Price, Unit_PriceError, "Unit price Is a Number")
                &&Validation.TextValidation.isTextFieldTypeName(Item_Name, Item_NameError,"Item name Invalid")){
        
        
        String sql="delete from billitems where ItemName=?";
        
        try {
            
            pst=conn.prepareStatement(sql);
            pst.setString(1, Item_Name.getText());
            int i=pst.executeUpdate();
            
            try {
            Connection conn = dbcon.Connect();
            pst=conn.prepareStatement("select Sum(TotalAmount) from billitems where Document_no= "+dcNo+" group by Document_no ");
            rs=pst.executeQuery();
            
            while(rs.next()){
                
               totsum=rs.getString(1);

            }
            
            System.out.println(totsum);
             total1.setText(totsum);
            
        } catch (SQLException ex) {
            Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            if(i==1)
                AlertDialog.display("Info", "Product delete stuffz");
//               setCellTable();
                loaddatabaseTable();
                cleartext();
            
        } catch (Exception e) {
        }
        
    }
    }  

    @FXML
    private void handleBackEvent(ActionEvent event) throws IOException {
         AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }
    
    private void cleartext(){
        
        Item_Name.clear();
        Quantity.clear();
        Unit_Price.clear();
        
        
    }

    @FXML
    private void handleSearchEvent1() {
        
        Item_Name.setOnKeyReleased(e->{
            
    //        if(Item_Code.getText().equals("")){
                
      //          loaddatabaseTabledatabaseloadedatable();
                
        //    }
          //  else{
                ol.clear();
            String sql="select PID,PName,PBuyingPricePerUnit from product where PName LIKE '%"+Item_Name.getText()+"%' ";
                 //   +"UNION select PID,PName,PBuyingPricePerUnit from product where PName LIKE'%"+Item_Code+"%'"
                 //   +"UNON select PID,PName,PBuyingPricePerUnit from product where PBuyingPricePerUnit LIKE'"+Item_Code+"'";
            
            try {
               Connection conn = dbcon.Connect(); 
              pst=conn.prepareStatement(sql);
                rs=pst.executeQuery();
             while(rs.next()){
                ol.add(new databaseloadtable(rs.getString("PName"), rs.getInt("PID"),rs.getFloat("PBuyingPricePerUnit")));
            }   

                
            }catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,ex);
               // Logger.getLogger(First_WindowController.class.getName()).log(Level.SEVERE,null,ex);
                
            }
            
       // }
        });
        
        
    }

    
}
