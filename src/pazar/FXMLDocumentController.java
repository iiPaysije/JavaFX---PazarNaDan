/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pazar;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 *
 * @author pavle
 */
public class FXMLDocumentController implements Initializable {

    private int Pazar;

    private Label label;
    @FXML
    private Pane Pane;
    @FXML
    private Label labelTitle;
    @FXML
    private Label labelPazar;
    @FXML
    private Label labelInstruction;
    @FXML
    private ImageView img10;
    @FXML
    private TextField input10;
    @FXML
    private ImageView img20;
    @FXML
    private TextField input20;
    @FXML
    private ImageView img50;
    @FXML
    private TextField input50;
    @FXML
    private ImageView img100;
    @FXML
    private TextField input100;
    @FXML
    private ImageView img200;
    @FXML
    private TextField input200;
    @FXML
    private ImageView img500;
    @FXML
    private TextField input500;
    @FXML
    private ImageView img1000;
    @FXML
    private TextField input1000;
    @FXML
    private ImageView img2000;
    @FXML
    private TextField input2000;
    @FXML
    private ImageView img5000;
    @FXML
    private TextField input5000;
    @FXML
    private ImageView imgKov1;
    @FXML
    private TextField inputKov1;
    @FXML
    private ImageView imgKov2;
    @FXML
    private TextField inputKov2;
    @FXML
    private ImageView imgKov5;
    @FXML
    private TextField inputKov5;
    @FXML
    private ImageView imgKov10;
    @FXML
    private TextField inputKov10;
    @FXML
    private ImageView imgKov20;
    @FXML
    private TextField inputKov20;
    @FXML
    private TextField inputKasa;
    @FXML
    private Label labelKasa;
    @FXML
    private Button btnRacunaj;
    @FXML
    private Label labelIzracunatPazar;
    @FXML
    private Button btnUporedi;
    @FXML
    private DatePicker datum;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Izracunaj(ActionEvent event) {
        //labelIzracunajPazar -> sabrane vrednosti svih novcanica i kovanica

        Pazar = Integer.valueOf(input10.getText()) * 10 + Integer.valueOf(input20.getText()) * 20 + Integer.valueOf(input50.getText()) * 50
                + Integer.valueOf(input100.getText()) * 100 + Integer.valueOf(input200.getText()) * 200 + Integer.valueOf(input500.getText()) * 500
                + Integer.valueOf(input1000.getText()) * 1000 + Integer.valueOf(input2000.getText()) * 2000 + Integer.valueOf(input5000.getText()) * 5000
                + Integer.valueOf(inputKov1.getText()) * 1 + Integer.valueOf(inputKov2.getText()) * 2 + Integer.valueOf(inputKov5.getText()) * 5
                + Integer.valueOf(inputKov10.getText()) * 10 + Integer.valueOf(inputKov20.getText()) * 20;

        labelIzracunatPazar.setText(String.valueOf(Pazar));

    }

    @FXML
    private void Uporedi(ActionEvent event) throws IOException {

        LocalDate date = datum.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM yyyy");
        String upis = date.format(formatter);

        int izracunatPazar = Integer.valueOf(labelIzracunatPazar.getText());
        int Kasa = Integer.valueOf(inputKasa.getText());

        if (izracunatPazar == Kasa) {
            JOptionPane.showMessageDialog(null, "Dnevni pazar za dan " + date + " JEDNAK je svoti novca u kasi!");
            FileWriter fw = new FileWriter("Pazar.txt", true);
            fw.write(upis + " || Pazar = " + izracunatPazar + "\n");
            fw.close();

        } else if (izracunatPazar > Kasa) {
            int razlika = izracunatPazar - Kasa;
            
            JOptionPane.showMessageDialog(null, "Dnevni pazar za dan " + date + " je VECI od svote novca u kasi za " + razlika + " dinara");
            
            FileWriter fw = new FileWriter("Pazar.txt", true);
            fw.write(upis + " || Pazar = +" + izracunatPazar + "\n");
            fw.close();
            
        } else if (izracunatPazar < Kasa) {
            int razlika = izracunatPazar - Kasa;
            
            JOptionPane.showMessageDialog(null, "Dnevni pazar za dan " + date + " je MANJI od svote novca u kasi za " + razlika + " dinara");
            
            FileWriter fw = new FileWriter("Pazar.txt", true);
            fw.write(upis + " || Pazar = -" + izracunatPazar + "\n");
            fw.close();
        }

        System.exit(0);
    }

}
