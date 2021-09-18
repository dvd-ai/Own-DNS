package com.onlinestore.owndns.controllers;

import com.onlinestore.owndns.model.DnsUser;
import com.onlinestore.owndns.service.DnsUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**for testing connection between front and back,
 * needs to be deleted*/

@RestController
public class TestController {

    private final DnsUserService dnsUserService;


    public TestController(DnsUserService dnsUserService) {
        this.dnsUserService = dnsUserService;
    }

    @GetMapping("/get-dns-user/{id}")
    public ResponseEntity<DnsUser> getProfileById(@PathVariable("id") Long id) {
        DnsUser dnsUser = dnsUserService.findDnsUserById(id);
        return new ResponseEntity<>(dnsUser, HttpStatus.OK);
    }
}
