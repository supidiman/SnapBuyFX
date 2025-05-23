package model;

public class Customer extends User {
    private String address;

    public Customer(String username, String password, String email, String address) {
        super(username, password, email);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void showDashboard() {
        System.out.println("Müşteri Paneli yüklendi.");
    }
}
