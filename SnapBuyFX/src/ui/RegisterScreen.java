package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Customer;
import model.UserDAO;

public class RegisterScreen {

    public void showRegisterWindow() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Kayıt Ol");

        Label usernameLabel = new Label("Kullanıcı Adı:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Şifre:");
        PasswordField passwordField = new PasswordField();

        Label emailLabel = new Label("E-posta:");
        TextField emailField = new TextField();

        Label addressLabel = new Label("Adres:");
        TextField addressField = new TextField();

        Button registerButton = new Button("Kaydı Tamamla");

        // ✅ Hata mesajları için etiket
        Label messageLabel = new Label();

        registerButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String address = addressField.getText();

            // 🔍 Regex doğrulama
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
                messageLabel.setText("Geçersiz e-posta formatı.");
                return;
            }

            if (password.length() < 6) {
                messageLabel.setText("Şifre en az 6 karakter olmalı.");
                return;
            }

            Customer newUser = new Customer(username, password, email, address);

            if (UserDAO.registerUser(newUser)) {
                messageLabel.setText("Kayıt başarılı!");
                stage.close(); // Başarılıysa pencereyi kapat
            } else {
                messageLabel.setText("Kayıt başarısız.");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(addressLabel, 0, 3);
        grid.add(addressField, 1, 3);
        grid.add(registerButton, 1, 4);
        grid.add(messageLabel, 1, 5); // ✔️ mesaj alanı

        Scene scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
