package com.example.secutitytest.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "developers")
public class Developer {
@Id
@Column(name = "dev_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "first_name")
    private String firstName;
@Column(name = "last_name")
    private String lastName;


public Developer(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName=lastName;
}
}