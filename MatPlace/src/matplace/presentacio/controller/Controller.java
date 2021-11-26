/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class Controller extends Application implements Initializable {

    @FXML
    Button btnLogout;
    
    @FXML
    ImageView logo;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

       logo.setImage(new Image("icon.png"));
        
    }

    /**
     * 
     *
     * @param event
     */
    @FXML
    private void handleButtonSalas(ActionEvent event) {

    }
     /**
     * 
     *
     * @param event
     */
    @FXML
    private void handleButtonPersonas(ActionEvent event) {

    }
     /**
     * 
     *
     * @param event
     */
    @FXML
    private void handleButtonReservas(ActionEvent event) {

    }
     /**
     * 
     *
     * @param event
     */
    @FXML
    private void handleButtonMateriales(ActionEvent event) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
