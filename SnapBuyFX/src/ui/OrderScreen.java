package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

public class OrderScreen {

    private Cart cart;

    public OrderScreen(Cart cart) {
        this.cart = cart;
    }

    public void showOrderScreen() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Sipariş Tamamla");

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label titleLabel = new Label("Sepetinizdeki Ürünler:");

        root.getChildren().add(titleLabel);

        for (Product p : cart.getProducts()) {
            root.getChildren().add(new Label(p.getName() + " - " + p.getPrice() + "₺"));
        }

        Label totalLabel = new Label("Toplam Tutar: " + cart.getTotal() + "₺");

        ToggleGroup paymentGroup = new ToggleGroup();
        RadioButton creditCardOption = new RadioButton("Kredi Kartı");
        RadioButton cashOption = new RadioButton("Nakit");

        creditCardOption.setToggleGroup(paymentGroup);
        cashOption.setToggleGroup(paymentGroup);
        creditCardOption.setSelected(true);

        Button payButton = new Button("Ödemeyi Tamamla");
        Label resultLabel = new Label();

        payButton.setOnAction(e -> {
            Payment payment;

            if (creditCardOption.isSelected()) {
                payment = new CreditCardPayment();
            } else {
                payment = new CashPayment();
            }

            Order order = new Order(cart.getProducts());
            payment.pay(order.getTotalAmount());

            resultLabel.setText("Siparişiniz başarıyla alındı.");
            cart.clearCart();
        });

        root.getChildren().addAll(totalLabel, creditCardOption, cashOption, payButton, resultLabel);

        Scene scene = new Scene(root, 350, 400);
        stage.setScene(scene);
        stage.show();
    }
}
