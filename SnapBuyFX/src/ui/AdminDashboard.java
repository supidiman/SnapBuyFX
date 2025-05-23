package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminDashboard {

    public void showDashboard() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Admin Paneli");

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        Button addProductButton = new Button("Ürün Ekle");
        Button viewProductsButton = new Button("Ürünleri Görüntüle");

        // Ürün ekleme ekranına yönlendirme
        addProductButton.setOnAction(e -> {
            AddProductScreen addScreen = new AddProductScreen();
            addScreen.showAddProductScreen();
        });

        // Ürün listeleme ekranına yönlendirme
        viewProductsButton.setOnAction(e -> {
            AdminProductListScreen listScreen = new AdminProductListScreen();
            listScreen.showProductList();
        });

        root.getChildren().addAll(addProductButton, viewProductsButton);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
