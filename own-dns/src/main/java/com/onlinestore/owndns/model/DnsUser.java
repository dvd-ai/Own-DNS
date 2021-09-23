package com.onlinestore.owndns.model;

import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**v1.2
 * + upd constructors*
 */

@Entity
@Getter
@Setter
@Table(name = "dns_user")
public class DnsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @NotNull(message = "Name must be between 4 and 20 characters")
    @Size(min = 4, max = 20)
    private String name;
    @OneToMany(mappedBy = "dnsUser")
    private Set<Order> orders;

    @Enumerated(EnumType.STRING)
    private DnsUserRole dnsUserRole;

    public DnsUser() {
    }

    public DnsUser(String username, String email, String name, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
