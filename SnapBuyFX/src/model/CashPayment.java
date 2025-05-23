package model;

public class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Nakit ödeme alındı: " + amount + "₺");
    }
}
