package com.uv.trial.recommendation.Controller;

import com.uv.trial.recommendation.Repository.UserRepository;
import com.uv.trial.recommendation.Services.LoginService;
import com.uv.trial.recommendation.Model.Login;
import com.uv.trial.recommendation.Model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    LoginService loginService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/signin")
    public UserDTO getUser(@RequestBody Login login){
        return loginService.getUserService(login);
    }

    @DeleteMapping("/delete")
    public void Delete(@RequestHeader(value = "Authorization") String code)
    {
        UserDTO userDTO = loginService.verifyUser(code);
        userRepository.deleteById(userDTO.getUserId());
    }
}
