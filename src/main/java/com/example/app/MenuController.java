package com.example.app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.app.model.Pizza;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Text addedPizzaInBasketTxt;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buyPizza4cheeseBtn;

    @FXML
    private Button buyPizzaBavariaBtn;

    @FXML
    private Button buyPizzaSeaBtn;

    @FXML
    private Text exitTxt;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button goToOrderBtn;

    @FXML
    private Button nextMenuPageBtn;

    @FXML
    private ToggleGroup pizza4cheese;

    @FXML
    private RadioButton pizza4cheese30cmBtn;

    @FXML
    private RadioButton pizza4cheese40cmBtn;

    @FXML
    private ToggleGroup pizzaBavaria;

    @FXML
    private RadioButton pizzaBavaria30cmBtn;

    @FXML
    private RadioButton pizzaBavaria40cmBtn;

    @FXML
    private ToggleGroup pizzaSea;

    @FXML
    private RadioButton pizzaSea30cmBtn;

    @FXML
    private RadioButton pizzaSea40cmBtn;

    @FXML
    void initialize() {
        addedPizzaInBasketTxt.setText(counterOfOrders());

        pizza4cheese.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizza4cheese.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) pizza4cheese.getSelectedToggle();
                if (button.getText().equals("30 см")) {
                    buyPizza4cheeseBtn.setText("139 ₴");
                } else if (button.getText().equals("40 см")) {
                    buyPizza4cheeseBtn.setText("169 ₴");
                }
            }
        });

        pizzaSea.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizzaSea.getSelectedToggle() != null) {
                RadioButton button2 = (RadioButton) pizzaSea.getSelectedToggle();
                if (button2.getText().equals("30 см")) {
                    buyPizzaSeaBtn.setText("159 ₴");
                } else if (button2.getText().equals("40 см")) {
                    buyPizzaSeaBtn.setText("189 ₴");
                }
            }
        });

        pizzaBavaria.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizzaBavaria.getSelectedToggle() != null) {
                RadioButton button3 = (RadioButton) pizzaBavaria.getSelectedToggle();
                if (button3.getText().equals("30 см")) {
                    buyPizzaBavariaBtn.setText("149 ₴");
                } else if (button3.getText().equals("40 см")) {
                    buyPizzaBavariaBtn.setText("179 ₴");
                }
            }
        });

        buyPizza4cheeseBtn.setOnAction(actionEvent -> {
            if(buyPizza4cheeseBtn.getText().equals("139 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Чотири сири»", 30, 139));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «4 сири, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Чотири сири»", 40, 169));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «4 сири, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        buyPizzaSeaBtn.setOnAction(actionEvent -> {
            if(buyPizzaSeaBtn.getText().equals("159 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Морська»", 30, 159));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Морська, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Морська»", 40, 189));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Морська, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        buyPizzaBavariaBtn.setOnAction(actionEvent -> {
            if(buyPizzaBavariaBtn.getText().equals("149 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Баварська»", 30, 149));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Баварська, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Баварська»", 40, 179));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Баварська, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        goBackBtn.setOnAction(actionEvent -> {
            openAnotherWindow(goBackBtn, "hello-view.fxml");
            HelloApplication.clearBasket();
            HelloApplication.counter = 0;
        });

        nextMenuPageBtn.setOnAction(actionEvent -> {
            openAnotherWindow(nextMenuPageBtn,"menu2.fxml");
        });

        goToOrderBtn.setOnAction(actionEvent -> {
            openAnotherWindow(goToOrderBtn,"order-list.fxml");
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

    public String counterOfOrders() {
        return "Кількість замовлених піц: "  + HelloApplication.counter +
                ". Сума замовлення: " + HelloApplication.sumOfAllOrder() + "₴";
    }
}
