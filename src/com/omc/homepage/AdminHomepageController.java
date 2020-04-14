/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.homepage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class AdminHomepageController implements Initializable {

    /**
     * Initializes the controller class.
     */
     
    
    @FXML
    private MenuItem mLogout;

    @FXML
    private MenuItem mExit;

    @FXML
    private MenuItem mCreate;

    @FXML
    private MenuItem mDelete;

      @FXML
    private MenuItem mRec;
     @FXML
    private BorderPane borderpane;

   

      @FXML
    void DeleteUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/userpage/DeleteUser.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }
    @FXML
    void about(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/homepage/about.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }


    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void Logout(ActionEvent event) {

    }

    @FXML
    void NewUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/userpage/UserRegistration.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }
     @FXML
    void Deposit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/BankDeposit.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
        
    }
     @FXML
    void AddRec(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/DailyTrans.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }
      @FXML
    void ViewRec(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/viewrecord.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }


    

    
    
Stage stage;
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
