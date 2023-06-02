package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;


    @FXML
    private Pane ToilePane;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private TextField txt5;
    @FXML
    private TextField txt6;
    @FXML
    private Button vider;
    @FXML
    private Button tracer;
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;
    @FXML
    private Circle c5;
    @FXML
    private Circle c6;


    @FXML
    private void clearTextField() {
        txt1.clear();
        txt2.clear();
        txt3.clear();
        txt4.clear();
        txt5.clear();
        txt6.clear();
    }

    @FXML
    private void tracer(){
        if (txt1.getText().equals("") || txt2.getText().equals("") ||txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("") || txt6.getText().equals("")) {
            pbMessage("Manque d'information", "Remplissez les champs.");
            return;
        }
    }

    @FXML
    private void addPoint1(){
        if(Double.parseDouble( txt1.getText())<1 ||Double.parseDouble( txt1.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c1.setLayoutX(getXRadarChart(Double.parseDouble(txt1.getText()),1));
        c1.setLayoutY(getYRadarChart(Double.parseDouble(txt1.getText()),1));
    }
    @FXML
    private void addPoint2(){
        if(Double.parseDouble( txt2.getText())<1 ||Double.parseDouble( txt2.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c2.setLayoutX(getXRadarChart(Double.parseDouble(txt2.getText()),2));
        c2.setLayoutY(getYRadarChart(Double.parseDouble(txt2.getText()),2));
    }
    @FXML
    private void addPoint3(){
        if(Double.parseDouble( txt3.getText())<1 ||Double.parseDouble( txt3.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c3.setLayoutX(getXRadarChart(Double.parseDouble(txt3.getText()),3));
        c3.setLayoutY(getYRadarChart(Double.parseDouble(txt3.getText()),3));
    }
    @FXML
    private void addPoint4(){
        if(Double.parseDouble( txt4.getText())<1 ||Double.parseDouble( txt4.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c4.setLayoutX(getXRadarChart(Double.parseDouble(txt4.getText()),4));
        c4.setLayoutY(getYRadarChart(Double.parseDouble(txt4.getText()),4));
    }
    @FXML
    private void addPoint5(){
        if(Double.parseDouble( txt5.getText())<1 ||Double.parseDouble( txt5.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c5.setLayoutX(getXRadarChart(Double.parseDouble(txt5.getText()),5));
        c5.setLayoutY(getYRadarChart(Double.parseDouble(txt5.getText()),5));
    }
    @FXML
    private void addPoint6(){
        if(Double.parseDouble( txt6.getText())<1 ||Double.parseDouble( txt6.getText())>20 ){
            pbMessage("Erreur d'information","Valeur non acceptable");
            return;
        }
        c6.setLayoutX(getXRadarChart(Double.parseDouble(txt6.getText()),6));
        c6.setLayoutY(getYRadarChart(Double.parseDouble(txt6.getText()),6));
    }

    private void pbMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe) {
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe - 1) * angleEnDegre)) * rayonCercleExterieur
                * (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe) {
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe - 1) * angleEnDegre)) * rayonCercleExterieur
                * (value / noteMaximale));
    }
}

