/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.material;

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
import matplace.model.Material;
import matplace.presentacio.controller.ControllerGestioMateriales;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.MaterialUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerEdicionMaterial extends Application implements Initializable {

    @FXML
    TextField tf_nombre, tf_cantidad, tf_EAN;

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

        Material material = ControllerGestioMateriales.getMaterialSeleccionado();
        tf_nombre.setText(material.getNombre());
        tf_cantidad.setText(Integer.toString(material.getCantidad()));
        tf_EAN.setText(Integer.toString(material.getEAN()));
        ta_descripcion.setText(material.getDescripcion());

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
            Logger.getLogger(ControllerEdicionMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonEditar(ActionEvent event) {

        Material material = new Material();
        material.setNombre(tf_nombre.getText());
        material.setCantidad(Integer.parseInt(tf_cantidad.getText()));
        material.setEAN(Integer.parseInt(tf_EAN.getText()));
        material.setDescripcion(ta_descripcion.getText());

        new MaterialUtils().update(material);
        ControllerMenuPrincipal.ventanaInformativa("Material editado con exito.");
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonDel(ActionEvent event) {

        new MaterialUtils().delete(ControllerGestioMateriales.getMaterialSeleccionado());
        ControllerMenuPrincipal.ventanaInformativa("Material eliminado con exito.");
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_GestioMateriales.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerEdicionMaterial.class.getName()).log(Level.SEVERE, null, ex);
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
