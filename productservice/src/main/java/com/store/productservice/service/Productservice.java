package com.store.productservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.productservice.DTOs.ProductDTO;
import com.store.productservice.DTOs.ProductRequest;
import com.store.productservice.Entity.Product;
import com.store.productservice.repository.ProductRepository;

@Service
public class Productservice {
    
     
    @Autowired private ProductRepository productRepository;


    private ProductDTO mapToDTO(Product product) {
    ProductDTO dto = new ProductDTO();
    dto.setId(product.getId());
    dto.setName(product.getName());
    dto.setType(product.getType());
    dto.setCpu(product.getCpu());
    dto.setGpu(product.getGpu());
    dto.setRam(product.getRam());
    dto.setPrice(product.getPrice());
    dto.setImage(product.getImage());
    return dto;
    }



    public ProductDTO AddRequest(ProductRequest request){
        if(productRepository.existsByName(request.getName())) {
            throw new RuntimeException("Product already exist");
        }

        Product product =new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setCpu(request.getCpu());
        product.setGpu(request.getGpu());
        product.setRam(request.getRam());
        product.setPrice(request.getPrice());

        Product savedProduct = productRepository.save(product);
        return mapToDTO(savedProduct);
    }



    public ProductDTO updateProduct(int id, ProductRequest request){

        Product product = productRepository.findById(id)
                          .orElseThrow(()-> new RuntimeException("product not found"));

        product.setName(request.getName());
        product.setType(request.getType());
        product.setCpu(request.getCpu());
        product.setGpu(request.getGpu());
        product.setRam(request.getRam());
        product.setPrice(request.getPrice());

        Product updatedProduct = productRepository.save(product);

        return mapToDTO(updatedProduct);
    }

    public void deleteProduct(int id){
         if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    public ProductDTO getProduct(int id){
        Product product = productRepository.findById(id)
                         .orElseThrow(()-> new RuntimeException("Product not found"));
        
        return mapToDTO(product);


    }

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        
        return products.stream().map(this::mapToDTO).toList();
    }
 
    public List<ProductDTO> getProductsByIds(List<Integer> ids) {
    return productRepository.findAllById(ids).stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
}

    public double getTotalPrice(List<Integer> ids){
        List<Product> products = productRepository.findAllById(ids);
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
