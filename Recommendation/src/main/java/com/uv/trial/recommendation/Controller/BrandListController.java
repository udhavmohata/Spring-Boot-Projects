package com.uv.trial.recommendation.Controller;

import com.uv.trial.recommendation.Exception.DataNotFoundException;
import com.uv.trial.recommendation.Model.BrandListIP;
import com.uv.trial.recommendation.Model.BrandListOP;
import com.uv.trial.recommendation.Model.UserDTO;
import com.uv.trial.recommendation.Services.BrandListService;
import com.uv.trial.recommendation.Util.InputCheckService;
import com.uv.trial.recommendation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandlist")
public class BrandListController
{
    @Autowired
    BrandListService brandListService;
    @Autowired
    LoginService loginService;
    @Autowired
    InputCheckService inputCheckService;

    @PostMapping("/show")
    public List<BrandListOP> showList(@RequestHeader(value = "Authorization") String code, @RequestBody BrandListIP brandListIP){
        inputCheckService.CategoryCheck(brandListIP.getCategoryName());
        UserDTO userDTO = loginService.verifyUser(code);
        List<BrandListOP> brandListOPS = brandListService.showListService(userDTO,brandListIP);
        if(brandListOPS.isEmpty())
            throw new DataNotFoundException();
        else
            return brandListOPS;
    }

    @PostMapping("/show/auto")
    public List<BrandListOP> showAutoList(@RequestHeader(value = "Authorization") String code,@RequestBody BrandListIP brandListIP){
        inputCheckService.CategoryCheck(brandListIP.getCategoryName());
        UserDTO userDTO = loginService.verifyUser(code);
        List<BrandListOP> brandListOPS = brandListService.showAutoListService(userDTO,brandListIP);
        if(brandListOPS.isEmpty())
            throw new DataNotFoundException();
        else
            return brandListOPS;
    }
}
