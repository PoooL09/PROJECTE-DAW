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
import javafx.stage.Stage;
import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.ClienteUtils;
import matplace.utils.ConserjeUtils;
import matplace.utils.Validador;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerCreacionCliente extends Application implements Initializable {

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
            Logger.getLogger(ControllerCreacionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        if (!Validador.checkNum(tf_tel.getText())) {
            ControllerMenuPrincipal.ventanaInformativa("El campo \"Telefeno\" debe ser un número.");
            return;
        }
        if (!Validador.chekMail(tf_mail.getText())) {
            ControllerMenuPrincipal.ventanaInformativa("El campo \"mail\" no tiene el formato adecuado.");
            return;
        }
        if (!Validador.checkDNI(tf_dni.getText())) {
            ControllerMenuPrincipal.ventanaInformativa("El campo \"DNI\" no tiene el formato adecuado.");
            return;
        }

        if (!cb_conserje.isSelected()) {

            Cliente cliente = new Cliente();
            cliente.setNombre(tf_nombre.getText());
            cliente.setApellidos(tf_apellidos.getText());
            cliente.setMail(tf_mail.getText());
            cliente.setDNI(tf_dni.getText());
            cliente.setTelefono(tf_tel.getText());

            ClienteUtils clienteUtils = new ClienteUtils();
            clienteUtils.create(cliente);
            
            ControllerMenuPrincipal.ventanaInformativa("Cliente creado con exito.");
                  
        } else {
            Conserje conserje = new Conserje();
            conserje.setNombre(tf_nombre.getText());
            conserje.setApellidos(tf_apellidos.getText());
            conserje.setMail(tf_mail.getText());
            conserje.setDNI(tf_dni.getText());
            conserje.setTelefono(tf_tel.getText());

            ConserjeUtils conserjeUtils = new ConserjeUtils();
            conserjeUtils.create(conserje);
            
            ControllerMenuPrincipal.ventanaInformativa("Conserje creado con exito.");
        }

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_GestioPersonas.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerCreacionCliente.class.getName()).log(Level.SEVERE, null, ex);
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
