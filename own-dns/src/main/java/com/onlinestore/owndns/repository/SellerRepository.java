package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**v1*/

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
