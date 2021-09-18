package com.onlinestore.owndns.model;

import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "Name must between 4 to 20 characters")
    @Size(min = 4,max = 20)
    private String name;
    @OneToMany(mappedBy = "dnsUser")
    private Set<Order> orders;

    @Enumerated(EnumType.STRING)
    private DnsUserRole dnsUserRole;
}
