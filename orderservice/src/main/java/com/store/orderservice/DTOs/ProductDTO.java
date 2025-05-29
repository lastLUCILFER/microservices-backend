package com.store.orderservice.DTOs;

import jakarta.persistence.Column;

public class ProductDTO {
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

       public void setId(int id) {
        this.id = id;
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
}
