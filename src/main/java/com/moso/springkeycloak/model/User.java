package com.moso.springkeycloak.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
}
