package com.onlinestore.owndns.repository;

import com.onlinestore.owndns.model.DnsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**v1.1
 * + exists by Username, email
 * */
@Repository
public interface DnsUserRepository extends JpaRepository<DnsUser, Long> {

    Optional<DnsUser> findDnsUserById(Long id);

    Optional<DnsUser> findDnsUserByUsername(String username);

    Boolean existsDnsUserByUsername(String username);

    Boolean existsDnsUserByEmail(String email);
}
