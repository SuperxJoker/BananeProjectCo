package controllers;

import bench.cpu.eulerDigits;
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
import javafx.stage.Stage;
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

    public void initialize(){
        eulerTimeLabel.setVisible(false);
        eulerScoreLabel.setVisible(false);
    }

    public void eulerButtonOnAction(ActionEvent event)
    {
        long timeTaken;
        double time;

        int n=Integer.parseInt(String.valueOf(eulerTextField.getText()));
        eulerDigits euler = new eulerDigits();

        Timer t = new Timer();
        t.start();
        euler.EulerCalc(n);
        timeTaken=t.stop();
        time = TimeUnit.toTimeUnit(timeTaken,TimeUnit.Milli);

        String scoreString = String.format("%.0f",n/Math.sqrt(time));

        eulerTimeLabel.setVisible(true);
        eulerScoreLabel.setVisible(true);
        eulerTimeLabel.setText(String.valueOf(time));
        eulerTextArea.setText(euler.toDisplay);
        eulerScoreLabel.setText(scoreString);


    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("startinterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
