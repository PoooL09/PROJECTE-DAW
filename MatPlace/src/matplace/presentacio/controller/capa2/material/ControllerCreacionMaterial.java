/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.material;

import java.awt.*;
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
public class ControllerCreacionMaterial extends Application implements Initializable {

    @FXML
    ImageView logo;

    @FXML
    TextField tf_nombre, tf_cantidad;

    @FXML
    TextArea ta_descripcion;

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
        Node st = (Node) event.getSource();

        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerCreacionMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_GestioMaterial.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerCreacionMaterial.class.getName()).log(Level.SEVERE, null, ex);
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

}
