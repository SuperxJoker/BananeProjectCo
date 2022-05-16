package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartInterface implements Initializable {

    @FXML
    private Button bananaPi;
    @FXML
    private Button bananaPrim;

    public void bananaPiButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("testController.fxml"));
        Stage stage = new Stage();
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Application");
        stage.setScene(new Scene(root, 818, 484));
        stage.show();
    }
    public void bananaPrimButtonOnAction(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("primController.fxml"));
        Stage newstage = new Stage();
        // stage.initStyle(StageStyle.UNDECORATED);
        newstage.setTitle("Application");
        newstage.setScene(new Scene(root1, 818, 484));
        newstage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
