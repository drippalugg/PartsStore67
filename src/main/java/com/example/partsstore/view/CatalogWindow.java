package com.example.partsstore.view;

import com.example.partsstore.model.Part;
import com.example.partsstore.model.Category;
import com.example.partsstore.service.PartsService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class CatalogWindow extends BorderPane {
    private PartsService service;
    private ObservableList<Part> currentParts;

    public CatalogWindow() {
        service = new PartsService();

        ComboBox<Category> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().add(null);
        categoryComboBox.getItems().addAll(service.getAllCategories());
        categoryComboBox.setPromptText("Категория");

        TextField searchField = new TextField();
        searchField.setPromptText("Поиск...");

        Button filterButton = new Button("Фильтровать");

        HBox filterBox = new HBox(10, categoryComboBox, searchField, filterButton);
        filterBox.setPadding(new Insets(10));

        TableView<Part> partsTable = new TableView<>();
        currentParts = FXCollections.observableArrayList(service.getPartsFiltered(null, null));
        partsTable.setItems(currentParts);

        TableColumn<Part, String> nameCol = new TableColumn<>("Название");
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        TableColumn<Part, String> descCol = new TableColumn<>("Описание");
        descCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

        TableColumn<Part, Number> priceCol = new TableColumn<>("Цена");
        priceCol.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()));

        partsTable.getColumns().addAll(nameCol, descCol, priceCol);


        // Обработка фильтра
        filterButton.setOnAction(e -> {
            Category selectedCategory = categoryComboBox.getValue();
            String categoryId = selectedCategory == null ? null : selectedCategory.getId();
            String query = searchField.getText();

            currentParts.setAll(service.getPartsFiltered(categoryId, query));
        });

        setTop(filterBox);
        setCenter(partsTable);
    }
}
