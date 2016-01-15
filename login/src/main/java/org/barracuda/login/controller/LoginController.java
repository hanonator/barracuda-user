package org.barracuda.login.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers() {
        return "hello";
    }

}