package org.example.springbootlt01k16.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//Định nghĩa Brand là 1 entity tương ứng với bảng trong db
@Entity
//Cấu hình cho class này tương ứng với bảng có tên là brands trong db
@Table(name = "brand")
public class Brand {
    //Pk, Auto_increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    //Attr name tương ứng với cột name trong db
    @Column
    private String Name;

    //Định nghĩa 1 brand có nhiều product
    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}