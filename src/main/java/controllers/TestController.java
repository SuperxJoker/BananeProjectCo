package controllers;

import bench.IBenchmark;
import bench.cpu.DigitsOfPiSpigot;
import bench.cpu.PiType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import org.w3c.dom.Text;
import timming.ITimer;
import timming.Timer;

public class TestController {


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

    public void startButtonOnAction(ActionEvent event){

        bench.cpu.DigitsOfPiSpigot d = new DigitsOfPiSpigot();
        k=Integer.parseInt(String.valueOf(digitsField.getText()));

        Timer t = new Timer();
        t.start();
        d.Digits(k);
        timetaken=t.stop();
        newtime= TimeUnit.toTimeUnit(timetaken,TimeUnit.Sec);

       // displayScore.setText(String.valueOf(newtime));


       // System.out.println(newtime);
        displayScore.setText(String.valueOf(newtime));
        System.out.println(k);
    }



}



