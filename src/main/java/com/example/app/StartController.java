package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.app.db.DBHandler;
import com.example.app.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text incorrectLogPwdText;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signInBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    void initialize() {
        incorrectLogPwdText.setVisible(false);

        signUpBtn.setOnAction(actionEvent -> {
            openAnotherWindow(signUpBtn, "sign-up-view.fxml");
        });

        signInBtn.setOnAction(actionEvent -> {
            String loginText = login.getText().trim();
            String passwordText = password.getText().trim();
            if(!loginText.equals("") && !passwordText.equals("")) {
                try {
                    loginUser(loginText, passwordText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                incorrectLogPwdText.setVisible(true);
            }
        });
    }

    public void loginUser(String loginText, String passwordText) throws SQLException, ClassNotFoundException {
        DBHandler dbHandler = new DBHandler();
        User user = new User();
        user.setUserLogin(loginText);
        user.setUserPassword(passwordText);
        ResultSet resultSet = dbHandler.getUser(user);

        if(resultSet.next()) {
            openAnotherWindow(signInBtn, "menu.fxml");
        } else {
            incorrectLogPwdText.setVisible(true);
        }
    }

    public void openAnotherWindow(Button button, String window) {
        button.getScene().getWindow().hide();

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



