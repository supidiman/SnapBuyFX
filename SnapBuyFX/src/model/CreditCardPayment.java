package model;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Kredi kartı ile ödeme yapıldı: " + amount + "₺");
    }
}
