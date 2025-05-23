package model;

public class Admin extends User {

    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    @Override
    public void showDashboard() {
        System.out.println("Admin Paneli yüklendi.");
    }
}
