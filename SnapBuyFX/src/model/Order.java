package model;

import java.util.List;

public class Order {
    private List<Product> products;
    private double totalAmount;

    public Order(List<Product> products) {
        this.products = products;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Product> getProducts() {
        return products;
    }
}
