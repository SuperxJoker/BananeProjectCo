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

public class UI3 implements Initializable {
    @FXML
    private Button next3;

    public void next3ButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("startInterface.fxml"));

        Stage stage = new Stage();
        stage.getIcons().add(new Image(("/images/icon.png")));
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Bananas in pyjamas");
        stage.setScene(new Scene(root, 818, 484));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
