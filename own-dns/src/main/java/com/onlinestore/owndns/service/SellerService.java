package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.SellerNotFoundException;
import com.onlinestore.owndns.model.Seller;
import com.onlinestore.owndns.repository.SellerRepository;
import org.springframework.stereotype.Service;

/**v1
 * */

@Service
public class SellerService {

    private final SellerRepository sellerRepository;


    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller findSellerById(Long id) {
        return sellerRepository.findSellerById(id).orElseThrow(
                ()-> new SellerNotFoundException(getClass().getSimpleName() + " Seller with id " + id + " not found!"));
    }

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller editSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteSellerById(Long id) {
        sellerRepository.deleteById(id);
    }
}
