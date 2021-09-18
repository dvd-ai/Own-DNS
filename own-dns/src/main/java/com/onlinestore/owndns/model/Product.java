package com.onlinestore.owndns.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Setter
@Getter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long article;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @NotBlank
    private Double price;
    private boolean available;
    @NotBlank
    @Size(min = 5, max = 100)
    private String description;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @OneToMany(mappedBy = "product")
    private Set<Reviews> reviews;



}
