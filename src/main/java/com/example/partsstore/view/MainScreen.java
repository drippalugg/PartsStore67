package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainScreen extends BorderPane {
    private Stage stage;
    private User currentUser;

    public MainScreen(Stage stage, User user) {
        this.stage = stage;
        this.currentUser = user;

        setStyle("-fx-background-color: #fff;");

        HBox topMenu = new HBox(20);
        topMenu.setAlignment(Pos.CENTER_LEFT);
        topMenu.setPadding(new Insets(20, 40, 20, 40));

        Label cityLabel = new Label("Энгельс");
        Label storeLabel = new Label("MasterParts");
        Label userLabel = new Label("Пользователь: " + currentUser.getEmail());

        HBox iconsBox = new HBox(18);
        iconsBox.setAlignment(Pos.CENTER_RIGHT);

        Button ordersBtn = new Button("Заказы");
        ordersBtn.setOnAction(e -> openOrdersWindow());

        Button favoritesBtn = new Button("Избранное");
        favoritesBtn.setOnAction(e -> openFavoritesWindow());

        Button cartBtn = new Button("Корзина");
        cartBtn.setOnAction(e -> openCartWindow());

        Button profileBtn = new Button("Личный кабинет");
        profileBtn.setOnAction(e -> openProfileWindow());

        iconsBox.getChildren().addAll(ordersBtn, favoritesBtn, cartBtn, profileBtn);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        TextField searchField = new TextField();
        searchField.setPromptText("Поиск по названию, артикулу, бренду");
        searchField.setPrefWidth(350);

        Button searchBtn = new Button("🔍");

        topMenu.getChildren().addAll(cityLabel, storeLabel, spacer, searchField, searchBtn, iconsBox);
        setTop(topMenu);
    }

    private void openProfileWindow() {
        ProfileWindow profileWindow = new ProfileWindow(stage, currentUser);
        Button backBtn = new Button("Назад");
        backBtn.setOnAction(e -> openMainScreen());

        VBox root = new VBox(15, backBtn, profileWindow);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("Личный кабинет");
    }

    private void openMainScreen() {
        Scene scene = new Scene(this, 1300, 800);
        stage.setScene(scene);
        stage.setTitle("MasterParts");
    }

    private void openOrdersWindow() {
        OrdersWindow ordersWindow = new OrdersWindow(stage, currentUser);
        stage.setScene(new Scene(ordersWindow, 800, 600));
        stage.setTitle("Мои заказы");
    }

    private void openFavoritesWindow() {
        FavoritesWindow favoritesWindow = new FavoritesWindow(stage, currentUser);
        stage.setScene(new Scene(favoritesWindow, 800, 600));
        stage.setTitle("Избранное");
    }

    private void openCartWindow() {
        CartWindow cartWindow = new CartWindow(stage, currentUser);
        stage.setScene(new Scene(cartWindow, 800, 600));
        stage.setTitle("Корзина");
    }
}
