package com.ces.almacen.controllers;

import com.ces.almacen.models.LoginModel;
import com.ces.almacen.models.UserModel;
import com.ces.almacen.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/login")
    public UserModel postLogin(@RequestBody LoginModel loginModel){

        UserModel userModel = new UserModel();
        userModel.setRol(loginModel.getRol());
        userModel.setToken("sfglahdy05y0hse809ht43yt.28hg08p2h802w2hg02hg032");
        return userModel;
    }
}
