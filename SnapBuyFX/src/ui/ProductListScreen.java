package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;
import model.ProductDAO;
import model.Cart;

import java.util.List;

public class ProductListScreen {

    private final Cart cart;

    public ProductListScreen(Cart cart) {
        this.cart = cart;
    }

    public void showProductList() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Ürün Listesi");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        List<Product> products = ProductDAO.getAllProducts();

        if (products.isEmpty()) {
            root.getChildren().add(new Label("Stokta ürün yok."));
        } else {
            for (Product p : products) {
                Label label = new Label(
                        "ID: " + p.getId() +
                        " | " + p.getName() +
                        " - " + p.getPrice() + "₺ (" + p.getStock() + " adet)"
                );
                Button addButton = new Button("Sepete Ekle");
                addButton.setOnAction(e -> {
                    cart.addProduct(p);
                    System.out.println(p.getName() + " sepete eklendi.");
                });

                VBox box = new VBox(5, label, addButton);
                root.getChildren().add(box);
            }
        }

        Scene scene = new Scene(root, 450, 400);
        stage.setScene(scene);
        stage.show();
        Button viewCartButton = new Button("Sepeti Gör ve Öde");
        viewCartButton.setOnAction(e -> {
            CartScreen cs = new CartScreen(cart);
            cs.showCart();
        });
        root.getChildren().add(viewCartButton);
    }
    
    
    
}
