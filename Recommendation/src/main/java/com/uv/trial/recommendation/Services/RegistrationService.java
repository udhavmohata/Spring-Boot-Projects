package com.uv.trial.recommendation.Services;

import com.uv.trial.recommendation.Model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService
{
    public UserDTO newUser(UserDTO userDTO)
    {
        userDTO.setPassword(Integer.toString(userDTO.getPassword().hashCode()));
        return userDTO;
    }
}
