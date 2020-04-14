/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.account;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class BankDepositController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField txtExpenses;

    @FXML
    private JFXTextField txtDeposit;

    @FXML
    private JFXTextField txtHand;

    @FXML
    private DatePicker Date;
    Stage stage;

    @FXML
    void Post(ActionEvent event) {
        if (Date.getValue().equals(null)|txtDeposit.getText().equals("")|txtHand.getText().equals("")|txtExpenses.getText().equals("")){
            Alert alert = new Alert (Alert.AlertType.WARNING);
            alert.setTitle("Blank field");
            alert.setContentText("All fields required");
            alert.showAndWait();
        }
        else{
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb","root","");
             String sql = "insert into expenses(date,expenses,bankdep,handcash)values('"+Date.getValue()+"','"+Double.parseDouble(txtExpenses.getText())+"','"+Double.parseDouble(txtDeposit.getText())+"','"+Double.parseDouble(txtHand.getText())+"')";
             PreparedStatement prepare = connection.prepareStatement(sql);
             prepare.execute();
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Database Communication");
            alert.setContentText("Record post successful");
            alert.showAndWait();
            
            Date.setValue(null);
            txtExpenses.setText("");
            txtDeposit.setText("");
            txtHand.setText("");
            
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(BankDepositController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(BankDepositController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
