package controllers;

import bench.cpu.generateSieveOfEratosthenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logging.TimeUnit;
import timming.Timer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimController  {
    @FXML
    private Button startButton;
    @FXML
    private TextField digitsField;
    @FXML
    private Label displayScore;
    @FXML
    private Label timeLabel;
    @FXML
    private Label timeName;
    @FXML
    private Label scoreName;
    @FXML
    private TextArea primeArea;
    @FXML
    private Button backButton;

    public void initialize(){
        timeName.setVisible(false);
        scoreName.setVisible(false);
    }


    public int k;
    private long timetaken;
    public double time1;
    public double score1;


    public void startButtonOnAction(ActionEvent event) {

       double time1 = 0;

        generateSieveOfEratosthenes test = new generateSieveOfEratosthenes();
        k = Integer.parseInt(String.valueOf(digitsField.getText()));
       // test.sieveOfEratosthenes(k);
        Timer t = new Timer();
        t.start();
        test.generateSieveOfEratosthenes2(k);
        timetaken = t.stop();
       // int count = test.getContor();

        time1 = TimeUnit.toTimeUnit(timetaken, TimeUnit.Milli);


        String scoreString = String.format("%.0f",Math.sqrt(k)/Math.log(time1*1000)+1);

        //test.setPrim(k);
        //System.out.println(test.getPrim());

        timeName.setVisible(true);
        scoreName.setVisible(true);
        timeLabel.setText(String.valueOf(time1));
        displayScore.setText(String.valueOf(scoreString));
        primeArea.setText(String.valueOf(test.getPrim()));
       // System.out.println(count);
    }
    public void backButtonOnAction(ActionEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("startInterface.fxml"));
        Stage stage = new Stage();
        stage.getIcons().add(new Image(("/images/icon.png")));
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Bananas in pyjamas ");
        stage.setScene(new Scene(root3, 818, 484));
        stage.show();

    }


}

