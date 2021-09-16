package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.OrderNotFoundException;
import com.onlinestore.owndns.model.Order;
import com.onlinestore.owndns.repository.OrderRepo;
import org.springframework.stereotype.Service;

/**v1*/
@Service
public class OrderService {

    private final OrderRepo orderRepo;


    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order findOrderById(Long id) {
        return orderRepo.findOrderById(id).
                orElseThrow(()-> new OrderNotFoundException(
                        getClass().getSimpleName() + ": Order with id " + id + "not found"));
    }
}
