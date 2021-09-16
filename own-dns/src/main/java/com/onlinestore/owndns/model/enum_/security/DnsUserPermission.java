package com.onlinestore.owndns.model.enum_.security;
/**
 * v1*/
public enum DnsUserPermission {
    GUEST_READ("guest:read"),

    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),

    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),

    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),

    CATEGORY_READ("category:read"),
    CATEGORY_WRITE("category:write");

    private final String permission;

    DnsUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
