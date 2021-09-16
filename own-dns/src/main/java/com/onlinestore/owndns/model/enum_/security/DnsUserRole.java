package com.onlinestore.owndns.model.enum_.security;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

import static com.onlinestore.owndns.model.enum_.security.DnsUserPermission.*;

/**v1
 * */
public enum DnsUserRole {
    ADMIN(Sets.newHashSet(CUSTOMER_READ, CUSTOMER_WRITE,
            ORDER_READ, ORDER_WRITE,
            PRODUCT_READ, PRODUCT_WRITE,
            CATEGORY_READ, CATEGORY_WRITE)),
    GUEST(Sets.newHashSet()),
    CUSTOMER(Sets.newHashSet(CUSTOMER_READ, ORDER_READ, PRODUCT_READ, CATEGORY_READ));

    private final Set<DnsUserPermission> permissions;

    DnsUserRole(HashSet<DnsUserPermission> permissions) {
        this.permissions = permissions;
    }
}
