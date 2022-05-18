package controllers;

import bench.cpu.MyThread;
import bench.cpu.generateSieveOfEratosthenes;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import logging.TimeUnit;
import timming.Timer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimController  {
    private Stage stage;
    private Scene scene;
    private Parent root;
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
    @FXML
    private ImageView Drummerbanana;
    public void initialize(){
        timeName.setVisible(false);
        scoreName.setVisible(false);

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Drummerbanana);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(240);
        translate.setAutoReverse(true);
        translate.play();
    }


    public int k;
    private long timetaken;
    public double time1;
    public double score1;


    public void startButtonOnAction(ActionEvent event) {

       double time1 = 0;

        generateSieveOfEratosthenes test = new generateSieveOfEratosthenes();
        k = Integer.parseInt(String.valueOf(digitsField.getText()));
        MyThread mt = new MyThread("generateSieveOfEratosthenes",test,k);
       // test.sieveOfEratosthenes(k);
        Timer t = new Timer();
        t.start();
        mt.start();//test.generateSieveOfEratosthenes2(k);
        timetaken = t.stop();
       // int count = test.getContor();

        time1 = TimeUnit.toTimeUnit(timetaken, TimeUnit.Milli);

        test=(generateSieveOfEratosthenes) mt.getBenchClass();

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
        root = FXMLLoader.load(getClass().getResource("startinterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}

