package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrderListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adressField;

    @FXML
    private TextField adressFieldEmpty;

    @FXML
    private Button approvePromocodeBtn;

    @FXML
    private Button approveRemoveBtn;

    @FXML
    private Button completeOrderBtn;

    @FXML
    private Button deletePizzaInOrderListBtn;

    @FXML
    private Text discountTxt;

    @FXML
    private Button goBackBtn;

    @FXML
    private Text incorrectPromocodeTxt;

    @FXML
    private TextField numberWantToDelete;

    @FXML
    private Text orderListTxt;

    @FXML
    private Button promocodeBtn;

    @FXML
    private TextField promocodeField;

    @FXML
    private Text sumOfOrderTxt;

    @FXML
    private Button undoPromocodeBtn;

    @FXML
    private Button undoRemoveBtn;
    @FXML
    void initialize() {
        orderListTxt.setText(HelloApplication.viewAllPizzas());
        sumOfOrderTxt.setText("Сума:\t" + HelloApplication.sumOfAllOrder() + " ₴");
        numberWantToDelete.setVisible(false);
        approveRemoveBtn.setVisible(false);
        undoRemoveBtn.setVisible(false);
        promocodeField.setVisible(false);
        approvePromocodeBtn.setVisible(false);
        undoPromocodeBtn.setVisible(false);
        discountTxt.setVisible(false);
        incorrectPromocodeTxt.setVisible(false);
        adressFieldEmpty.setVisible(false);

        goBackBtn.setOnAction(actionEvent -> {
            openMenuWindow("menu.fxml");
        });

        deletePizzaInOrderListBtn.setOnAction(actionEvent -> {
            numberWantToDelete.setVisible(true);
            approveRemoveBtn.setVisible(true);
            undoRemoveBtn.setVisible(true);
            promocodeBtn.setVisible(false);
            incorrectPromocodeTxt.setVisible(false);
            promocodeField.setVisible(false);
            approvePromocodeBtn.setVisible(false);
            undoPromocodeBtn.setVisible(false);
            adressField.setVisible(false);
            adressFieldEmpty.setVisible(false);
        });

        undoRemoveBtn.setOnAction(actionEvent -> {
            numberWantToDelete.setVisible(false);
            approveRemoveBtn.setVisible(false);
            undoRemoveBtn.setVisible(false);
            numberWantToDelete.clear();
            promocodeBtn.setVisible(true);
            adressField.setVisible(true);
            adressFieldEmpty.setVisible(false);
        });

        approveRemoveBtn.setOnAction(actionEvent -> {
            int index = Integer.parseInt(numberWantToDelete.getText());
            HelloApplication.deletePizza(index);
            orderListTxt.setText(HelloApplication.viewAllPizzas());
            numberWantToDelete.clear();
            numberWantToDelete.setVisible(false);
            approveRemoveBtn.setVisible(false);
            undoRemoveBtn.setVisible(false);
            sumOfOrderTxt.setText("Сума:\t" + HelloApplication.sumOfAllOrder() + " ₴");
            promocodeBtn.setVisible(true);
            adressField.setVisible(true);
            adressFieldEmpty.setVisible(false);
        });

        promocodeBtn.setOnAction(actionEvent -> {
            promocodeField.setVisible(true);
            approvePromocodeBtn.setVisible(true);
            undoPromocodeBtn.setVisible(true);
            incorrectPromocodeTxt.setVisible(false);
            adressField.setVisible(false);
            adressFieldEmpty.setVisible(false);
        });

        approvePromocodeBtn.setOnAction(actionEvent -> {
            if(promocodeField.getText().equals("СЛАВА УКРАЇНІ")) {
                discountTxt.setVisible(true);
                sumOfOrderTxt.setText("Сума:\t" + HelloApplication.discountSumOfAllOrder() + " ₴");
                promocodeField.setVisible(false);
                approvePromocodeBtn.setVisible(false);
                undoPromocodeBtn.setVisible(false);
                promocodeField.clear();
                adressField.setVisible(true);
                adressFieldEmpty.setVisible(false);
            } else {
                promocodeField.setVisible(false);
                approvePromocodeBtn.setVisible(false);
                undoPromocodeBtn.setVisible(false);
                promocodeField.clear();
                incorrectPromocodeTxt.setVisible(true);
                adressField.setVisible(true);
                adressFieldEmpty.setVisible(false);
            }
        });

        undoPromocodeBtn.setOnAction(actionEvent -> {
            promocodeField.setVisible(false);
            approvePromocodeBtn.setVisible(false);
            undoPromocodeBtn.setVisible(false);
            promocodeField.clear();
            adressField.setVisible(true);
            adressFieldEmpty.setVisible(false);
        });

        completeOrderBtn.setOnAction(actionEvent -> {
            if(!adressField.getText().equals("")) {
                openFinalWindow("final-view.fxml");
            } else {
                adressField.setVisible(false);
                adressFieldEmpty.setVisible(true);
            }
        });

        completeOrderBtn.setOnAction(actionEvent -> {
            if(!adressFieldEmpty.getText().equals("")) {
                openFinalWindow("final-view.fxml");
            } else {
                adressField.setVisible(false);
                adressFieldEmpty.setVisible(true);
            }
        });



    }

    public void openMenuWindow(String window) {
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

    public void openFinalWindow(String window) {
        completeOrderBtn.getScene().getWindow().hide();

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
