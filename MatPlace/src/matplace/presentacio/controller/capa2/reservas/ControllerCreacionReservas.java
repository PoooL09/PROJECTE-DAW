/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.reservas;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import matplace.model.Cliente;
import matplace.model.Conserje;
import matplace.model.Material;
import matplace.model.Persona;
import matplace.model.Reserva;
import matplace.model.Sala;
import matplace.presentacio.controller.ControllerMenuPrincipal;
import matplace.utils.ClienteUtils;
import matplace.utils.ConserjeUtils;
import matplace.utils.MaterialUtils;
import matplace.utils.ReservaUtils;
import matplace.utils.SalaUtils;

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
    ComboBox mb_persona, mb_conserje, mb_material, mb_sala;

    @FXML
    TextArea ta_hora, ta;

    @FXML
    DatePicker datePicker;

    String s;
    ArrayList<Persona> personas = new ArrayList<>();
    
    @FXML
    TableView tvFicheros;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Conserje> conserjes = ConserjeUtils.getConserjes();
        //ArrayList<Conserje> conserjes = new ArrayList<>();
        conserjes.add(new Conserje(1, "Aitor", "Burruezo", "74385235", "aitor@gmail.com", "3256"));

        for (int i = 0; i < conserjes.size(); i++) {

            mb_conserje.getItems().add(conserjes.get(i));

        }

        ArrayList<Cliente> clientes = ClienteUtils.getClientes();
        //ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Aitor", "Burruezo", "74385235", "aitor@gmail.com", "3256"));

        for (int i = 0; i < clientes.size(); i++) {

            mb_persona.getItems().add(clientes.get(i));

        }

        ArrayList<Material> material = MaterialUtils.getMaterials();
        //ArrayList<Material> material = new ArrayList<>();
        material.add(new Material("pelota"));

        for (int i = 0; i < material.size(); i++) {

            mb_material.getItems().add(material.get(i));

        }
        
        ArrayList<Sala> salas = SalaUtils.getSalas();
        //ArrayList<Material> material = new ArrayList<>();
        salas.add(new Sala());

        for (int i = 0; i < material.size(); i++) {

            mb_material.getItems().add(material.get(i));

        }
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

        ta.appendText(persona.toString() + "\n");

        personas.add(persona);
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
        reserva.setMaterial((Material) mb_material.getSelectionModel().getSelectedItem());
        reserva.setResponsable((Cliente) mb_persona.getSelectionModel().getSelectedItem());
        reserva.setMiembrosSala(personas);
        reserva.setDataFinal(new Date());
        reserva.setDataInici(new Date());

        reserva.setDataInici(datePicker.getValue());
        reservaUtils.create(reserva);
        ControllerMenuPrincipal.ventanaInformativa("Reserva creada con exito.");

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

    private void mostrarFicheros() {

        try {

            ObservableList<Persona> llistaObservableFicheros = FXCollections.<Persona>observableArrayList(personas);
            tvFicheros.setItems(llistaObservableFicheros);

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
