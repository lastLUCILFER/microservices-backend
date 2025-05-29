package com.store.productservice.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = true)
    private String cpu;
    @Column(nullable = true)
    private String gpu;
    @Column(nullable = true)
    private String ram;
    @Column(nullable = false)
    private double price;
    private String image;

    public Product() {}

    public Product(String name,String type,String CPU, String GPU,String ram, double price,String image){
        this.name=name;
        this.type=type;
        this.cpu=CPU;
        this.gpu=GPU;
        this.ram=ram;
        this.price=price;
        this.image=image;
    }

   
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
    
    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

 
    public void setType(String type) {
        this.type = type;
    }


    public void setCpu(String cpu) {
        this.cpu = cpu;
    }


    public void setGpu(String gpu) {
        this.gpu = gpu;
    }


    public void setRam(String ram) {
        this.ram = ram;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
