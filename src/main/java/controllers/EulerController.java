package controllers;

import bench.cpu.MyThread;
import bench.cpu.eulerDigits;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

public class EulerController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField eulerTextField;
    @FXML
    private TextArea eulerTextArea;
    @FXML
    private Label eulerTimeLabel;
    @FXML
    private Label eulerScoreLabel;
    @FXML
    private ImageView thedancingbanana;
    @FXML
    private Label timeText;
    @FXML
    private Label scoreText;

    public void initialize(){
        eulerTimeLabel.setVisible(false);
        eulerScoreLabel.setVisible(false);
        timeText.setVisible(false);
        scoreText.setVisible(false);

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(thedancingbanana);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(-350);
        translate.setAutoReverse(true);
        translate.play();
    }

    public void eulerButtonOnAction(ActionEvent event)
    {
        eulerDigits warmup = new eulerDigits();
        warmup.EulerCalc(6000);

        long timeTaken;
        double time;

        int n=Integer.parseInt(String.valueOf(eulerTextField.getText()));
        eulerDigits euler = new eulerDigits();
        MyThread mt = new MyThread("eulerDigits",euler,n);

        Timer t = new Timer();
        t.start();
        mt.start();//euler.EulerCalc(n);
        timeTaken=t.stop();
        time = TimeUnit.toTimeUnit(timeTaken,TimeUnit.Milli);

        euler = (eulerDigits) mt.getBenchClass();

        String scoreString = String.format("%.0f",n/Math.sqrt(time));

        eulerTimeLabel.setVisible(true);
        eulerScoreLabel.setVisible(true);
        timeText.setVisible(true);
        scoreText.setVisible(true);
        eulerTimeLabel.setText(String.valueOf(time));
        eulerTextArea.setText(euler.toDisplay);
        eulerScoreLabel.setText(scoreString);


    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("startInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
