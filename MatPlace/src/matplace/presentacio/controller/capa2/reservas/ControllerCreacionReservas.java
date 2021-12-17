/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.reservas;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Persona;
import matplace.model.Reserva;
import matplace.model.Sala;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.*;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerCreacionReservas extends Application implements Initializable {

    ConserjeUtils conserjeUtils = new ConserjeUtils();
    MaterialUtils materialUtils = new MaterialUtils();
    ClienteUtils clienteUtils = new ClienteUtils();
    SalaUtils salaUtils = new SalaUtils();

    @FXML
    ComboBox mb_persona, mb_conserje, mb_material, mb_salas;

    @FXML
    TextField tf_hora;

    @FXML
    DatePicker datePicker;

    String s;
    
    ArrayList<Persona> personas = new ArrayList<>();

    @FXML
    TableView tvPersonas;

    @FXML
    TableColumn colNombre, colApellido, colMail, colTelefono;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.setCombobox();
        this.mostrarPersonas();
        
        tvPersonas.setPlaceholder(new Label("Ningun acompañante añadido."));

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAdd(ActionEvent event) {

        Persona persona = new Persona();
        persona.setNombre(JOptionPane.showInputDialog("Introduce el nombre;"));
        persona.setApellidos(JOptionPane.showInputDialog("Introduce el apellido;"));
        persona.setMail(JOptionPane.showInputDialog("Introduce el mail;"));
        persona.setTelefono(JOptionPane.showInputDialog("Introduce el telefono;"));

        personas.add(persona);

        ControllerMenuPrincipal.ventanaInformativa("Acompañante añadido con exito.");
        mostrarPersonas();
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
    private void handleButtonDel(ActionEvent event) {

        Persona persona = (Persona) tvPersonas.getSelectionModel().getSelectedItem();

        if (persona == null) {
            ControllerMenuPrincipal.ventanaInformativa("No has seleccionado ningun archivo.");
            return;
        }

        //Devuelve un 0 si el usuario escoge la opcion SI
        Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
        dialogoAlerta.setTitle("Ventana de confirmación");
        dialogoAlerta.setHeaderText(null);
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        dialogoAlerta.setContentText("Está seguro que desea borrar a " + persona.getNombre() + "?");
        Optional<ButtonType> result = dialogoAlerta.showAndWait();

        if (result.get() != ButtonType.OK) {
            return;
        }

        personas.remove(persona);
        mostrarPersonas();
        ControllerMenuPrincipal.ventanaInformativa("Acompañante eliminado con exito.");

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        Reserva reserva = new Reserva();

        reserva.setConserje((Conserje) mb_conserje.getSelectionModel().getSelectedItem());
        
        if((Conserje) mb_conserje.getSelectionModel().getSelectedItem() == null){
            reserva.setConserje(new Conserje());
            System.out.println("hola");
        }
        
        reserva.setMaterial((Material) mb_material.getSelectionModel().getSelectedItem());
        reserva.setResponsable((Cliente) mb_persona.getSelectionModel().getSelectedItem());
        reserva.setMiembrosSala(personas);
        String hour = tf_hora.getText();
        String date = datePicker.getValue().toString();
        System.out.println(date);
        DateControl dateControl = new DateControl();
        reserva.setDataFinal(dateControl.datePlusTime(date, hour));
        reserva.setDataInici(dateControl.datePlusTime(date, hour));

        //reserva.setDataInici(datePicker.getValue());
        Sala salaSeleccionada = (Sala) mb_salas.getSelectionModel().getSelectedItem();

        salaUtils.addReserva(reserva, salaSeleccionada);

        if (salaUtils.update(salaSeleccionada)) {
            ControllerMenuPrincipal.ventanaInformativa("Reserva creada con exito.");
        } else {
            ControllerMenuPrincipal.ventanaInformativa("No se ha podido crear la reserva.");
        }

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAtras(ActionEvent event) {

        s = "/matplace/presentacio/view/FXML_GestioReservas.fxml";
        cambioScene((Node) event.getSource());

    }

    private void cambioScene(Node st) {
        try {
            this.start((Stage) st.getScene().getWindow());
        } catch (Exception ex) {
            Logger.getLogger(ControllerCreacionReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarPersonas() {

        try {

            ObservableList<Persona> llistaObservablePersonas = FXCollections.<Persona>observableArrayList(personas);
            tvPersonas.setItems(llistaObservablePersonas);

        } catch (java.lang.NullPointerException e) {
            System.out.println("No hay ficheros que mostrar");

        }

    }

    private void setCombobox() {

        ArrayList<Conserje> conserjes = ConserjeUtils.getConserjes();

        for (int i = 0; i < conserjes.size(); i++) {

            mb_conserje.getItems().add(conserjes.get(i));

        }

        ArrayList<Cliente> clientes = ClienteUtils.getClientes();

        for (int i = 0; i < clientes.size(); i++) {

            mb_persona.getItems().add(clientes.get(i));

        }

        ArrayList<Material> material = MaterialUtils.getMaterials();

        for (int i = 0; i < material.size(); i++) {

            mb_material.getItems().add(material.get(i));

        }

        ArrayList<Sala> salas = SalaUtils.getSalas();

        for (int i = 0; i < salas.size(); i++) {

            mb_salas.getItems().add(salas.get(i));

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
