package com.example.partsstore.model;

public class Part {
    private String id;
    private String name;
    private String description;
    private double price;
    private String categoryId;

    public Part() {
    }

    public Part(String id, String name, String description, double price, String categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }

    // геттеры и сеттеры для всех полей
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategoryId() { return categoryId; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
}
