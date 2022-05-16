package controllers;

import bench.cpu.DigitsOfPiSpigot;
import bench.cpu.generateSieveOfEratosthenes;
import bench.cpu.sieveOfEratosthenes;
import bench.cpu.MyThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logging.TimeUnit;
import timming.Timer;

import java.net.URL;
import java.util.ResourceBundle;

public class PrimController implements Initializable {
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
    public double time1;
    public double score1;

    public void startButtonOnAction(ActionEvent event) {

       double time1 = 0;

       /*  generateSieveOfEratosthenes d = new generateSieveOfEratosthenes();
        k = Integer.parseInt(String.valueOf(digitsField.getText()));

        // DigitsOfPiSpigot thread = new DigitsOfPiSpigot();
        //thread.start();
        MyThread mt = new MyThread();
        mt.start();
        Timer t = new Timer();
        t.start();
        d.generateNumbers(k);
        timetaken = t.stop();
        // thread.stop();
        time1 = TimeUnit.toTimeUnit(timetaken, TimeUnit.Milli);
        // String newtime2 = String.format("%.4f",newtime);
        timeLabel.setText(String.valueOf(time1));
        String scoreString = String.format("%.0f",k/Math.sqrt(time1));
*/
        sieveOfEratosthenes test = new sieveOfEratosthenes();
        k = Integer.parseInt(String.valueOf(digitsField.getText()));
       // test.sieveOfEratosthenes(k);
        Timer t = new Timer();
        t.start();
        test.sieveOfEratosthenes(k);
        timetaken = t.stop();
        int count = test.getContor();

        time1 = TimeUnit.toTimeUnit(timetaken, TimeUnit.Milli);
        timeLabel.setText(String.valueOf(time1));
        String scoreString = String.format("%.0f",Math.sqrt(count)/Math.log(time1));
        displayScore.setText(String.valueOf(scoreString));


        System.out.println(count);
    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

