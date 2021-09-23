package com.onlinestore.owndns.config;

import com.onlinestore.owndns.jwt.AuthEntryPointJwt;
import com.onlinestore.owndns.jwt.AuthTokenFilter;
import com.onlinestore.owndns.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    UserDetailsServiceImpl userDetailsService;
    private final AuthEntryPointJwt unauthorizedHandler;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthEntryPointJwt unauthorizedHandler) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.builder()
//                                .username("admin")
//                                .password(encoder().encode("admin"))
//                                .authorities(DnsUserRole.ADMIN.getAuthorities())
//                                .build(),
//                       User.builder()
//                               .username("guest")
//                               .password(encoder().encode("guest"))
//                               .authorities(DnsUserRole.GUEST.getAuthorities())
//                               .build(),
//                       User.builder()
//                               .username("customer")
//                               .password(encoder().encode("customer"))
//                               .authorities(DnsUserRole.CUSTOMER.getAuthorities())
//                               .build()
//                );
//
//
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


}
