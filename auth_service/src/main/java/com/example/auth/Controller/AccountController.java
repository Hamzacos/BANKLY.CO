package com.example.auth.Controller;

import com.example.auth.Entity.appUser;
import com.example.auth.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {


    @Autowired
    private AccountServiceImpl accountService;


    @PostMapping(path = "/register")
    public ResponseEntity<appUser> Register(@RequestBody appUser user){
        appUser newUser = accountService.addNewUser(user);
        return ResponseEntity.ok(newUser);
    }
}
