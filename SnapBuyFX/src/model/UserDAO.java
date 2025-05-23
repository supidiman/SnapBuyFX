package model;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // Kullanıcı kayıt metodu
    public static boolean registerUser(Customer customer) {
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getUsername());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, "customer");

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Kullanıcı giriş doğrulama metodu
    public static Customer login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = 'customer'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        "Veritabanından geldi" // adres opsiyonel
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

public static Admin loginAdmin(String username, String password) {
    String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = 'admin'";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, username);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Admin(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}
}