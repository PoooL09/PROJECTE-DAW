/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerMenuPrincipal extends Application implements Initializable {

    @FXML
    ImageView logo;

    String s;

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
        s = "/matplace/presentacio/view/FXML_GestioSalas.fxml";
        cambioScene((Node) event.getSource());
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonPersonas(ActionEvent event) {
        s = "/matplace/presentacio/view/FXML_GestioPersonas.fxml";
        cambioScene((Node) event.getSource());
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonReservas(ActionEvent event) {
        s = "/matplace/presentacio/view/FXML_GestioReservas.fxml";
        cambioScene((Node) event.getSource());
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonMateriales(ActionEvent event) {
        s = "/matplace/presentacio/view/FXML_GestioMateriales.fxml";
        cambioScene((Node) event.getSource());
    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(s));

        Scene scene = new Scene(root);

        stage.setTitle("MatPlace");
        stage.setScene(scene);
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    public static void ventanaInformativa(String s) {
        Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
        dialogoAlerta.setTitle("Ventana de información");
        dialogoAlerta.setHeaderText(null);
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        dialogoAlerta.setContentText(s);
        dialogoAlerta.showAndWait();
    }

}
