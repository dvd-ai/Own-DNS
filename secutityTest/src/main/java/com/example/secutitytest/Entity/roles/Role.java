package com.example.secutitytest.Entity.roles;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permishion.DEVELOPERS_READ)),
    ADMIN(Set.of(Permishion.DEVELOPERS_READ,Permishion.DEVELOPERS_WRITE));

    private final Set<Permishion> permishionSet;

    Role(Set<Permishion> permishionSet){
        this.permishionSet=permishionSet;
    }

    public Set<Permishion> getPermissions(){
        return permishionSet;
}
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(o -> new SimpleGrantedAuthority(o.getPermission()))
                .collect(Collectors.toSet());

    }

}
