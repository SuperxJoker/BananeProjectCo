package controllers;

import bench.cpu.MyThread;
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
import java.math.BigInteger;

public class FibboController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String fNumber;

    @FXML
    private TextField fibboTextField;
    @FXML
    private Label fibboTimeLabel;
    @FXML
    private TextArea fibboArea;
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

    public void fibboButtonOnAction(ActionEvent event)
    {
        long timeTaken;
        double time;

        FibboController warmup = new FibboController();
        warmup.Fibbo(100000);

        int n=Integer.parseInt(String.valueOf(fibboTextField.getText()));
        FibboController fibbo= new FibboController();
        MyThread mt = new MyThread("FibboController",fibbo,n);

        Timer t = new Timer();
        t.start();
        mt.start();//Fibbo(n); <=> fibbo.Fibbo(n);
        timeTaken=t.stop();
        time = TimeUnit.toTimeUnit(timeTaken,TimeUnit.Milli);

        String scoreString = String.format("%.0f",Math.sqrt(n*100)/Math.log(time));

        fibboArea.setText(fibbo.fNumber);
        timeName.setVisible(true);
        fibboTimeLabel.setText(String.valueOf(time));
        scoreName.setVisible(true);
        scoreDisplay.setText(String.valueOf(scoreString));

    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("startInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void Fibbo(int n)
    {
        BigInteger a;
        BigInteger b=new BigInteger("1");
        BigInteger c=new BigInteger("2");
        if(n==1 || n==2){
            this.fNumber="1";//fibboArea.setText("1");
            return;
        }
        else if(n==3) {
            this.fNumber="1";//fibboArea.setText("2");
        }else {

            for (int i = 4; i <= n; i++) {
                c = c.add(b);
                a = b;
                b = c;
                b = b.subtract(a);
            }
            this.fNumber=String.valueOf(c);//fibboArea.setText(String.valueOf(c));
        }
    }
}
