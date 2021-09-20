package com.onlinestore.owndns.config;

import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                                .username("admin")
                                .password(encoder().encode("admin"))
                                .authorities(DnsUserRole.ADMIN.getAuthorities())
                                .build(),
                       User.builder()
                               .username("guest")
                               .password(encoder().encode("guest"))
                               .authorities(DnsUserRole.GUEST.getAuthorities())
                               .build(),
                       User.builder()
                               .username("customer")
                               .password(encoder().encode("customer"))
                               .authorities(DnsUserRole.CUSTOMER.getAuthorities())
                               .build()
                );



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic();
    }

    @Bean
    protected PasswordEncoder encoder(){
        return new BCryptPasswordEncoder(10);
    }
}
