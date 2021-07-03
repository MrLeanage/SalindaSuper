
package Offer;

import DBConnect.DBConnection;
import Offer.InforView.OfferView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;




public class OfferController implements Initializable {
    //@FXML
    //private ImageView combo1;
    private Connection conn=null;
    
    private PreparedStatement pst;
    @FXML
    private TextField description;
    @FXML
    private TextField Offer_ID;
    @FXML
    private TextField offer_rate;
    @FXML
    private TextField offer_name;
    @FXML
    private Button handlingAddButton;
    @FXML
    private TextField end_date;
    @FXML
    private TextField start_date;
    
    
    private DBConnection con;
    private PreparedStatement ps =null;
    private ResultSet rs=null;
    private ObservableList<OfferView> data;
    
    @FXML
    private TableView<OfferView> OfferTable;
    @FXML
    private TableColumn<OfferView, Integer> TofferId;
    @FXML 
    private TableColumn<OfferView, Float> TofferRate;
    @FXML
    private TableColumn<OfferView, String> TofferName;
    @FXML
    private TableColumn<OfferView, String> tstart;
    @FXML
    private TableColumn<OfferView, String> Tend;
    @FXML
    private TableColumn<OfferView, String> TDescripion;
    @FXML
    private Button Update;
    @FXML
    private Button Delete;
    @FXML
    private ImageView combo1;
   
    @FXML
    private Label validofferrate;
    @FXML
    private Label validstartdate;
    @FXML
    private Label validescription;
    @FXML
    private Label validoffername;
    @FXML  
    private Label validenddate;
    
     
     @Override
     
    
    public void initialize(URL url, ResourceBundle rb) {
        
        con = new DBConnection();
        data=FXCollections.observableArrayList();
        //combo2.getItems().addAll("Employee Management", "Offer Managemnet","Customer Management", "Payaroll Management", "Supplier Management", "Inventory Management", "Billing & Income Management", "Finance & Expence Management"); 
        setOfferTable();
        loadDataFromDataBase();
        
    }   
    
    
    
    @FXML
    private void loadAdminHome(ActionEvent event) throws IOException {
        Parent productView = FXMLLoader.load(getClass().getResource("/AppHome/adminhome.fxml"));
        Scene productViewScene = new Scene(productView);
        Stage productStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        productStage.setScene(productViewScene);
        productStage.show();
    } 
    @FXML
    //private void handleBackEvent(ActionEvent event) throws IOException {
        
      //   AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/offermanagement5/OfferMain.fxml"));
        
        //Scene scene = new Scene(home_page);
        //Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        //app.setScene(scene);
        //app.show();
    //}
    
//   public boolean validation(){
//        Pattern p = Pattern.compile("[0-9]");
//        Matcher m = p.matcher(offer_rate.getText());
//        if(offer_rate.getText().isEmpty()){
//           /* Alert a = new Alert(Alert.AlertType.ERROR);
//            a.setTitle("Error");
//            a.setHeaderText(null);
//            a.setContentText("Field Empty");
//            a.showAndWait();*/
//            System.out.println("hhhhhh");
//            return false;
//        }if(!m.matches()){
//            /*Alert a = new Alert(Alert.AlertType.ERROR);
//            a.setTitle("Error");
//            a.setHeaderText(null);
//            a.setContentText("Invalid Character");
//            a.showAndWait();*/
//            System.out.println("hiiii");
//            return false;
//        }else{
//            return true;
//        }
//    }

    //@FXML
    private void handleaddDb(ActionEvent event) throws SQLException {

//        boolean IsOfferRateEmpty=;
//        boolean IsOfferStartDate=;
//        boolean IsOfferDescription=;
//        boolean IsOfferName=;
//        boolean IsOffrEndDate=;
//        
        if((Validation.TextFieldValidation.IsTextFieldNotEmpty(offer_rate, validofferrate, "Offer Rate is Required") 
           && Validation.TextFieldValidation.TextFieldTypeNumber(offer_rate, validofferrate, "Offer Rate Must Be Number"))
           && Validation.TextFieldValidation.IsTextFieldNotEmpty(start_date, validstartdate, "OfferStartDate Is Required")
           && Validation.TextFieldValidation.IsTextFieldNotEmpty(description, validescription, "Offer Description Is Required")
           && Validation.TextFieldValidation.IsTextFieldNotEmpty(offer_name, validoffername, "OfferName is Requird")
           && Validation.TextFieldValidation.IsTextFieldNotEmpty(end_date, validenddate, "End Date is Required")    
                ){
            
            
       
          
       // if (validation()){
         String sql = "INSERT INTO offerscheme(OSName,OSDescription,OSRate,OSStartDate,OSEndDate) values(?,?,?,?,?) ";
         String OSName = offer_name.getText();
         String OSDescription = description.getText();
         String OSRate = offer_rate.getText();
         String OSStartDate = start_date.getText();
         String OSEndDate = end_date.getText();

         DBConnection db2 = new DBConnection();
                Connection con = db2.Connect();
                
                         
                try{
                ps=con.prepareStatement(sql);
                ps.setString(1, offer_name.getText());
                ps.setString(2, description.getText());
                ps.setString(3, offer_rate.getText());
                ps.setString(4,start_date.getText());
                ps.setString(5,end_date.getText());
                 
                int i=ps.executeUpdate();
                if(i==1){
                    System.out.println("Data inserted successfully");
                     setOfferTable();
                     loadDataFromDataBase();
                }
                } catch (Exception ex) {
           
                 JOptionPane.showMessageDialog(null,ex);    
            }
                finally{
                    ps.close();
                }
       // }else{
            /*Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText(null);
            a.setContentText("Invalid Character");
            a.showAndWait();*/
         //   System.out.println("kkkkk");
       // }
        }   
         
         
           }
    private void setOfferTable(){
        
        TofferId.setCellValueFactory(new  PropertyValueFactory<>("OfferId"));
        TofferRate.setCellValueFactory(new PropertyValueFactory<>("OfferRate"));
        TofferName.setCellValueFactory(new PropertyValueFactory<>("OfferName"));
        tstart.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        Tend.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
        TDescripion.setCellValueFactory(new PropertyValueFactory<>("Discription"));
        
        
    }
    
    private void loadDataFromDataBase(){
       data.clear();
        String query = "SELECT * FROM offerscheme";
       try {
           Connection conn = con.Connect();
            ps = conn.prepareStatement(query);
           rs=ps.executeQuery();
           
           while(rs.next()){
               
            //data.add(new OfferList(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            
            OfferView off=new OfferView();
            
            off.setOfferId(rs.getString(1));
            off.setOfferName(rs.getString(2));
            off.setDiscription(rs.getString(3));
            off.setOfferRate(rs.getString(4));
            off.setStartDate(rs.getString(5));
            off.setEndDate(rs.getString(6));
            
            data.add(off);
            
        }
    } catch (Exception ex) {
        
        System.out.println("Exception in loadData : " + ex );
        Logger.getLogger(OfferController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    OfferTable.setItems(data);
        
    }
    @FXML
    private void showclick(){
    try {
        
        OfferView offer=OfferTable.getSelectionModel().getSelectedItem();
        
       
        ps=conn.prepareStatement("SELECT * FROM offerscheme");
        
        tmpID = offer.getOfferId();
        
        Offer_ID.setText(offer.getOfferId());
        offer_name.setText(offer.getOfferName());
        description.setText(offer.getDiscription());
        offer_rate.setText(offer.getOfferRate());
        start_date.setText(offer.getStartDate());
        end_date.setText(offer.getEndDate());
        
       ps.close();
       rs.close();
        
    } catch (SQLException ex) {
        System.out.println(ex);
        Logger.getLogger(OfferController.class.getName()).log(Level.SEVERE, null, ex);
    }
         
    }
    
    @FXML
    private void handleBackEvent(ActionEvent event) throws IOException {
         
         AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/employeemanagement2/OfferLoginNew2.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
       
    }
    
    static  String tmpID;
    @FXML
    private void HandleUpdate(ActionEvent event) {
        
        
        String sql="UPDATE offerscheme set OSName=?,OSDescription=?,OSRate=?,OSStartDate=?,OSEndDate=? where OSID='"+tmpID+"'";
    
        try {
            
       
         ps=conn.prepareStatement(sql); 
         String OSName = offer_name.getText();
         String OSDescription = description.getText();
         String OSRate = offer_rate.getText();
         String OSStartDate = start_date.getText();
         String OSEndDate = end_date.getText();
         
         ps.setString(1,OSName );
         ps.setString(2,OSDescription);
         ps.setString(3,OSRate );
         ps.setString(4,OSStartDate );
         ps.setString(5,OSEndDate );
         
         int i=ps.executeUpdate();
         if(i==1){
             JOptionPane.showMessageDialog(null, "Update SuccessFully");
             System.out.println("Update SuccessFully");
             loadDataFromDataBase();
         }
    } catch (Exception ex) {
        
        
              JOptionPane.showMessageDialog(null, "Update UnSuccessFully");
            System.out.println(ex);
        Logger.getLogger(OfferController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        data.clear();
        
    try {
        OfferView offer=OfferTable.getSelectionModel().getSelectedItem();
        String sql="DELETE from offerscheme  where OSID= ?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,Offer_ID.getText());
        int i=ps.executeUpdate();
        if(i==1){
            JOptionPane.showMessageDialog(null, "Deleted SucessFully");
            loadDataFromDataBase();
        }
        //ps.executeUpdate();
        ps.close();
        //loadDataFromDataBase();
    } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex);
        Logger.getLogger(OfferController.class.getName()).log(Level.SEVERE, null, ex);
       
    }
        
        
    }
   
}
