package ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Customer;
import model.UserDAO;
import model.Cart;
import model.Admin;
import ui.AdminDashboard;


public class LoginScreen {

    public void showLoginWindow() {
        Stage stage = new Stage();
        stage.setTitle("SnapBuy - Giriş Ekranı");

        // Giriş Alanları
        Label usernameLabel = new Label("Kullanıcı Adı:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Şifre:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Giriş Yap");
        Button registerButton = new Button("Kayıt Ol");
        Label messageLabel = new Label();

        // Giriş butonu aksiyonu
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            Customer customer = UserDAO.login(username, password);
            if (customer != null) {
                messageLabel.setText("Giriş başarılı! Hoş geldin, " + customer.getUsername());
                stage.close();
                Cart cart = new Cart();
                ProductListScreen pls = new ProductListScreen(cart);
                pls.showProductList();
                return;
            }

            // admin kontrolü
            Admin admin = UserDAO.loginAdmin(username, password);
            if (admin != null) {
                messageLabel.setText("Admin girişi başarılı! Hoş geldin, " + admin.getUsername());
                stage.close();
                AdminDashboard dash = new AdminDashboard();
                dash.showDashboard();
                return;
            }

            messageLabel.setText("Hatalı kullanıcı adı veya şifre.");
        });

        // Kayıt butonu aksiyonu
        registerButton.setOnAction(e -> {
            RegisterScreen rs = new RegisterScreen();
            rs.showRegisterWindow();
        });

        // Arayüz düzeni
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 0, 2);
        grid.add(registerButton, 1, 2);
        grid.add(messageLabel, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
