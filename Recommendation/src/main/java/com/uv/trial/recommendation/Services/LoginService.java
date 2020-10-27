package com.uv.trial.recommendation.Services;

import com.uv.trial.recommendation.EncoderDecoder.Base64Encryption;
import com.uv.trial.recommendation.Exception.InvalidUserException;
import com.uv.trial.recommendation.Model.Login;
import com.uv.trial.recommendation.Model.UserDTO;
import com.uv.trial.recommendation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;


@Service
public class LoginService
{
    @Autowired
    UserRepository userRepository;

    public UserDTO verifyUser(String Code) throws InvalidUserException{
        Base64Encryption base64Encryption = new Base64Encryption();
        String decoded = base64Encryption.Decode(Code);
        String[] str = decoded.split(":");
        UserDTO userDTO = userRepository.verifyUser(str[0], Integer.toString(str[1].hashCode()));
        if(userDTO==null)
            throw new InvalidUserException();
        else
            return userDTO;
    }


    public UserDTO getUserService(Login login){
        String Password = Integer.toString(login.getPassword().hashCode());
        UserDTO userDTO = userRepository.verifyUser(login.getMobileNumber(),Password);
        String encode = userDTO.getMobileNumber() + ":" + userDTO.getPassword();
        Base64Encryption base64Encryption = new Base64Encryption();
        String str =  base64Encryption.Encode(encode);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization:",str);
        return userDTO;
    }
}
