# SnapBuy

SnapBuy, JavaFX ile geliştirilmiş bir masaüstü alışveriş uygulamasıdır. Kullanıcılar kayıt olabilir, ürünleri inceleyebilir, sepete ekleyebilir ve ödeme simülasyonu yapabilir. Admin kullanıcılar ise ürün ekleyip silebilir. Proje, nesne yönelimli programlama ilkelerine ve veritabanı bağlantısına dayalıdır.

---

## 🔧 Kullanılan Teknolojiler

- Java 17
- JavaFX
- MySQL
- JDBC
- OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
- Regex (form doğrulama)
- Multithreading (ödeme ekranı)

---

## 📁 Proje Yapısı

```
SnapBuyFX/
 ┣ src/
 ┃ ┣ ui/                 → GUI ekranları
 ┃ ┣ model/              → Nesne yapıları (User, Product, DAO'lar)
 ┃ ┗ db/                 → Veritabanı bağlantısı
 ┣ lib/                  → mysql-connector-java jar dosyası
 ┣ .classpath
 ┣ .project
```

---

## 🧪 Veritabanı Kurulumu

1. MySQL'de `snapbuy_db` adında bir veritabanı oluşturun:

```sql
CREATE DATABASE snapbuy_db;
USE snapbuy_db;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    role VARCHAR(20)
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    description TEXT,
    price DOUBLE,
    stock INT
);
```

2. Admin kullanıcı eklemek için:

```sql
INSERT INTO users (username, password, email, role)
VALUES ('admin1', 'admin123', 'admin@snapbuy.com', 'admin');
```

---

## ▶️ Uygulamayı Çalıştırma

1. Eclipse veya VS Code ile projeyi açın  
2. Java 17 ve JavaFX kütüphanelerini `Build Path`e ekleyin  
3. MySQL Connector `.jar` dosyasını da `lib/` klasörüne ekleyin  
4. `Main.java` dosyasını çalıştırın  
5. İlk ekran Login ekranıdır.  
   - Admin: `admin1 / admin123`
   - Müşteri: kayıt olabilirsiniz

---

## 💡 Projenin Özellikleri

- Kullanıcı kayıt & giriş işlemleri (Regex doğrulamalı)
- Admin/Müşteri rol ayrımı
- Admin paneli: ürün ekle/sil
- Müşteri paneli: ürün listeleme, sepete ekleme
- Sepet görüntüleme ve ürün çıkarma
- Ödeme simülasyonu (multithreading)
- Veritabanı ile tüm veri yönetimi

---

## 📌 Notlar

- Kod yapısı OOP ilkelerine %100 uygundur
- Exception handling, veritabanı güvenliği sağlanmıştır
- Bonus puan için Regex ve Multithreading özellikleri dahil edilmiştir

---

## 👤 Geliştirici

- **Ad Soyad:** Furkan Tayyip Arfat  
- **Öğrenci No:** 21118080742  
- **Ders:** CENG106 - Object Oriented Programming Lab  
- **Dönem:** 2024–2025 Bahar Dönemi
