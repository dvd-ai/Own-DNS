package com.onlinestore.owndns.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "dns_user")
public class DnsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "dnsUser")
    private Set<Order> orders;
}
