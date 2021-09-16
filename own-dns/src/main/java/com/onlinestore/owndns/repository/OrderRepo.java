package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**v1
 * */

public interface OrderRepo extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(Long id);
}
