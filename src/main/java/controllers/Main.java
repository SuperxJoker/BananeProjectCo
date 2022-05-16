package controllers;

import bench.cpu.DigitsOfPiSpigot;
import bench.IBenchmark;
import bench.cpu.MyThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("startInterface.fxml"));
       // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Application");
        stage.setScene(new Scene(root, 818, 484));
        stage.show();
    }
}
