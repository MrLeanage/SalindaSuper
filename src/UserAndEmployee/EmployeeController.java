/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAndEmployee;

import DBConnect.DBConnection;
import UserAndEmployee.InforView.EmployeeView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javax.swing.JOptionPane;


public class EmployeeController implements Initializable {
    
    
    
   @FXML
   private ComboBox combo5;
   
   
   private PreparedStatement pst;
    @FXML
   private TextField Ename;
    @FXML
    private TextField Eaddress;
    @FXML
    private TextField Ebirth;
    @FXML
    private TextField Enic;
    @FXML
   private TextField Ephn;
    @FXML
   private TextField Eemail;
    @FXML
    private TextField EbankName;
    @FXML
    private TextField Eacc;
    @FXML
   private TextField Eid;
    @FXML
    private TextField Etype;
    @FXML
    private TextField Euser;
    @FXML
    private PasswordField epass;
    @FXML
    private Button submit;
   
   
 //  private Connection con =null;
    private DBConnection con;
    private PreparedStatement ps =null;
    private ResultSet rs=null;
    private ObservableList<EmployeeView> data;
    
    @FXML
    private TableView<EmployeeView> EmployeeTable;
    @FXML
    private TableColumn<?, ?> Tid;
    @FXML
    private TableColumn<?, ?> Tname;
    @FXML
    private TableColumn<?, ?> Taddress;
    @FXML
    private TableColumn<?, ?> Tnic;
    @FXML
    private TableColumn<?, ?> Tpno;
    @FXML
    private TableColumn<?, ?> Temail;
    @FXML
    private TableColumn<?, ?> Tusername;
    @FXML
    private TableColumn<?, ?> Tpassword;
    @FXML
    private TableColumn<?, ?> Tbankname;
    @FXML
    private TableColumn<?, ?> Tbankno;
    @FXML
    private TableColumn<?, ?> Temptype;
    @FXML
    private Button submit2;
    @FXML
    private TableColumn<?, ?> TDOB;
    @FXML
    private Button edit;
    
    @FXML
    private Label validName;
    @FXML
    private Label validAddress;
    @FXML
    private Label validDOB;
    @FXML
    private Label validNIC;
    @FXML
    private Label validPhn;
    @FXML
    private Label validEmail;
    @FXML
    private Label validUsername;
    @FXML
    private Label validPassword;
    @FXML
    private Label validBankname;
    @FXML
    private Label validAcc;
    @FXML
    private Label validID;
    @FXML
    private Label validType;
    @FXML
    private Rectangle LV;
    @FXML
    private Label LabelId;
    
  

   
    
    public void initialize(URL url, ResourceBundle rb) {
        
         //con = DBConnection.Connect();
         
         con = new DBConnection();
        data=FXCollections.observableArrayList();
        
   
        setemployeeTable();
       loadDataFromDataBase();
        
        
     // combo5.getItems().addAll("Employee Management", "Offer Managemnet","Customer Management", "Payaroll Management", "Supplier Management", "Inventory Management", "Billing & Income Management", "Finance & Expence Management"); 
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
    private void handlingbackButton(ActionEvent event) throws IOException {
        
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/employeemanagement2/FXMLDocument.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

    @FXML
    private void handlingLogoutInterface(ActionEvent event) throws IOException {
        
        AnchorPane home_page = (AnchorPane)FXMLLoader.load(getClass().getResource("/employeemanagement2/FXMLDocument.fxml"));
        
        Scene scene = new Scene(home_page);
        Stage app=(Stage)((Node) event.getSource()).getScene().getWindow();
        app.setScene(scene);
        app.show();
    }

  @FXML
    private void handleEmployee(ActionEvent event) throws SQLException  {
            
    
    
//   boolean IsEmployeeName=;
//   boolean IsEmployeeAdd=;
//   boolean IsEmployeeDOB=;
//   boolean IsEmployeeNIC=;
//   boolean IsEmployeePhnNo=;
//   boolean IsEmployeeEmail=;
//   boolean IsEmployeeUserName=;
//   boolean IsEmployeeBankName=;
//   boolean IsEmployeePassword=;
//   boolean IsEmployeeBankNo=;
//   boolean IsEmployeetype=;
//   boolean IsEmployeeBankNo1=;
   
    
   if(    
       
       Validation.TextFieldValidations.IsTextFieldNotEmpty(Ename, validName, " Name Is Required")
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(Eaddress, validAddress, " Address Is Required")
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(Ebirth, validDOB, "DOB Is Required")
      && (Validation.TextFieldValidations.IsTextFieldNotEmpty(Enic, validNIC, " NIC Is Required") && Validation.TextFieldValidations.isTextFieldTypeNIC(Enic, validNIC, " NIC Is Invalid"))
      && (Validation.TextFieldValidations.IsTextFieldNotEmpty(Ephn, validPhn, " PhoneNo Is Required") &&  Validation.TextFieldValidations.isTextFieldTypePhoneNumber(Ephn, validPhn, "Invalid Phone Number"))
      &&( Validation.TextFieldValidations.IsTextFieldNotEmpty(Eemail, validEmail, " Email Is Required") && Validation.TextFieldValidations.isTextFieldTypeEmail(Eemail, validEmail, "Invalid Email"))
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(Euser, validUsername, " UserName Is Required")
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(EbankName, validBankname, "BankName Is Required")
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(epass, validPassword, "Password Is Required")
      &&( Validation.TextFieldValidations.IsTextFieldNotEmpty(Eacc, validAcc, "Bank NoIs Required")&& Validation.TextFieldValidations.TextFieldTypeNumber(Eacc, validAcc, "BankNo is must Number"))
      && Validation.TextFieldValidations.IsTextFieldNotEmpty(Etype, validType, "EType Is Required")
      
       
      
           
           
           ){
    
    String query="INSERT INTO employee(ENIC,EName,EAddress,EDateOfBirth,EBankNo,EBankName,EType,EPhoneNo1,EPassword,EEmail, EUser)"  + "values(?,?,?,?,?,?,?,?,?,?,?)" ;
          
            String ENIC = Enic.getText();
         
            String Ename =this.Ename.getText();
            String EAddress= Eaddress.getText();
            String EDateOfBirth=Ebirth.getText();
            String EBankNo=EbankName.getText();
            String EBankName=Eacc.getText();
            String EType=Etype.getText();
            String EPhoneNo1=Ephn.getText();
            String Epassword=epass.getText();
            String EEmail=Eemail.getText();
            String Euser=this.Euser.getText();
         
             //DBConnection db2 = new DBConnection();
             //Connection con = DBConnection.Connect();
             
       try {
           Connection conn = con.Connect();
           ps = conn.prepareStatement(query);
           
           ps.setString(1, Enic.getText());
           ps.setString(2, this.Ename.getText());
           ps.setString(3, Eaddress.getText());
           ps.setString(4, Ebirth.getText());
           ps.setString(5, Eacc.getText());
           ps.setString(6, EbankName.getText());
           ps.setString(7, Etype.getText());
           ps.setString(8, Ephn.getText());
           ps.setString(9, epass.getText());
           ps.setString(10,Eemail.getText() );
           ps.setString(11, this.Euser.getText());
           
            int i=ps.executeUpdate();
                if(i==1){
                    System.out.println("Data inserted successfully");
                     setemployeeTable();
                     loadDataFromDataBase();
                }
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex);
           Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
       }
       finally{
           ps.close();
       }
   }
    }
   
    
    
   public void setemployeeTable(){


    Tid.setCellValueFactory(new PropertyValueFactory<>("Empno"));
    Tnic.setCellValueFactory(new PropertyValueFactory<>("EmpNIC"));
    Tname.setCellValueFactory(new PropertyValueFactory<>("Empname"));
    Taddress.setCellValueFactory(new PropertyValueFactory<>("Empaddress"));
    TDOB.setCellValueFactory(new PropertyValueFactory<>("EmpDOB"));
    Tbankno.setCellValueFactory(new PropertyValueFactory<>("EmpbankaccNO"));
    Tbankname.setCellValueFactory(new PropertyValueFactory<>("EmpbankName"));
    Temptype.setCellValueFactory(new PropertyValueFactory<>("EmpuserType"));
    Tpno.setCellValueFactory(new PropertyValueFactory<>("Emppno"));
    Tpassword.setCellValueFactory(new PropertyValueFactory<>("Emppassword"));
    Temail.setCellValueFactory(new PropertyValueFactory<>("Empemail"));
    Tusername.setCellValueFactory(new PropertyValueFactory<>("Empusername"));
    
    
    
    
    











}
   
  public void loadDataFromDataBase(){
        data.clear();
        String query = "SELECT * FROM employee";
       try {
           Connection conn = con.Connect();
            ps = conn.prepareStatement(query);
           rs=ps.executeQuery();
           
           while(rs.next()){
               
             // data.add(new AddEmployeeList(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12)));
            //data.add(new AddEmployeeList(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
         
            
            EmployeeView Add =new EmployeeView();
               
               Add.setEmpno(rs.getString(1));
               Add.setEmpNIC(rs.getString(2));
               Add.setEmpname(rs.getString(3));
               Add.setEmpaddress(rs.getString(4));
               Add.setEmpDOB(rs.getString(5));
               Add.setEmpbankaccNO(rs.getString(6));
               Add.setEmpbankName(rs.getString(7));
               Add.setEmpuserType(rs.getString(8));
               Add.setEmppno(rs.getString(9));
               Add.setEmppassword(rs.getString(10));
               Add.setEmpemail(rs.getString(11));
               Add.setEmpusername(rs.getString(12));
               
              
             data.add(Add);
               
           }
           
          
       } catch (SQLException ex) {
           System.out.println(ex);
           Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       EmployeeTable.setItems(data);
  }
  
 static  String tmpId;
  @FXML
    private void showclick(){
        String query = "SELECT * FROM employee";
        EmployeeView emp = EmployeeTable.getSelectionModel().getSelectedItem();
       try {
           Connection conn = con.Connect();
            ps = conn.prepareStatement(query);
           //ps=con.prepareStatement("SELECT * FROM employee");
           
           tmpId=emp.getEmpno();
           
           Eid.setText(emp.getEmpno());
           Enic.setText(emp.getEmpNIC());
           Ename.setText(emp.getEmpname());
           Eaddress.setText(emp.getEmpaddress());
           Ebirth.setText(emp.getEmpDOB());
           Eacc.setText(emp.getEmpbankaccNO());
           EbankName.setText(emp.getEmpbankName());
           Etype.setText(emp.getEmpuserType());
           Ephn.setText(emp.getEmppno());
           epass.setText(emp.getEmppassword());
           Eemail.setText(emp.getEmpemail());
           Euser.setText(emp.getEmpusername());
           
          
       } catch (SQLException ex) {
           Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
   
    }   

    @FXML
    private void UpdateEmployee(ActionEvent event) {
        
        String query="UPDATE employee set ENIC=?,EName=?,EAddress=?,EDateOfBirth=?,EBankNo=?,EBankName=?,EType=?,EPhoneNo1=?,Epassword=?,EEmail=?, Euser=? where ENo ='"+tmpId+"'";
        
       try { 
           Connection conn = con.Connect();
            ps = conn.prepareStatement(query);
          // ps=con.prepareStatement(sql);
        //String ENo = Eid.getText();
        String ENIC = Enic.getText();
        String EName = Ename.getText();
        String EAddress = Eaddress.getText();
        String EDateOfBirth = Ebirth.getText();
        String EBankNo= Eacc.getText();
        String EBankName = EbankName.getText();
        String EType = Etype.getText();
        String EPhoneNo1 = Ephn.getText();
        String Epassword = epass.getText();
        String EEmail = Eemail.getText();
        String Euser = Etype.getText();
        
        
        ps.setString(1, ENIC);
        ps.setString(2, EName);
        ps.setString(3, EAddress);
        ps.setString(4, EDateOfBirth);
        ps.setString(5, EBankNo);
        ps.setString(6, EBankName);
        ps.setString(7, EType);
        ps.setString(8, EPhoneNo1);
        ps.setString(9, Epassword);
        ps.setString(10, EEmail);
        ps.setString(11, Euser);
        
        int i=ps.executeUpdate();
         if(i==1){
             JOptionPane.showMessageDialog(null, "Update SuccessFully");
             System.out.println("Update SuccessFully");
             loadDataFromDataBase();
         }
        
        
       } catch (SQLException ex) {
           System.out.println(ex);
           Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @FXML
    private void Deleting(ActionEvent event) {
        
             data.clear();
        EmployeeView emp =EmployeeTable.getSelectionModel().getSelectedItem();
    try {
        
        String query="DELETE from employee where ENo= ?";
        Connection conn = con.Connect();
            ps = conn.prepareStatement(query);
        //ps=con.prepareStatement(sql);
        ps.setString(1,Eid.getText());
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
        //aaLogger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       
    }
        
   
    }
    }
    