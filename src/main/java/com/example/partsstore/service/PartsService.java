package com.example.partsstore.service;

import com.example.partsstore.model.Category;
import com.example.partsstore.model.Part;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PartsService {
    private final ObservableList<Category> categories;
    private final ObservableList<Part> parts;

    public PartsService() {
        this.categories = FXCollections.observableArrayList();
        this.parts = FXCollections.observableArrayList();
        loadMockData();
    }

    public ObservableList<Part> getPartsByCategory(int categoryId) {
        return parts.filtered(part -> part.getCategoryId() == categoryId);
    }

    public ObservableList<Part> searchParts(String query) {
        String lowerQuery = query.toLowerCase();
        return parts.filtered(part ->
                part.getName().toLowerCase().contains(lowerQuery) ||
                        part.getArticle().toLowerCase().contains(lowerQuery) ||
                        part.getBrand().toLowerCase().contains(lowerQuery)
        );
    }

    public Part getPartById(int id) {
        return parts.stream()
                .filter(part -> part.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public ObservableList<Part> getParts() {
        return parts;
    }

    // Загрузка тестовых данных
    private void loadMockData() {
        // Категории
        categories.addAll(
                new Category(1, "Чистота", "🧴"),
                new Category(2, "Аксессуары", "🔌"),
                new Category(3, "ТО", "🔧"),
                new Category(4, "Инструменты", "🛠️"),
                new Category(5, "Шины", "⚫"),
                new Category(6, "Кузовные", "🚗"),
                new Category(7, "Масла", "🛢️"),
                new Category(8, "Аккумуляторы", "🔋")
        );

        // Товары
        parts.addAll(
                // Чистота
                createPart(1, "Автошампунь концентрат", 1, 450, 600.0, "CS-001", "CleanPro"),
                createPart(2, "Очиститель стекол", 1, 280, null, "CS-002", "GlassMax"),
                createPart(3, "Полироль кузова", 1, 890, 1200.0, "CS-003", "ShineMax"),
                createPart(4, "Чернитель шин", 1, 320, null, "CS-004", "TireShine"),

                // Аксессуары
                createPart(5, "Держатель телефона", 2, 550, null, "AC-001", "CarMount"),
                createPart(6, "Зарядное устройство USB", 2, 890, 1100.0, "AC-002", "PowerDrive"),
                createPart(7, "Ароматизатор", 2, 150, null, "AC-003", "FreshAir"),
                createPart(8, "Коврики салона", 2, 2400, null, "AC-004", "ComfortFloor"),

                // ТО
                createPart(9, "Фильтр масляный", 3, 450, null, "TO-001", "Mann Filter"),
                createPart(10, "Фильтр воздушный", 3, 620, 750.0, "TO-002", "Bosch"),
                createPart(11, "Свечи зажигания", 3, 1200, null, "TO-003", "NGK"),
                createPart(12, "Тормозные колодки", 3, 3500, 4200.0, "TO-004", "Brembo"),

                // Инструменты
                createPart(13, "Набор ключей", 4, 2800, null, "IN-001", "Jonnesway"),
                createPart(14, "Домкрат гидравлический", 4, 4500, 5500.0, "IN-002", "Stels"),
                createPart(15, "Компрессор автомобильный", 4, 3200, null, "IN-003", "Berkut"),
                createPart(16, "Мультиметр цифровой", 4, 1850, null, "IN-004", "Mastech"),

                // Шины
                createPart(17, "Шина Nokian Hakkapeliitta", 5, 8900, 10500.0, "TI-001", "Nokian"),
                createPart(18, "Шина Michelin Pilot Sport", 5, 12500, null, "TI-002", "Michelin"),
                createPart(19, "Шина Continental ContiCross", 5, 9800, null, "TI-003", "Continental"),
                createPart(20, "Шина Yokohama BluEarth", 5, 7400, 8600.0, "TI-004", "Yokohama"),

                // Кузовные
                createPart(21, "Фара передняя левая", 6, 5600, null, "BO-001", "Depo"),
                createPart(22, "Бампер передний", 6, 8900, 11000.0, "BO-002", "OEM"),
                createPart(23, "Зеркало боковое", 6, 3200, null, "BO-003", "Magneti Marelli"),
                createPart(24, "Капот", 6, 12500, null, "BO-004", "OEM"),

                // Масла
                createPart(25, "Масло моторное 5W-40", 7, 2800, 3400.0, "OIL-001", "Mobil"),
                createPart(26, "Масло моторное 0W-20", 7, 3500, null, "OIL-002", "Shell"),
                createPart(27, "Масло трансмиссионное", 7, 1600, null, "OIL-003", "Castrol"),
                createPart(28, "Антифриз G12", 7, 890, 1100.0, "OIL-004", "Liqui Moly"),

                // Аккумуляторы
                createPart(29, "Аккумулятор Varta Blue", 8, 8500, null, "BAT-001", "Varta"),
                createPart(30, "Аккумулятор Bosch S4", 8, 9200, 10500.0, "BAT-002", "Bosch"),
                createPart(31, "Аккумулятор Mutlu SFB", 8, 7800, null, "BAT-003", "Mutlu"),
                createPart(32, "Аккумулятор Exide Premium", 8, 11500, null, "BAT-004", "Exide")
        );
    }

    private Part createPart(int id, String name, int categoryId, double price,
                            Double oldPrice, String article, String brand) {
        Part part = new Part(id, name, categoryId, price, article, brand);
        part.setOldPrice(oldPrice);
        part.setDescription("Качественная автозапчасть " + name + " от производителя " + brand);
        return part;
    }
}
