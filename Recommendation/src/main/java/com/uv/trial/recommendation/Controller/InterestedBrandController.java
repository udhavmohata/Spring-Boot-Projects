package com.uv.trial.recommendation.Controller;

import com.uv.trial.recommendation.Exception.DataNotFoundException;
import com.uv.trial.recommendation.Model.InterestedBrandIP;
import com.uv.trial.recommendation.Model.InterestedBrandOP;
import com.uv.trial.recommendation.Model.UserDTO;
import com.uv.trial.recommendation.Util.InputCheckService;
import com.uv.trial.recommendation.Services.InterestedBrandService;
import com.uv.trial.recommendation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/interested")
public class InterestedBrandController {
    @Autowired
    LoginService loginService;
    @Autowired
    InterestedBrandService interestedBrandService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/show")
    public InterestedBrandOP showInterested(@RequestHeader(value = "Authorization") String code, @RequestBody InterestedBrandIP interestedBrandIP){
        inputCheckService.CategoryCheck(interestedBrandIP.getCategoryName());
        UserDTO userDTO = loginService.verifyUser(code);
        InterestedBrandOP interestedBrandOP = interestedBrandService.showInterestedService(userDTO, interestedBrandIP);
        if(interestedBrandOP == null)
            throw new DataNotFoundException();
        else
            return interestedBrandOP;
    }
}

