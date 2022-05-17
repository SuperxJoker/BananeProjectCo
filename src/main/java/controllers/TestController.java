package controllers;

import bench.IBenchmark;
import bench.cpu.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import org.w3c.dom.Text;
import timming.ITimer;
import timming.Timer;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestController implements Initializable {


    @FXML
    private Button startButton;
    @FXML
    private TextField digitsField;
    @FXML
    private Label displayScore;
    @FXML
    private Label timeLabel;
    public int k;
    private long timetaken;
    public double newtime;
    public double score;
    public double newtime2;
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
       // thread.stop();
        newtime = TimeUnit.toTimeUnit(timetaken,TimeUnit.Milli);
       // String newtime2 = String.format("%.4f",newtime);
        timeLabel.setText(String.valueOf(newtime));




       // score = 0.0f;
        //score = k/Math.sqrt(newtime);
        String scoreString = String.format("%.0f",k/Math.sqrt(newtime));
       // final DecimalFormat df = new DecimalFormat("0.00");
        //df.format(score);


        /*bench.cpu.sieveOfEratosthenes prim = new sieveOfEratosthenes();
        k = Integer.parseInt(String.valueOf(digitsField.getText()));

        Timer t = new Timer();
        t.start();
        prim.sieveOfEratosthenes(k);
        timetaken = t.stop();
        newtime = TimeUnit.toTimeUnit(timetaken,TimeUnit.Sec);
        score =  k/Math.sqrt(newtime);*/


      /* score = 0.0f;
        k = Integer.parseInt(String.valueOf(digitsField.getText()));
        Timer t = new Timer();
        t.start();
        generateSieveOfEratosthenes.generatePrimes(k);
        timetaken =t.stop();
        newtime = TimeUnit.toTimeUnit(timetaken,TimeUnit.Sec);
        score += k*1000000/newtime;*/


       // displayScore.setText(String.valueOf(newtime));

       // System.out.println(newtime);


        displayScore.setText(String.valueOf(scoreString));



        //System.out.println(k);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}



