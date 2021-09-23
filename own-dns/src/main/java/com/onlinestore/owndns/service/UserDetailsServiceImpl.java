package com.onlinestore.owndns.service;

import com.onlinestore.owndns.model.DnsUser;
import com.onlinestore.owndns.repository.DnsUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * v1*/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final DnsUserRepository dnsUserRepository;

    public UserDetailsServiceImpl(DnsUserRepository dnsUserRepository) {
        this.dnsUserRepository = dnsUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DnsUser user = dnsUserRepository.findDnsUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
