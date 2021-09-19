package com.onlinestore.owndns.controllers;


import com.onlinestore.owndns.model.DnsUser;
import com.onlinestore.owndns.service.DnsUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**v1.1*
 * testing front and back
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    private final DnsUserService dnsUserService;

    public AccountController(DnsUserService dnsUserService) {
        this.dnsUserService = dnsUserService;
    }

    @GetMapping("/{Userid}")
    public ResponseEntity<DnsUser> getAccount(@PathVariable(name = "Userid") Long id){
        DnsUser foundDnsUser = dnsUserService.findDnsUserById(id);
        return new ResponseEntity<>(foundDnsUser, HttpStatus.OK);
    }
}
