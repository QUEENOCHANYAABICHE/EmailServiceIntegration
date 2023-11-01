package com.example.emailserviceintegration.service;


import com.example.emailserviceintegration.domain.User;
import com.example.emailserviceintegration.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User saveUser(UserDTO userDTO);
    Boolean verifyToken(String token);
}
