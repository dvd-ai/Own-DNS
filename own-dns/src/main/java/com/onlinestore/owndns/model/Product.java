package com.onlinestore.owndns.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Setter
@Getter
public class Product {
    @Id
    private Long id;

    private Long article;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Double price;
    private boolean available;
    private String description;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @OneToMany(mappedBy = "product")
    private Set<Reviews> reviews;



}
