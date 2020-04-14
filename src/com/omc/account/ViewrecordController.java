/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.account;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class ViewrecordController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private DatePicker date;
        @FXML
    private TableView<TableModel> table;

    @FXML
    private TableColumn<TableModel, String> description;

    @FXML
    private TableColumn<TableModel, String> quantity;

    @FXML
    private TableColumn<TableModel, String> rate;

    @FXML
    private TableColumn<TableModel, String> amount;
    Stage stage;
    ObservableList<TableModel> oblist;
    double totalamount;

    @FXML
    void viewRecord(ActionEvent event) {
         oblist = FXCollections.observableArrayList();
         try {
             Class.forName("com.mysql.jdbc.Driver");
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ViewrecordController.class.getName()).log(Level.SEVERE, null, ex);
         }
             
         try {
             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb", "root", "");
             String sql ="SELECT description,quantity,rate,amount FROM dailyreport where date='" + date.getValue()+"'";
             PreparedStatement prepareStatement = connection.prepareStatement(sql);
             ResultSet rs = prepareStatement.executeQuery();
              
             while(rs.next()){
                    double amount =  rs.getDouble("amount");
                    totalamount+=amount;
                 oblist.add(new TableModel(rs.getString("description"), rs.getString("quantity"), rs.getString("rate"),rs.getString("amount")));
                                
                
             }
             System.out.println(totalamount);
                 description.setCellValueFactory(new PropertyValueFactory<>("description"));
                 quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                 rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
                 amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

                 table.setItems(oblist);
                 
         } catch (SQLException ex) {
             Logger.getLogger(ViewrecordController.class.getName()).log(Level.SEVERE, null, ex);
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
