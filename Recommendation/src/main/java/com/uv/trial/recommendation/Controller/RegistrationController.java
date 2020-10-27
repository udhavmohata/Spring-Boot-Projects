package com.uv.trial.recommendation.Controller;


import com.uv.trial.recommendation.Model.UserDTO;
import com.uv.trial.recommendation.Repository.UserRepository;
import com.uv.trial.recommendation.Util.InputCheckService;
import com.uv.trial.recommendation.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/signup")
public class RegistrationController
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/create")
    public UserDTO SignUp(@Valid @RequestBody UserDTO userDTO)
    {
        inputCheckService.GenderCheck(userDTO.getGender());
        inputCheckService.MobileNumberCheck(userDTO.getMobileNumber());
        UserDTO userDTO1 = registrationService.newUser(userDTO);
        return userRepository.save(userDTO1);
    }

}
