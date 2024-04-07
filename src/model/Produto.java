package model;

import java.time.LocalDate;

public class Product {
    private String id;
    private String productName;
    private String lot;
    private LocalDate expirationDate;
    private int quantity;

    public Product(String id, String productName, String lot, LocalDate expirationDate, int quantity) {
        this.id = id;
        this.productName = productName;
        this.lot = lot;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getLot() {
        return lot;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "===== Product ===== \n" +
                "id: " + id + '\n' +
                "Product Name='" + productName + '\n' +
                "Lot: " + lot + '\n' +
                "Expiration Date: " + expirationDate;
    }
}
