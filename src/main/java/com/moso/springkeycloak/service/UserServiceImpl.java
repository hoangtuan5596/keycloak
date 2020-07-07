package com.moso.springkeycloak.service;

import com.moso.springkeycloak.model.User;

public class UserServiceImpl implements UserService{

    @Override
    public void login(User user) {
        user.getUserName();
        user.getPassword();
    }
}
