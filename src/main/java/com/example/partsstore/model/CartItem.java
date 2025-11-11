package com.example.partsstore.model;

public class CartItem {
    private Part part;
    private int quantity;

    public CartItem(Part part, int quantity) {
        this.part = part;
        this.quantity = quantity;
    }

    public Part getPart() { return part; }
    public void setPart(Part part) { this.part = part; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return part.getPrice() * quantity;
    }
}
