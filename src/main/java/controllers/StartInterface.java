package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartInterface implements Initializable {

    @FXML
    private Button bananaPi;
    @FXML
    private Button bananaPrim;
    @FXML
    private Button fibbobanana;

    public void bananaPiButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("testController.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image(("/images/icon.png")));
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Bananas in pyjamas");
        stage.setScene(new Scene(root, 818, 484));
        stage.show();
    }
    public void bananaPrimButtonOnAction(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("primController.fxml"));
        Stage newstage = new Stage();
        newstage.getIcons().add(new Image(("/images/icon.png")));
        // stage.initStyle(StageStyle.UNDECORATED);
        newstage.setTitle("Bananas in pyjamas");
        newstage.setScene(new Scene(root1, 818, 484));
        newstage.show();
    }
    public void fibbobananaButtonOnAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("fibboController.fxml"));
        Stage fibbostage = new Stage();
        fibbostage.getIcons().add(new Image(("/images/icon.png")));
        fibbostage.setTitle("Bananas in pyjamas");
        fibbostage.setScene(new Scene(root2,818,484));
        fibbostage.show();
    }

    public void bananaEulerButtonOnAction(ActionEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("eulerController.fxml"));
        Stage eulerstage = new Stage();
        eulerstage.getIcons().add(new Image(("/images/icon.png")));
        eulerstage.setTitle("Bananas in pyjamas");
        eulerstage.setScene(new Scene(root3,818,484));
        eulerstage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
