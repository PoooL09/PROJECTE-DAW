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
import matplace.model.Material;
import matplace.model.Sala;
import matplace.utils.MaterialUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerGestioMateriales extends Application implements Initializable {

    @FXML
    TableView tvMaterial;
    @FXML
    TableColumn colEAN, colNombre, colDescripcion, colCantidad;

    ArrayList<Material> material = new ArrayList<>();
    String s;
    private static Material materialSeleccionado;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        material = MaterialUtils.getMaterials();
        this.mostrarMateriales();

        tvMaterial.setPlaceholder(new Label("No hay ninguna reserva."));

        colEAN.setCellValueFactory(new PropertyValueFactory<>("EAN"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

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
            Logger.getLogger(ControllerGestioMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        s = "/matplace/presentacio/view/capa2/material/crear material.fxml";
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

    private void mostrarMateriales() {

        try {
            ObservableList<Material> llistaObservableReservas = FXCollections.<Material>observableArrayList(material);
            tvMaterial.setItems(llistaObservableReservas);

        } catch (java.lang.NullPointerException e) {
            System.out.println("No hay ficheros que mostrar");

        }

    }

    Material temp = null;
    Date lastClickTime = null;

    /**
     * Detecta un doble clik sobre un fichero de la tableview.
     */
    @FXML
    private void handleRowSelect() throws Exception {

        Material row = (Material) tvMaterial.getSelectionModel().getSelectedItem();
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
                materialSeleccionado = row;
                s = "/matplace/presentacio/view/capa2/cliente/edicion cliente.fxml";
                this.start((Stage) tvMaterial.getScene().getWindow());
            } else {
                lastClickTime = new Date();
            }
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
