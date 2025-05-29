package com.store.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.orderservice.Clients.ProductClient;
import com.store.orderservice.Clients.UserClient;
import com.store.orderservice.DTOs.OrderDTO;
import com.store.orderservice.DTOs.OrderRequest;
import com.store.orderservice.Entity.Order;
import com.store.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Orderservice {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired UserClient userClient;
    @Autowired ProductClient productClient;

    public OrderDTO trackOrder(OrderRequest request, List<Integer> productIds) {
        Double totalPrice = productClient.getTotalPrice(productIds).getBody();
        if (totalPrice == null) {
            throw new RuntimeException("Failed to get total price from product service");
        }
        
        Order order = Order.builder()
                .userId(request.getUserId())
                .total(totalPrice)
                .build();
        Order savedOrder = orderRepository.save(order);

        return mapOrderDTO(savedOrder);
    }

    public List<OrderDTO> getUserOrders(int user_id){
        List<Order> orders= orderRepository.findByUserId(user_id);
        return orders.stream().map(this::mapOrderDTO).collect(Collectors.toList()); 
    }

    public OrderDTO getOrderById(int orderid){
        return orderRepository.findById(orderid).map(this::mapOrderDTO)
                .orElseThrow(()-> new RuntimeException("Order not found with id " + orderid));
    }

    public OrderDTO mapOrderDTO(Order order){
        OrderDTO dto = new OrderDTO();
        dto.setIdorder(order.getIdorder());
        dto.setUserId(order.getUserId());
        dto.setOrder_date(order.getOrder_date());
        dto.setTotal(order.getTotal());
        
        return dto;
    }
}
