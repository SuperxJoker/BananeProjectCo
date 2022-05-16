package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    private long timeTaken;
    private double time;

    public void fibboButtonOnAction(ActionEvent event) throws IOException {
        int n=Integer.parseInt(String.valueOf(fibboTextField.getText()));
        Timer t = new Timer();
        t.start();
        Fibbo(n);
        timeTaken=t.stop();
        time = TimeUnit.toTimeUnit(timeTaken,TimeUnit.Milli);
        fibboTimeLabel.setText(String.valueOf(time));
    }

    public void Fibbo(int n)
    {
        BigInteger a=new BigInteger("1");
        BigInteger b=new BigInteger("1");
        BigInteger c=new BigInteger("2");
        if(n==1 || n==2){
            fibboLabel.setText("1");
            return;
        }
        else if(n==3) {
            fibboLabel.setText("2");
            return;
        }

        for(int i=4;i<=n;i++)
        {
            c=c.add(b);
            a=b;
            b=c;
            b=b.subtract(a);
        }
        fibboLabel.setText(String.valueOf(c));
    }
}
