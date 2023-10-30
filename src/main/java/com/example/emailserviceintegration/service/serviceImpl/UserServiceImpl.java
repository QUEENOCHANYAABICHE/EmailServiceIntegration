package com.example.emailserviceintegration.service.serviceImpl;

import com.example.emailserviceintegration.domain.Confirmation;
import com.example.emailserviceintegration.domain.User;
import com.example.emailserviceintegration.dto.UserDTO;
import com.example.emailserviceintegration.repository.ConfirmationRepository;
import com.example.emailserviceintegration.repository.UserRepository;
import com.example.emailserviceintegration.service.EmailService;
import com.example.emailserviceintegration.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final EmailService emailService;


    @Override
    public User saveUser(UserDTO userDTO) {
        if(userRepository.existByEmail(userDTO.getEmail())){throw new RuntimeException("Email already in use");}
            User user = mapEntity2DTO(userDTO);
            user.setEnabled(false);
            userRepository.save(user);
            Confirmation confirmation = new Confirmation(user);
            confirmationRepository.save(confirmation);

            //Send Email to user with token
            emailService.sendSimpleMailMessage(user.getName(), user.getEmail(), confirmation.getToken());


            return user;
    }


    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        return true;
    }


    public User mapEntity2DTO(UserDTO userDTO){
       User user = new User();
       user.setName(userDTO.getName());
       user.setEmail(userDTO.getEmail());
       user.setPassword(userDTO.getPassword());
       return user;
    }
}
