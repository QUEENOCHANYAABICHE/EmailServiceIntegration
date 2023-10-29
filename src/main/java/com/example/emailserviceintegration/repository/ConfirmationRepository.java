package com.example.emailserviceintegration.repository;


import com.example.emailserviceintegration.domain.Confirmation;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {

    Confirmation findByToken(String token);
    Boolean existByEmail(String Email);
}
