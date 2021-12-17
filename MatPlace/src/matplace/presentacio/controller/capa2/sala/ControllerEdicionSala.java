/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.sala;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import matplace.model.Sala;
import matplace.presentacio.controller.ControllerGestioSalas;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.SalaUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerEdicionSala extends Application implements Initializable {

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
        try {
            Sala sala = ControllerGestioSalas.getSalaSeleccionada();
            tf_nombre.setText(sala.getNombre());
            tf_cantidad.setText(Integer.toString(sala.getCapacidad()));
            ta_descripcion.setText(sala.getDescripcion());

        } catch (java.lang.NullPointerException e) {
            System.out.println("null");
        }

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
            Logger.getLogger(ControllerEdicionSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonEditar(ActionEvent event) {

        Sala sala = new Sala();
        sala.setNombre(tf_nombre.getText());
        sala.setCapacidad(Integer.parseInt(tf_cantidad.getText()));
        sala.setDescripcion(ta_descripcion.getText());

        new SalaUtils().update(sala);
        ControllerMenuPrincipal.ventanaInformativa("Sala editada con exito.");
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonDel(ActionEvent event) {

        new SalaUtils().delete(ControllerGestioSalas.getSalaSeleccionada());
        ControllerMenuPrincipal.ventanaInformativa("Sala eliminado con exito.");
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_GestioSalas.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerEdicionSala.class.getName()).log(Level.SEVERE, null, ex);
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
