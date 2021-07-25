package com.sda.java3.ecommerce.services.order;

import com.sda.java3.ecommerce.domains.Order;
import com.sda.java3.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository clientRepository){
        this.orderRepository = clientRepository;
    }

    @Override
    public List<Order> getFeaturedOrders(){
        return orderRepository.findAll();
    }
}
