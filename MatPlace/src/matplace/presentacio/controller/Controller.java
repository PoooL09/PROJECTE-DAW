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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class Controller extends Application implements Initializable {

    @FXML
    TableView tvFicheros;

    @FXML
    Button btnLogout;

    @FXML
    TableColumn colNombre, colTam, colFechaSubida;

    @FXML
    ImageView logo;

    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

       
    }

    /**
     * Sube un objeto a la nuve
     *
     * @param event
     */
    @FXML
    private void handleButtonSubir(ActionEvent event) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
