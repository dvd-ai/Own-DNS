package com.onlinestore.owndns.controllers;

import com.onlinestore.owndns.jwt.JwtUtils;
import com.onlinestore.owndns.model.DnsUser;
import com.onlinestore.owndns.model.enum_.security.DnsUserRole;
import com.onlinestore.owndns.model.request.LoginRequest;
import com.onlinestore.owndns.model.request.SignupRequest;
import com.onlinestore.owndns.model.response.JwtResponse;
import com.onlinestore.owndns.model.response.MessageResponse;
import com.onlinestore.owndns.repository.DnsUserRepository;
import com.onlinestore.owndns.service.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**v1
 * */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final DnsUserRepository dnsUserRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, DnsUserRepository dnsUserRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.dnsUserRepository = dnsUserRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (dnsUserRepository.existsDnsUserByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (dnsUserRepository.existsDnsUserByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        DnsUser dnsUser = new DnsUser(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        String role = signUpRequest.getRole();

        if (role == null) {
            dnsUser.setDnsUserRole(DnsUserRole.CUSTOMER);
        }
        else {
            switch (role) {
                    case "admin":
                        dnsUser.setDnsUserRole(DnsUserRole.ADMIN);
                        break;
                    default:
                        dnsUser.setDnsUserRole(DnsUserRole.CUSTOMER);
                }
        }
        dnsUserRepository.save(dnsUser);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
