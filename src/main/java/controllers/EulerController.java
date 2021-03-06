package controllers;

import Exceptions.EnterAValidNumber;
import Services.IncorrectInput;
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
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import timming.Timer;

import java.io.IOException;
import java.util.Objects;

import static Services.LocalBase.addToJson;

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
    @FXML
    private Label eulerException = new Label();

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

    public void eulerButtonOnAction(ActionEvent event) throws EnterAValidNumber {
        eulerDigits warmup = new eulerDigits();
        warmup.EulerCalc(6000);

        long timeTaken;
        double time;
        eulerException.setText("");
        try{
            IncorrectInput incorrectInput = new IncorrectInput();
            incorrectInput.getCorrectNumber(eulerTextField.getText().matches("[0-9]+"));
            incorrectInput.checkIncorrect();

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

            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hardware = systemInfo.getHardware();
            CentralProcessor processor = hardware.getProcessor();
            CentralProcessor.ProcessorIdentifier processorIdentifier = processor.getProcessorIdentifier();
            // System.out.println("Processor Name: " + processorIdentifier.getName());


            addToJson(processorIdentifier.getName(), "Digits of PI",String.valueOf(time),scoreString);

        }catch (EnterAValidNumber e)
        {
            eulerTimeLabel.setVisible(false);
            eulerScoreLabel.setVisible(false);
            timeText.setVisible(false);
            scoreText.setVisible(false);
            eulerException.setText(e.getMessage());
        }catch (Exception ignored){}
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("startInterface.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
