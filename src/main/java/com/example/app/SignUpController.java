package com.example.app;

import java.io.IOException;
import java.net.URL;
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

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text emptyFieldsText;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button signUpBtn;

    @FXML
    private TextField signUpCity;

    @FXML
    private TextField signUpLogin;

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private TextField signUpPhone;

    @FXML
    private TextField signUpSurname;

    @FXML
    private Text successfulRegText;

    @FXML
    void initialize() {
        successfulRegText.setVisible(false);
        emptyFieldsText.setVisible(false);

        signUpBtn.setOnAction(actionEvent -> {
            signUpNewUser();
        });

        goBackBtn.setOnAction(actionEvent -> {
            openAnotherWindow(goBackBtn, "hello-view.fxml");
        });
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

    public void signUpNewUser() {
        DBHandler dbHandler = new DBHandler();

        String userName = signUpName.getText();
        String userSurname = signUpSurname.getText();
        String userPhone = signUpPhone.getText();
        String userCity = signUpCity.getText();
        String userLogin = signUpLogin.getText();
        String userPassword = signUpPassword.getText();

        if(!userName.equals("") && !userSurname.equals("") && !userPhone.equals("")
                && !userCity.equals("") && !userLogin.equals("") && !userPassword.equals("")) {
            User user = new User(userName, userSurname, userPhone, userCity, userLogin, userPassword);
            try {
                dbHandler.signUpUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            signUpBtn.setVisible(false);
            successfulRegText.setVisible(true);
            emptyFieldsText.setVisible(false);
        } else  {
            emptyFieldsText.setVisible(true);
        }
    }

}

