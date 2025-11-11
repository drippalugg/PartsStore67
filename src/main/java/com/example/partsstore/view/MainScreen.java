package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainScreen extends BorderPane {
    private final Stage stage;
    private final User currentUser;

    public MainScreen(Stage stage, User currentUser) {
        this.stage = stage;
        this.currentUser = currentUser;

        setStyle("-fx-background-color: #fff;");

        HBox topMenu = new HBox(20);
        topMenu.setPadding(new Insets(20, 40, 20, 40));
        topMenu.setAlignment(Pos.CENTER_LEFT);

        Label cityLabel = new Label("Энгельс");
        Label storeLabel = new Label("MasterParts");

        Button profileBtn = new Button("Личный кабинет");
        profileBtn.setOnAction(e -> openProfileWindow());

        Button cartBtn = new Button("Корзина");
        cartBtn.setOnAction(e -> openCartWindow());

        Button ordersBtn = new Button("Заказы");
        ordersBtn.setOnAction(e -> openOrdersWindow());

        Button favoritesBtn = new Button("Избранное");
        favoritesBtn.setOnAction(e -> openFavoritesWindow());

        HBox rightMenu = new HBox(15, ordersBtn, favoritesBtn, cartBtn, profileBtn);
        rightMenu.setAlignment(Pos.CENTER_RIGHT);
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        topMenu.getChildren().addAll(cityLabel, storeLabel, spacer, rightMenu);
        setTop(topMenu);

        // Категории/каталог
        setCenter(new Label("Категории автозапчастей"));

        getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
    }

    public void openMainScreen() {
        Scene scene = new Scene(this, 1300, 800);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("MasterParts");
    }

    private void openProfileWindow() {
        stage.setScene(new Scene(new ProfileWindow(stage, currentUser, this), 600, 500));
        stage.getScene().getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Личный кабинет");
    }
    private void openCartWindow() {
        stage.setScene(new Scene(new CartWindow(stage, currentUser, this), 800, 600));
        stage.getScene().getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Корзина");
    }
    private void openOrdersWindow() {
        stage.setScene(new Scene(new OrdersWindow(stage, currentUser, this), 800, 600));
        stage.getScene().getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Заказы");
    }
    private void openFavoritesWindow() {
        stage.setScene(new Scene(new FavoritesWindow(stage, currentUser, this), 800, 600));
        stage.getScene().getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Избранное");
    }
}
