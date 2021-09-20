package com.onlinestore.owndns;

import com.onlinestore.owndns.model.Category;
import com.onlinestore.owndns.model.DnsUser;

import com.onlinestore.owndns.service.DnsUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class OwnDnsApplicationTests {

@Autowired
DnsUserService dnsUserService;


	@Test
	void testAccountController(){
		TestRestTemplate template = new TestRestTemplate("admin","admin");
		ResponseEntity<DnsUser> response = template
				.getForEntity("http://localhost:7777/account/1",DnsUser.class);
		System.out.println(response.getBody().getName());
	}

	@Test
	void contextLoads() {


	}



}
