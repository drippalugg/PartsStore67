package com.example.partsstore;

import com.example.partsstore.model.Part;
import com.example.partsstore.service.PartsService;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CatalogWindow extends VBox {
    private PartsService service = new PartsService();

    public CatalogWindow() {
        TableView<Part> table = new TableView<>();
        table.setItems(FXCollections.observableArrayList(service.getAllParts()));

        TableColumn<Part, String> nameCol = new TableColumn<>("Название");
        TableColumn<Part, String> descCol = new TableColumn<>("Описание");
        TableColumn<Part, Number> priceCol = new TableColumn<>("Цена");
        // bind cell value factories

        Button addBtn = new Button("Добавить");
        addBtn.setOnAction(e -> {
            // Реализуйте диалоговое окно и вызов service.addPart(...)
        });

        getChildren().addAll(table, addBtn);
    }
}
