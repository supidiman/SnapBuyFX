package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Cart;
import model.Product;

public class CartScreen {

    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;
    }

    public void showCart() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Sepetim");

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        if (cart.getProducts().isEmpty()) {
            root.getChildren().add(new Label("Sepetiniz boş."));
        } else {
        	for (Product p : cart.getProducts()) {
        	    Label label = new Label(p.getName() + " - " + p.getPrice() + "₺");

        	    Button removeButton = new Button("Çıkar");
        	    removeButton.setOnAction(e -> {
        	        cart.removeProduct(p);
        	        stage.close();         // pencereyi kapat
        	        showCart();            // yenisini aç
        	    });

        	    VBox box = new VBox(5, label, removeButton);
        	    root.getChildren().add(box);
        	}

            Label totalLabel = new Label("Toplam: " + cart.getTotal() + "₺");
            root.getChildren().add(totalLabel);
        
        Button orderButton = new Button("Siparişi Tamamla");
        orderButton.setOnAction(e -> {
            OrderScreen os = new OrderScreen(cart);
            os.showOrderScreen();
        });
        root.getChildren().add(orderButton);
        }

        Scene scene = new Scene(root, 300, 400);
        stage.setScene(scene);
        stage.show();
    }
}
