package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean signin(UserDTO userDTO) {
        // Aquí podrías hacer un POST con RestTemplate al backend si existiera un /login real
        // Por simplicidad, validamos si user y pass son "admin"
        return "admin".equals(userDTO.getUsername()) && "admin".equals(userDTO.getPassword());
    }
}
