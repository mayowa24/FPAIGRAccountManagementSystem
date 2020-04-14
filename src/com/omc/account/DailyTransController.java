/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.account;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class DailyTransController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private DatePicker jtxtDate;
      @FXML
    private BorderPane borderpane;

    @FXML
    private JFXComboBox<String> CombDescription;

    @FXML
    private JFXTextField txtQuantity;
    Stage stage;
    @FXML
    private Label result;

    @FXML
    private JFXComboBox<Integer> txtRate;

    @FXML
    private TableColumn<dailyTable, String> date;

    @FXML
    private TableColumn<dailyTable, String> Description;

    @FXML
    private TableColumn<dailyTable, String> Quantity;

    @FXML
    private TableColumn<dailyTable, String> Amount;
    
    @FXML
    private TableView<dailyTable> dailytable;
    
    ObservableList<dailyTable> trans;
    double sum=0;

    @FXML
    private Label txtAmount;
    DecimalFormat df = new DecimalFormat("0.00");

    @FXML
    void Close(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/BankDeposit.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }

    @FXML
    void Post(ActionEvent event) {
        
        trans = FXCollections.observableArrayList();
        if (txtAmount.getText().equals("")){
            Alert alert = new Alert (Alert.AlertType.WARNING);
            alert.setTitle("Important field");
            alert.setContentText("you must calculate before posting");
            alert.showAndWait();
        }
        else if(jtxtDate.getValue().equals("")|CombDescription.getValue().equals("")|txtQuantity.getText().equals("")|txtRate.getValue().equals("")){
            Alert alert = new Alert (Alert.AlertType.WARNING);
            alert.setTitle("Blank field");
            alert.setContentText("All fields required");
            alert.showAndWait();
        }
        else{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb","root","");
            String sql = "INSERT INTO dailyreport(date,description,quantity,rate,amount)VALUES('"+jtxtDate.getValue()+"','"+CombDescription.getValue()+"','"+txtQuantity.getText()+"','"+txtRate.getValue()+"','"+ txtAmount.getText()+"')";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.execute(sql);
            
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb","root","");
            String sqll = "SELECT * FROM dailyreport where date='"+jtxtDate.getValue()+"'";
            PreparedStatement prepare = conn.prepareStatement(sqll);
            ResultSet rrs = prepare.executeQuery();
            while(rrs.next()){
                trans.add(new dailyTable(rrs.getString("date"), rrs.getString("description"), rrs.getString("quantity"),rrs.getString("amount")));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));
                 Description.setCellValueFactory(new PropertyValueFactory<>("description"));
                 Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                 Amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
                 double amount= rrs.getDouble("amount");
                    sum+=amount;
                    result.setText(""+sum);
                    
                 
            }
                
            
            dailytable.setItems(trans);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Database Communication");
            alert.setContentText("Record post successful");
            alert.showAndWait();
            
            
           
            
            
            
            jtxtDate.setValue(null);
            CombDescription.setValue("");
            txtQuantity.setText("");
            txtRate.setValue(null);
            txtAmount.setText("");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DailyTransController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DailyTransController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }

    @FXML
    void calculate(ActionEvent event) {
        double amount;
        amount = Integer.parseInt(txtQuantity.getText())*txtRate.getValue();
        txtAmount.setText(df.format(amount));
       

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> describe = FXCollections.observableArrayList();
        describe.add("Photocopy");
        describe.add("Printing");
        describe.add("Type and Print");
        CombDescription.setItems(describe);
        
        ObservableList<Integer> rate=FXCollections.observableArrayList();
        rate.add(5);
        rate.add(7);
        rate.add(10);
        rate.add(50);
        rate.add(70);
        rate.add(100);
        txtRate.setItems(rate);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
