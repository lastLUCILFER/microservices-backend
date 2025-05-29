package com.store.productservice.DTOs;

import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.Column;

public class ProductRequest {
    
    @NotBlank(message = "name is required")
     private String name;
    @Column(nullable = false)
    @NotBlank(message = "type is required")
    private String type;
    @Column(nullable = true)
    private String cpu;
    @Column(nullable = true)
    private String gpu;
    @Column(nullable = true)
    private String ram;
    @Column(nullable = false)
    @NotBlank(message = "price is required")
    private double price;
    private String image;





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
