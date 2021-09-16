package com.onlinestore.owndns.model;

import com.onlinestore.owndns.model.enum_.data.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**v1
 * needs imports to Product, dnsUser
 * */

@Entity
@Setter
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "dnsuser_id", nullable = false)
    private DnsUser dnsUser;

    private int amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus order_status;
}
