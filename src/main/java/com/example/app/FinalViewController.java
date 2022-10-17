package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FinalViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goBackBtn;

    @FXML
    void initialize() {
        goBackBtn.setOnAction(actionEvent -> {
            openStartWindow("hello-view.fxml");
        });
    }


    public void openStartWindow(String window) {
        goBackBtn.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("Піцерія PizzaKing");
        stage.show();
    }
}
