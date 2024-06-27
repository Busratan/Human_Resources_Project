package com.example.HR.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Bu anotasyon bu sınıfın bir veritabanı tablosuna karşılık geldiğini belirtir.

public class Employee {
    @Id // Bu anotasyon, 'id' alanının birincil anahtar olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bu 'id' alanının otomatik olarak arttırılacağını belirtir.

    private Long id; //Çalışanın benzersiz (unique) kimliği
    private String name; // Çalışanın adı
    private String position; // Çalışanın pozisyonu

    // Getter ve Setter metotları
    // Getter , özel alanların değerini okumak için kullanılır.
    // Setter, özel alanların değerini ayarlamak için kullanılır.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}