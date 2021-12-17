/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import matplace.model.Cliente;
import matplace.utils.ClienteUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerGestioPersonas extends Application implements Initializable {

    @FXML
    TableView tvPersonas;
    @FXML
    TableColumn colID, colDNI, colNombre, colApellidos;

    ArrayList<Cliente> clientes = new ArrayList<>();

    private static Cliente personaSeleccionada;
    String s;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientes = ClienteUtils.getClientes();
        this.mostrarPersonas();

        tvPersonas.setPlaceholder(new Label("No hay personas que mostrar."));

        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colDNI.setCellValueFactory(new PropertyValueFactory<>("DNI"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        s = "/matplace/presentacio/view/capa2/cliente/creacionCliente.fxml";
        cambioScene((Node) event.getSource());

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonBuscar(ActionEvent event) {

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_MenuPrincipal.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Cliente temp = null;
    Date lastClickTime = null;

    /**
     * Detecta un doble clik sobre un fichero de la tableview.
     */
    @FXML
    private void handleRowSelect() throws Exception {

        Cliente row = (Cliente) tvPersonas.getSelectionModel().getSelectedItem();
        if (row == null) {
            return;
        }
        if (row != temp) {
            temp = row;
            lastClickTime = new Date();
        } else if (row == temp) {
            Date now = new Date();
            long diff = now.getTime() - lastClickTime.getTime();
            if (diff < 300) { //another click registered in 300 millis
                System.out.println(row);
                personaSeleccionada = row;
                s = "/matplace/presentacio/view/capa2/cliente/edicion cliente.fxml";
                this.start((Stage) tvPersonas.getScene().getWindow());
                

            } else {
                lastClickTime = new Date();
            }
        }
    }

    private void mostrarPersonas() {

        try {
            ObservableList<Cliente> llistaObservableReservas = FXCollections.<Cliente>observableArrayList(clientes);
            tvPersonas.setItems(llistaObservableReservas);

        } catch (java.lang.NullPointerException e) {
            System.out.println("No hay ficheros que mostrar");

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

    public static Cliente getPersonaSeleccionada() {
        return personaSeleccionada;
    }
}
