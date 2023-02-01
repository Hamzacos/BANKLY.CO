package com.example.auth.service;

import com.example.auth.Entity.appRole;
import com.example.auth.Entity.appUser;

import java.util.List;

public interface AccountService{
    appUser addNewUser(appUser user);
    appRole addNewRole(appRole role);
    void addRoleToUser(String username,String RoelName);
    appUser loadUserByUsername(String username);
    List<appUser> listUser();
}
