package com.example.partsstore.view;

import com.example.partsstore.model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MasterPartsMainWindow extends BorderPane {
    private final Stage stage;
    private final User currentUser;
    private final Button profileBtn;
    private ProfileWindow profileWindow;

    public MasterPartsMainWindow(Stage stage, User user) {
        this.stage = stage;
        this.currentUser = user;

        setStyle("-fx-background-color: #fff;");

        profileBtn = new Button("Личный кабинет");
        profileBtn.setOnAction(e -> openProfileWindow());

        profileWindow = new ProfileWindow(stage, currentUser);

        HBox topMenu = new HBox(20);
        topMenu.setPadding(new Insets(20, 40, 20, 40));
        topMenu.setAlignment(Pos.CENTER_LEFT);

        Label cityLabel = new Label("Энгельс");
        cityLabel.setStyle("-fx-text-fill: #232325;");
        Label storeLabel = new Label("MasterParts");
        storeLabel.setStyle("-fx-text-fill: #232325; -fx-font-size: 20; -fx-font-weight: bold;");

        HBox iconsBox = new HBox(18);
        iconsBox.setAlignment(Pos.CENTER_RIGHT);

        Button ordersBtn = new Button("Заказы");
        ordersBtn.setOnAction(e -> openOrdersWindow());

        Button favoritesBtn = new Button("Избранное");
        favoritesBtn.setOnAction(e -> openFavoritesWindow());

        Button cartBtn = new Button("Корзина");
        cartBtn.setOnAction(e -> openCartWindow());

        iconsBox.getChildren().addAll(ordersBtn, favoritesBtn, cartBtn, profileBtn);

        TextField searchField = new TextField();
        searchField.setPromptText("Поиск по названию, артикулу, бренду");
        searchField.setPrefWidth(350);

        Button searchBtn = new Button("🔍");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topMenu.getChildren().addAll(cityLabel, storeLabel, spacer, searchField, searchBtn, iconsBox);
        setTop(topMenu);
    }

    private void openProfileWindow() {
        Button backButton = new Button("Назад");
        backButton.setOnAction(e -> openMainWindow());

        VBox profileRoot = new VBox(15, backButton, profileWindow);
        profileRoot.setPadding(new Insets(20));

        Scene scene = new Scene(profileRoot, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Личный кабинет");
    }

    private void openMainWindow() {
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
