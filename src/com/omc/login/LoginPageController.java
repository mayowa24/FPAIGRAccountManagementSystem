/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.omc.homepage.AdminHomepageController;
import com.omc.homepage.HomeIntController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class LoginPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField password;

    @FXML
    void login(ActionEvent event) throws IOException {
        
         try {
             
             Stage stage = new Stage();
             
             try {
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb", "root", "");
             String sql = "SELECT* FROM userregtb WHERE username='"+txtUsername.getText()+"'and password='"+password.getText()+"'";
             PreparedStatement prepareStatement = connection.prepareStatement(sql);
             ResultSet rs  = prepareStatement.executeQuery();
              
             if(rs.next()){
                 
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/homepage/homeInt.fxml"));
                 BorderPane load = (BorderPane) loader.load();
                 HomeIntController controller = (HomeIntController) loader.getController();
                 controller.setStage(stage);
                 Scene scene = new Scene(load);
                 stage.setScene(scene);
                 stage.show();
                 
             }
              else if (txtUsername.getText().equals("")|password.getText().equals("")){
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Blank Field");
                 alert.setContentText("you must fill both fields");
                 alert.showAndWait();
             }
             else if(txtUsername.getText().equals("admin")&password.getText().equals("csigr")){
                 FXMLLoader loader  = new FXMLLoader(getClass().getResource("/com/omc/homepage/AdminHomepage.fxml"));
                 BorderPane load = (BorderPane) loader.load();
                 AdminHomepageController controller = (AdminHomepageController) loader.getController();
                 controller.setStage(stage);
                 Scene scene = new Scene(load);
                 stage.setScene(scene);
                 stage.show();
             }
             else{
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Access Denied");
                 alert.setContentText("incorrect password or username");
                 alert.showAndWait();
                 
                 txtUsername.setText("");
                 password.setText("");
             } 
            
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }
     @FXML
    void Exit(ActionEvent event) {
        System.exit(0);
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
Stage stage;
}
