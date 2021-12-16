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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import matplace.model.Reserva;
import matplace.model.Sala;
import matplace.utils.SalaUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerGestioReservas extends Application implements Initializable {

    @FXML
    ComboBox cb_sala;

    @FXML
    TextField buscador;

    @FXML
    TableView tvReservas;
    @FXML
    TableColumn colID, colCliente, colFecha, colHora, colMaterial;

    ArrayList<Reserva> reservas = new ArrayList<>();

    String s;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.setCombobox();
        this.mostrarReservas();

        tvReservas.setPlaceholder(new Label("No hay ninguna reserva."));

        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("dataInici"));
        //colHora.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));

    }

    Reserva temp = null;
    Date lastClickTime = null;

    /**
     * Detecta un doble clik sobre un fichero de la tableview.
     */
    @FXML
    private void handleRowSelect() {

        Reserva row = (Reserva) tvReservas.getSelectionModel().getSelectedItem();
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
                //aqui metodo mostrar reserva
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
    private void handleButtonSalas(ActionEvent event) {
        Node st = (Node) event.getSource();

        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerGestioReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        s = "/matplace/presentacio/view/capa2/reservas/crear reservas.fxml";
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

    private void setCombobox() {

        ArrayList<Sala> salas = SalaUtils.getSalas();

        for (int i = 0; i < salas.size(); i++) {

            cb_sala.getItems().add(salas.get(i));

        }

        cb_sala.setOnAction((evento) -> {
            Sala sala = (Sala) cb_sala.getSelectionModel().getSelectedItem();
            reservas = sala.getReservas();
            mostrarReservas();
        });

    }

    private void mostrarReservas() {

        try {
            ObservableList<Reserva> llistaObservableReservas = FXCollections.<Reserva>observableArrayList(reservas);
            tvReservas.setItems(llistaObservableReservas);

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

}
