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
public class HomeIntController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Stage stage;
     @FXML
    private MenuItem changep;

    @FXML
    private MenuItem log;
     @FXML
    private BorderPane borderpane;

    @FXML
    void ChangeP(ActionEvent event) {

    }

    @FXML
    void Exit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void NewRecord(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/DailyTrans.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }

    @FXML
    void ViewRecord(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/account/viewrecord.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);

    }

    @FXML
    void about(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/omc/userpage/DeleteUser.fxml"));
        BorderPane load = (BorderPane) loader.load();
        borderpane.setCenter(load);
    }

    @FXML
    void logout(ActionEvent event) {

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
