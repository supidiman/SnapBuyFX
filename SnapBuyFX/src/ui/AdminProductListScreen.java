package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Product;
import model.ProductDAO;

import java.util.List;

public class AdminProductListScreen {

    public void showProductList() {
        Stage stage = new Stage();
        stage.setTitle("Tüm Ürünler");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        List<Product> products = ProductDAO.getAllProducts();

        if (products.isEmpty()) {
            root.getChildren().add(new Label("Hiç ürün bulunamadı."));
        } else {
            for (Product p : products) {
                Label productLabel = new Label(                        
                        " | Ad: " + p.getName() +
                        " | Fiyat: " + p.getPrice() + "₺" +
                        " | Stok: " + p.getStock()
                );

                Button deleteButton = new Button("Sil");
                deleteButton.setOnAction(e -> {
                    boolean success = ProductDAO.deleteProductById(p.getId());
                    if (success) {
                        // ekranı yenile
                        stage.close();
                        showProductList();
                    }
                });

                VBox box = new VBox(5, productLabel, deleteButton);
                box.setStyle("-fx-border-color: gray; -fx-padding: 10;");
                root.getChildren().add(box);
            }
        }

        Scene scene = new Scene(root, 450, 500);
        stage.setScene(scene);
        stage.show();
    }
}

