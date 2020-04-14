/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omc.userpage;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class UserRegistrationController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXComboBox<String> CombGender;

    @FXML
    private JFXTextField txtPhoneNo;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField jPassword;

    @FXML
    private JFXComboBox<String> txtState;

    @FXML
    private JFXComboBox<String> CombQualification;
    
    @FXML
    private ImageView jpassport;
    
    
    
    Stage stage;

    @FXML
    void Back(ActionEvent event) {

    }

    @FXML
    void Cancel(ActionEvent event) {

    }

    @FXML
    void CreateAcct(ActionEvent event) {
        if(txtName.getText().equals("")|txtAddress.getText().equals("")|CombGender.getValue().equals("")|txtPhoneNo.getText().equals("")|txtUsername.getText().equals("")|jPassword.getText().equals("")|jpassport.getImage().equals(null)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Blank");
            alert.setContentText("You must fil all field");
            alert.showAndWait();
        }
        else{
         try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igrdb","root","");
             String sql= "insert into userregtb (name,address,gender,qualification,phoneno,state,username,password,passport) values('"+txtName.getText()+"','"+txtAddress.getText()+"','"+CombGender.getValue()+"','"+CombQualification.getValue()+"','"+txtPhoneNo.getText()+"','"+txtState.getValue()+"','"+txtUsername.getText()+"','"+jPassword.getText()+"','"+jpassport.getImage()+"')";
             PreparedStatement prepare = con.prepareStatement(sql);
             prepare.execute();
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Database Response");
             alert.setContentText("Account created successful");
             alert.showAndWait();
             
             txtName.setText("");
             txtAddress.setText("");
             CombGender.setValue("");
              txtPhoneNo.setText("");
              txtUsername.setText("");
              jPassword.setText("");
              txtState.setValue("");
              CombQualification.setValue("");
              jpassport.setImage(null);
              
              
             
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(UserRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(UserRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
    @FXML
    void UploadPassport(ActionEvent event) {
         FileChooser filechooser = new FileChooser();
        File file = filechooser.showOpenDialog(null);
        
        System.out.println(file.getAbsoluteFile());
        
        try {
            BufferedImage bufferimage = ImageIO.read(file);
            WritableImage toFXImage = SwingFXUtils.toFXImage(bufferimage, null);
            jpassport.setImage(toFXImage);
        } catch (IOException ex) {
            Logger.getLogger(UserRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> ListofCrime = FXCollections.observableArrayList();
        ListofCrime.add("Male");
        ListofCrime.add("Female");
        CombGender.setItems(ListofCrime);
        
        ObservableList<String> state = FXCollections.observableArrayList();
        state.add("Ondo");
        state.add("Osun");
        state.add("Oyo");
        state.add("Kwara");
        state.add("Lagos");
        state.add("Ekiti");
        state.add("Kogi");
        state.add("Edo");   
        state.add("Delta");
        txtState.setItems(state);
        
        ObservableList <String> qualification = FXCollections.observableArrayList();
        qualification.add("Primary Six Certificate");
        qualification.add("O Level Certificate");
        qualification.add("National Diploma");
        qualification.add("NCE Certificate");
        qualification.add("Higher National Diploma");
        qualification.add("BSc");
        qualification.add("MSc");
        qualification.add("PhD");
        CombQualification.setItems(qualification);
    }    
    public Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
