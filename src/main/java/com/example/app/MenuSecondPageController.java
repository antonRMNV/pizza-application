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

public class MenuSecondPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text addedPizzaInBasketTxt ;

    @FXML
    private Button buyPizzaHawaiianBtn;

    @FXML
    private Button buyPizzaNeapolitanoBtn;

    @FXML
    private Button buyPizzaRoyalBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Text exitTxt;

    @FXML
    private Button goBackMenuPageBtn;

    @FXML
    private Button goToOrderBtn;

    @FXML
    private ToggleGroup pizzaHawaiian;

    @FXML
    private RadioButton pizzaHawaiian30cmBtn;

    @FXML
    private RadioButton pizzaHawaiian40cmBtn;

    @FXML
    private ToggleGroup pizzaNeapolitano;

    @FXML
    private RadioButton pizzaNeapolitano30cmBtn;

    @FXML
    private RadioButton pizzaNeapolitano40cmBtn;

    @FXML
    private ToggleGroup pizzaRoyal;

    @FXML
    private RadioButton pizzaRoyal30cmBtn;

    @FXML
    private RadioButton pizzaRoyal40cmBtn;

    @FXML
    void initialize() {
        addedPizzaInBasketTxt.setText(counterOfOrders());

        pizzaRoyal.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizzaRoyal.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) pizzaRoyal.getSelectedToggle();
                if (button.getText().equals("30 см")) {
                    buyPizzaRoyalBtn.setText("179 ₴");
                } else if (button.getText().equals("40 см")) {
                    buyPizzaRoyalBtn.setText("199 ₴");
                }
            }
        });

        pizzaHawaiian.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizzaHawaiian.getSelectedToggle() != null) {
                RadioButton button2 = (RadioButton) pizzaHawaiian.getSelectedToggle();
                if (button2.getText().equals("30 см")) {
                    buyPizzaHawaiianBtn.setText("149 ₴");
                } else if (button2.getText().equals("40 см")) {
                    buyPizzaHawaiianBtn.setText("169 ₴");
                }
            }
        });

        pizzaNeapolitano.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (pizzaNeapolitano.getSelectedToggle() != null) {
                RadioButton button3 = (RadioButton) pizzaNeapolitano.getSelectedToggle();
                if (button3.getText().equals("30 см")) {
                    buyPizzaNeapolitanoBtn.setText("159 ₴");
                } else if (button3.getText().equals("40 см")) {
                    buyPizzaNeapolitanoBtn.setText("189 ₴");
                }
            }
        });

        buyPizzaRoyalBtn.setOnAction(actionEvent -> {
            if(buyPizzaRoyalBtn.getText().equals("179 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Царська»", 30, 179));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Царська, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Царська»", 40, 199));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Царська, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        buyPizzaHawaiianBtn.setOnAction(actionEvent -> {
            if(buyPizzaHawaiianBtn.getText().equals("149 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Гавайська»", 30, 149));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Гавайська, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Гавайська»", 40, 169));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Гавайська, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        buyPizzaNeapolitanoBtn.setOnAction(actionEvent -> {
            if(buyPizzaNeapolitanoBtn.getText().equals("159 ₴")) {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Неаполітано»", 30, 159));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Неаполітано, 30 см» додана до вашого кошику\n" + counterOfOrders());
            } else {
                HelloApplication.addPizzaInBasket(new Pizza("Піца «Неаполітано»", 40, 189));
                HelloApplication.counter++;
                addedPizzaInBasketTxt.setText("Піца «Неаполітано, 40 см» додана до вашого кошику\n" + counterOfOrders());
            }
        });

        exitBtn.setOnAction(actionEvent -> {
            HelloApplication.clearBasket();
            openStartWindow("hello-view.fxml");
            HelloApplication.counter = 0;
        });

        goBackMenuPageBtn.setOnAction(actionEvent -> {
            openFirstPageOfMenu("menu.fxml");
        });

        goToOrderBtn.setOnAction(actionEvent -> {
            openOrderList("order-list.fxml");
        });
    }

    public void openStartWindow(String window) {
        exitBtn.getScene().getWindow().hide();

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

    public void openFirstPageOfMenu(String window) {
        goBackMenuPageBtn.getScene().getWindow().hide();

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

    public void openOrderList(String window) {
        goToOrderBtn.getScene().getWindow().hide();

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
