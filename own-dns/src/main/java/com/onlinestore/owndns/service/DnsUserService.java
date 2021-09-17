package com.onlinestore.owndns.service;

import com.onlinestore.owndns.exception.DnsUserNotFoundException;
import com.onlinestore.owndns.model.DnsUser;
import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import com.onlinestore.owndns.repository.DnsUserRepository;
import org.springframework.stereotype.Service;

/**v1
 * */

@Service
public class DnsUserService {

    private final DnsUserRepository dnsUserRepository;


    public DnsUserService(DnsUserRepository dnsUserRepository) {
        this.dnsUserRepository = dnsUserRepository;
    }

    public DnsUser findDnsUserById(Long id) {
        return dnsUserRepository.findDnsUserById(id).orElseThrow(
                () -> new DnsUserNotFoundException(getClass().getSimpleName() + " DnsUser with id: " + id + "not found"));
    }

    public DnsUser addDnsCustomer(DnsUser dnsUser) {
        dnsUser.setDnsUserRole(DnsUserRole.CUSTOMER);
        return dnsUserRepository.save(dnsUser);
    }

    public DnsUser addDnsAdmin(DnsUser dnsUser) {
        dnsUser.setDnsUserRole(DnsUserRole.ADMIN);
        return dnsUserRepository.save(dnsUser);
    }

    public void deleteDnsUserById(Long id) {
        dnsUserRepository.deleteById(id);
    }
}
