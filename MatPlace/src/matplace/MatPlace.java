/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matplace;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import matplace.dao.ArrayService;
import matplace.dao.ServiceID;
import matplace.model.Sala;
import matplace.presentacio.controller.ControllerMenuPrincipal;

/**
 *
 * @author pg_po
 */
public class MatPlace extends Application {

    /**
     * @param args the command line arguments
     *
     * Projecte 1 - Espais centre cívic
     *
     * Gestió de: -Tres pistes de bàsquet/futbol -Dues sales multius -Una sala
     * d'actes
     *
     * Per fer-ho es necessita una aplicació que permeti fer aquesta gestió
     * fàcilment.
     *
     * Requisits:
     *
     * Cada sala s'ha de reservar per franges horaries(30 min) -La sala d'actes
     * necesita a mes la disponibilitat d'un bidell. Per fer la reserva s'ha
     * d'estar donat d'alta al sistema -Cal poder registar tots el usuaris de la
     * sala (tema covid). No es el mateix que donarlos d'alta. (El responsable
     * de la sala te que estar donat d'alts al sistema, pero la resta de membres
     * de la sala no es necesari que ho estiguin.) El usuari pot reserver la
     * sala per un o més períodes de temps consecutius, Posiibilitat de reserves
     * periòdiques. A part de la sala, es pot reservar opcionalment material. ->
     * pilotes, raquetes, equip de so, etc S'ha de controlar el material en
     * cadascuna de les franges Responsable del la reserva tambe es responsable
     * del material. Llistats d'ocupació de cada sala per franges horaries(diari
     * setmanal, rang)
     *
     * Framework: Laravel
     *
     * No funcionals:
     *
     * Cal desacoblar la UI de la resta de l'aplicació. -Es començarà la
     * implementació sense UI o s'afegiran clases de proves -En una segona
     * iteració s'implementarà una interficie gràfica. Cal desacoblar l'acces a
     * les dades de les propies dades. El projecta s'ha d'implementar en java i
     * ha d'estar orientat a objectes. No es poden utilizar BD's i per tant
     * l'emmagatzematge de dades s'haurà de fer en fitxers plans (serialització
     * o en txt) Cal implementar bateries de proves per tot el backend.
     * Implementar javadoc. Diagrama de clases.
     *
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        Implementar lista negra
        Si se intenta hacer una reserva de un DNI que no existe dar la opción de crear usuario.
        Buscar las reservas que hay en una sala en concreto.
        
        FALTA LA SALA EN LA PAGINA DE RESERVA
        
        Mostrar a nom de qui esta cada reserva.
        
        Usabilidad de la aplicación. Facil acceso a toda la aplicación. 
        
        Implementar JTable para los acompañantes en gestión reserva.
        
        Implementar JTable para mostrar reservas, usuarios, salas, etc
        
        Separar por pestañas 
        
        Implementar resrervas perodicas?
        
        Mostrar mensajes de error cuando algo no funcione. 
        
        Implementar un drag an roll sobre una JTable para importar un fichero de texto entero.
        
        Crear pattern(validador) para DNI, telefono etc.
        */

        new ServiceID().startID();
        new ArrayService().startAll();

        Parent root = null;

        root = FXMLLoader.load(getClass().getResource("/matPlace/presentacio/view/FXML_MenuPrincipal.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("MatPlace");
        stage.setScene(scene);
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);
        stage.show();
    }

}
