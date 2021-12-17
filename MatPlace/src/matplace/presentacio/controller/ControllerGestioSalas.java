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
import matplace.model.Sala;
import matplace.utils.SalaUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerGestioSalas extends Application implements Initializable {

    @FXML
    TableView tvSalas;
    @FXML
    TableColumn colID, colNombre, colDescripcion, colCapacidad;

    @FXML
    ImageView logo;

    ArrayList<Sala> salas = new ArrayList<>();
    String s;
    private static Sala salaSeleccionada;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        salas = SalaUtils.getSalas();
        this.mostrarSalas();

        tvSalas.setPlaceholder(new Label("No hay ninguna reserva."));

        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        s = "/matplace/presentacio/view/capa2/sala/crear sala.fxml";
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

    Sala temp = null;
    Date lastClickTime = null;

    /**
     * Detecta un doble clik sobre un fichero de la tableview.
     */
    @FXML
    private void handleRowSelect() throws Exception {

        Sala row = (Sala) tvSalas.getSelectionModel().getSelectedItem();
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
                salaSeleccionada = row;
                s = "/matplace/presentacio/view/capa2/sala/editar sala.fxml";
                this.start((Stage) tvSalas.getScene().getWindow());
            } else {
                lastClickTime = new Date();
            }
        }
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

    private void mostrarSalas() {

        try {
            ObservableList<Sala> llistaObservableReservas = FXCollections.<Sala>observableArrayList(salas);
            tvSalas.setItems(llistaObservableReservas);

        } catch (java.lang.NullPointerException e) {
            System.out.println("No hay ficheros que mostrar");

        }

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
        stage.getIcons().add(new Image("file:icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    public static Sala getSalaSeleccionada() {
        return salaSeleccionada;
    }

}
