package com.example.app;

import com.example.app.model.Pizza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static List<Pizza> basket = new ArrayList<Pizza>();
    public static int counter = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Піцерія PizzaKing");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void addPizzaInBasket(Pizza pizza) {
        basket.add(pizza);
    }

    public static void deletePizza(int index) {
        basket.remove(index - 1);
    }

    public static String viewAllPizzas(){
        String allPizzas = "";
        for(int i = 0; i < basket.size(); i++) {
            allPizzas += "  " + (i + 1) + "    " + basket.get(i).toString() + '\n';
        }
        return allPizzas;
    }

    public static void clearBasket(){
        basket.clear();
    }

    public static int sumOfAllOrder(){
        int sumOfOrder = 0;
        try {
            for(Pizza pizzas: basket) {
                sumOfOrder += pizzas.getPizzasPrice();
            }
        } catch(NullPointerException ex) {
            System.out.println("Error!");
        }
        return sumOfOrder;
    }

    public static double discountSumOfAllOrder(){
        int sumOfOrder = 0;
        try {
            for(Pizza pizzas: basket) {
                sumOfOrder += pizzas.getPizzasPrice();
            }
        } catch(NullPointerException ex) {
            System.out.println("Error!");
        }
        return sumOfOrder - sumOfOrder * 0.1;
    }
}