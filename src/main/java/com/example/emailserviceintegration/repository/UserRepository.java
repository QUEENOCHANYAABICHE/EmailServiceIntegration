package com.example.emailserviceintegration.repository;


import com.example.emailserviceintegration.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmailIgnoreCase(String Email);
    Boolean existByEmail(String Email);

}
