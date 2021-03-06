/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.cliente;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import matplace.model.Cliente;
import matplace.presentacio.controller.ControllerGestioPersonas;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.ClienteUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerEdicionCliente extends Application implements Initializable {

    @FXML
    TextField tf_nombre, tf_apellidos, tf_mail, tf_dni, tf_tel;

    @FXML
    CheckBox cb_conserje;

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
            Cliente cliente = ControllerGestioPersonas.getPersonaSeleccionada();
            tf_nombre.setText(cliente.getNombre());
            tf_apellidos.setText(cliente.getApellidos());
            tf_mail.setText(cliente.getMail());
            tf_dni.setText(cliente.getDNI());
            tf_tel.setText(cliente.getTelefono());
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
    private void handleButtonDel(ActionEvent event) {

        new ClienteUtils().delete(ControllerGestioPersonas.getPersonaSeleccionada());
        ControllerMenuPrincipal.ventanaInformativa("Cliente eliminado con exito.");
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonSalas(ActionEvent event
    ) {
        Node st = (Node) event.getSource();

        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerEdicionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonEditar(ActionEvent event
    ) {

        Cliente cliente = new Cliente();
        cliente.setNombre(tf_nombre.getText());
        cliente.setApellidos(tf_apellidos.getText());
        cliente.setMail(tf_mail.getText());
        cliente.setDNI(tf_dni.getText());
        cliente.setTelefono(tf_tel.getText());

        new ClienteUtils().update(cliente);
        ControllerMenuPrincipal.ventanaInformativa("Cliente editado con exito.");

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event
    ) {

        s = "/matplace/presentacio/view/FXML_GestioPersonas.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerEdicionCliente.class.getName()).log(Level.SEVERE, null, ex);
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
