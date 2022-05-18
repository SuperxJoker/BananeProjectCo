package controllers;

import bench.IBenchmark;
import bench.cpu.*;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import org.w3c.dom.Text;
import timming.ITimer;
import timming.Timer;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestController {
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
    private Button backButton;
    @FXML
    private TextArea piArea;
    @FXML
    private ImageView Shybanana;

    public int k;
    private long timetaken;
    public double newtime;
    public double score;
    public double newtime2;

    public void initialize(){
        timeName.setVisible(false);
        scoreName.setVisible(false);

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(Shybanana);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(-200);
        translate.setAutoReverse(true);
        translate.play();

    }

    public TestController() {
    }

    public void startButtonOnAction(ActionEvent event){

        double newtime = 0;

        DigitsOfPiSpigot d = new DigitsOfPiSpigot();
        k=Integer.parseInt(String.valueOf(digitsField.getText()));

        // DigitsOfPiSpigot thread = new DigitsOfPiSpigot();
        //thread.start();
        MyThread mt = new MyThread();
        mt.start();
        Timer t = new Timer();
        t.start();
        d.Digits(k);
        timetaken=t.stop();
        newtime = TimeUnit.toTimeUnit(timetaken,TimeUnit.Milli);

        timeName.setVisible(true);

        timeLabel.setText(String.valueOf(newtime));


        String scoreString = String.format("%.0f",k/Math.sqrt(newtime));
        scoreName.setVisible(true);
        displayScore.setText(String.valueOf(scoreString));
        piArea.setText(d.toDisplay);




    }
    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("startinterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}



