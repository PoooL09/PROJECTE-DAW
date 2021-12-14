/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.cliente;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerMostrarCliente extends Application implements Initializable {

    @FXML
    Text text_title, text_nombre, text_apellido, text_mail, text_dni, text_tel;

    @FXML
    Checkbox cb_conserje;

    String s;

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
            Logger.getLogger(ControllerMostrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonEditar(ActionEvent event) {

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonEliminar(ActionEvent event) {

    }


    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/GestioPersonas.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerMostrarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
