package controllers;

import bench.cpu.DigitsOfPiSpigot;
import bench.IBenchmark;
import bench.cpu.MyThread;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.nio.file.Files;
import java.nio.file.Paths;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;


public class Main extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {




            Parent root = FXMLLoader.load(getClass().getResource("no1.fxml"));
            //stage.getIcons().add(new Image(getClass().getResource("/images/icon.png").toURI().toString()));
            //.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Bananas in pyjamas ");
            stage.setScene(new Scene(root, 818, 484));
            stage.show();
        }
    }
