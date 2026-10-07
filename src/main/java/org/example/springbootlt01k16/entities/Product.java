package org.example.springbootlt01k16.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    //id, name, price, quantity, description, brand_id, category_id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String Name;

    @Column(columnDefinition = "DOUBLE CHECK(price > 0)")
    private Double Price;

    @Column(columnDefinition = "INT CHECK(quantity > 0)")
    private Integer Quantity;

    @Column(columnDefinition = "TEXT")
    private String Description;

    //nhiều product thuộc về 1 brand
    @ManyToOne(fetch = FetchType.LAZY)
    //Cột FK
    @JoinColumn(name = "brand_id")
    private Brand brand;

    //nhiều product thuộc về 1 brand
    @ManyToOne(fetch = FetchType.LAZY)
    //Cột FK
    @JoinColumn(name = "category_id")
    private Category category;

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

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}