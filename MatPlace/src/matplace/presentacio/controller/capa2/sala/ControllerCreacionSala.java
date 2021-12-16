/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.sala;

import java.net.URL;
import java.util.ArrayList;
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
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.SalaUtils;
import matplace.utils.Validador;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerCreacionSala extends Application implements Initializable {

    @FXML
    TextField tf_nombre, tf_cantidad;

    @FXML
    TextArea ta_descripcion;

    SalaUtils salaUtils = new SalaUtils();

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
    private void handleButtonCrear(ActionEvent event) {

        if (!Validador.checkNum(tf_cantidad.getText())) {
            ControllerMenuPrincipal.ventanaInformativa("El campo \"Capacidad máxima\" debe ser un número.");
            return;
        }

        Sala sala = new Sala();
        sala.setNombre(tf_nombre.getText());
        sala.setCapacidad(Integer.parseInt(tf_cantidad.getText()));
        sala.setDescripcion(ta_descripcion.getText());
        sala.setReservas(new ArrayList<>());
        
        salaUtils.create(sala);

        ControllerMenuPrincipal.ventanaInformativa("Sala creada con exito.");

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
            Logger.getLogger(ControllerCreacionSala.class.getName()).log(Level.SEVERE, null, ex);
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
