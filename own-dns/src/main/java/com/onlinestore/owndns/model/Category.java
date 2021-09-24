package com.onlinestore.owndns.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**v1.1*
 * + Json ignore
 */

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @NotBlank
    private String name;
    private String image;
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;
}
