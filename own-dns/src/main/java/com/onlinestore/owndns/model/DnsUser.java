package com.onlinestore.owndns.model;

import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**v1.1
 * + DnsUserRole*/

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

    @Enumerated(EnumType.STRING)
    private DnsUserRole dnsUserRole;
}
