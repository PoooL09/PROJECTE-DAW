/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace.presentacio.controller.capa2.reservas;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import matplace.model.Conserje;
import matplace.model.Reserva;
import matplace.utils.ConserjeUtils;
import matplace.utils.MaterialUtils;
import matplace.utils.ReservaUtils;

/**
 * @author pg_po
 * @version: 02/06/2021/A
 */
public class ControllerCreacionReservas extends Application implements Initializable {

    ReservaUtils reservaUtils;
    ConserjeUtils conserjeUtils;
    MaterialUtils materialUtils;

    @FXML
    ComboBox mb_persona, mb_conserje, mb_material;

    @FXML
    TextArea ta_hora, ta;

    @FXML
    DatePicker datePicker;

    String s;

    /**
     * Inicia el controlador
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //ArrayList<Conserje> conserjes = conserjeUtils.getConserjes();
        ArrayList<Conserje> conserjes = new ArrayList<>();
        conserjes.add(new Conserje(1,"Aitor","Burruezo","74385235","aitor@gmail.com","3256"));

        for (int i = 0; i < conserjes.size(); i++) {

            mb_conserje.getItems().add(conserjes.get(i));
            
        }
        
    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonAdd(ActionEvent event) {

    }

    /**
     *
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {

        Reserva reserva = new Reserva();
        reservaUtils.create(reserva);

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
