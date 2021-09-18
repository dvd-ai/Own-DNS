package com.onlinestore.owndns.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20,message = "Name must between 4 and 20 chars")
    private String name;
    @OneToMany(mappedBy = "seller")
    private Set<Product> product;
}
