package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Product;
import model.ProductDAO;

public class AddProductScreen {

    public void showAddProductScreen() {
        Stage stage = new Stage();
        stage.setTitle("Ürün Ekle");

        Label nameLabel = new Label("Ürün Adı:");
        TextField nameField = new TextField();

        Label descLabel = new Label("Açıklama:");
        TextField descField = new TextField();

        Label priceLabel = new Label("Fiyat:");
        TextField priceField = new TextField();

        Label stockLabel = new Label("Stok:");
        TextField stockField = new TextField();

        Button addButton = new Button("Ekle");
        Label messageLabel = new Label();

        addButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String desc = descField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());

                Product product = new Product(0, name, desc, price, stock);
                boolean success = ProductDAO.addProduct(product);

                if (success) {
                    messageLabel.setText("Ürün başarıyla eklendi!");
                } else {
                    messageLabel.setText("Ürün eklenirken hata oluştu.");
                }
            } catch (Exception ex) {
                messageLabel.setText("Hatalı giriş!");
                ex.printStackTrace();
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(descLabel, 0, 1);
        grid.add(descField, 1, 1);
        grid.add(priceLabel, 0, 2);
        grid.add(priceField, 1, 2);
        grid.add(stockLabel, 0, 3);
        grid.add(stockField, 1, 3);
        grid.add(addButton, 1, 4);
        grid.add(messageLabel, 1, 5);

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
