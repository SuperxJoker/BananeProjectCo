package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.math.BigInteger;

public class FibboController {
    @FXML
    private Button getfibbonumber;
    @FXML
    private Label fibboLabel;
    @FXML
    private TextField fibboTextField;
    @FXML
    private Label fibboTimeLabel;
    @FXML
    private TextArea fibboArea;
    @FXML
    private Button backButton;
    @FXML
    private Label scoreName;
    @FXML
    private Label scoreDisplay;
    @FXML
    private Label timeName;

    public void initialize(){
        timeName.setVisible(false);
        scoreName.setVisible(false);
    }

    private long timeTaken;
    private double time;

    public void fibboButtonOnAction(ActionEvent event) throws IOException {
        time = 0;
        int n=Integer.parseInt(String.valueOf(fibboTextField.getText()));
        Timer t = new Timer();
        t.start();
        Fibbo(n);
        timeTaken=t.stop();
        time = TimeUnit.toTimeUnit(timeTaken,TimeUnit.Milli);

        String scoreString = String.format("%.0f",n/Math.sqrt(time));


        timeName.setVisible(true);
        fibboTimeLabel.setText(String.valueOf(time));
        scoreName.setVisible(true);
        scoreDisplay.setText(String.valueOf(scoreString));

    }
    public void backButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startInterface.fxml"));
        Stage stage = new Stage();
        stage.getIcons().add(new Image(("/images/icon.png")));
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Bananas in pyjamas ");
        stage.setScene(new Scene(root, 818, 484));
        stage.show();

    }

    public void Fibbo(int n)
    {
        BigInteger a=new BigInteger("1");
        BigInteger b=new BigInteger("1");
        BigInteger c=new BigInteger("2");
        if(n==1 || n==2){
            fibboArea.setText("1");
            return;
        }
        else if(n==3) {
            fibboArea.setText("2");
            return;
        }

        for(int i=4;i<=n;i++)
        {
            c=c.add(b);
            a=b;
            b=c;
            b=b.subtract(a);
        }
        fibboArea.setText(String.valueOf(c));
    }
}
