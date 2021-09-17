package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**v1.1
 * + findSeller*/

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {


    Optional<Seller> findSellerById(Long id);
}
